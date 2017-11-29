import java.io.*;
import java.util.*;


/**
 * 1. 첫 구현시 뱀을 배열에서 관리하여 이전 포인트의 값을 저장했었는데, 구현이 제대로 되지 않았다.
 * 	스터디 후 리스트나 데큐를 활용하여 쉽게 꼬리를 찾을 수 있음을 배웠다.
 * 
 * 2. 마지막 명령 수행 후 뱀은 벽 또는 자신의 몸이 있는 곳까지 이동해야하는데,
 *     벽 이동만 처리하고, 몸까지의 이동은 처리를 하지 않았다. -> 처리완료 
 *
 * 3. 마지막 명령 수행 후 뱀은 벽 또는 자신의 몸이 있는 곳까지 이동해야하는데,
 * 	이동할 때 사과일 경우와 사과가 아닐경우를 처리하지 않았다. -> 처리완료 
 * 
 * 4. 입력부에서 시간을 입력받을때 3 D 4 D 이면 3초후 오른쪽, 그이후 4초후 오른쪽 으로 이해했었는데,
 * 	출발 시점에서 3초 후 , 출발시점에서 4초 후였다. 3 D , 4 D 는 결국 3초 이동하고 오른쪽 1초 이동하고 오른쪽의 의미..
 * 	삽질 엄청했다... ㅡㅡ^ 
 * 
 * @author cho
 */
public class Main {
	public static int N;
	public static int mNumberOfApple;
	public static int mNumberOfAction;
	public static boolean[][] mIsApple;
	public static Action[] mAction;
	public static Head mHead;
	
	public static LinkedList<Pair> mSnake;
	public static final int EAST = 0;
	public static final int NORTH = 1;
	public static final int WEST = 2;
	public static final int SOUTH = 3;
	
	public static void main(String[] args) throws IOException{
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mIsApple = new boolean[N + 1][N + 1];
		mNumberOfApple = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0; i < mNumberOfApple; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			mIsApple[r][c] = true;
		}
		
		mNumberOfAction = Integer.parseInt(br.readLine());
		mAction = new Action[mNumberOfAction];
		for(int i = 0; i < mNumberOfAction; i++){
			st = new StringTokenizer(br.readLine(), " ");
			mAction[i] = new Action(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		
		
		mSnake = new LinkedList<Pair>();
		mHead = new Head();
		mHead.r =1; mHead.c = 1; mHead.direction = EAST;
		mSnake.add(new Pair(1, 1));
		
		long cnt = 0;
		int actionTime = 0;
		for(int i = 0; i < mNumberOfAction; i++){
			if(i == 0){
				actionTime = mAction[i].second;
			}
			else{
				actionTime = mAction[i].second - mAction[i-1].second;
			}
			for(int j = 0; j < actionTime; j++){	// 현재 방향으로 이동
				move(mHead.direction);		//지렁의의 몸을 늘려 다음칸 이동 
				cnt++;
				if(mHead.r <1 || mHead.r > N || mHead.c < 1 || mHead.c > N){ // 벽 일 경우 
					System.out.println(cnt);
					return;
				}
				if(isSnakeBody(mHead)){	// 몸일 경우 
					System.out.println(cnt);
					return;
				}
				if(mIsApple[mHead.r][mHead.c]){	// 사과일 경우 
					mIsApple[mHead.r][mHead.c] = false;	//사과 제거 
					mSnake.addLast(new Pair(mHead.r, mHead.c));
				}
				else{		//아무것도 아닐 경우 
					mSnake.removeFirst();		//꼬리 제거 
					mSnake.addLast(new Pair(mHead.r, mHead.c));
				}
				
			}
			if(mAction[i].action == 'L'){		//왼쪽방향 전환 
				mHead.direction = (mHead.direction + 1) %4;
			}
			else{		//오른쪽 방향 전환 
				mHead.direction = (mHead.direction + 3) % 4;
			}
		}
		cnt++;
		move(mHead.direction);
		
		while(mHead.r <= N && mHead.r > 0 && mHead.c <= N && mHead.c > 0 
				&& !isSnakeBody(mHead)){
			if(mIsApple[mHead.r][mHead.c]){	// 사과일 경우 
				mIsApple[mHead.r][mHead.c] = false;	//사과 제거 
				mSnake.addLast(new Pair(mHead.r, mHead.c));
			}
			else{		//사과  아닐 경우 
				mSnake.removeFirst();		//꼬리 제거 
				mSnake.addLast(new Pair(mHead.r, mHead.c));
			}
			cnt++;
			move(mHead.direction);
		}
		System.out.println(cnt);
	}
	
//	public static final int EAST = 0;
//	public static final int NORTH = 1;
//	public static final int WEST = 2;
//	public static final int SOUTH = 3;
	public static void move(int dir){
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		
		mHead.r += dy[dir];
		mHead.c += dx[dir];
	}
	
	public static boolean isSnakeBody(Head head){
		for(int i = 0; i < mSnake.size(); i++){
			Pair pair = (Pair)mSnake.get(i);
			if(head.r == pair.r && head.c == pair.c){
				return true;
			}
		}
		return false;
	}
}

class Action{
	int second;
	char action;
	public Action(int second, char action){
		this.second = second;
		this.action = action;
	}
}

class Pair{
	int r;
	int c;
	public Pair(int r, int c){
		this.r = r;
		this.c = c;
	}
}

class Head{
	int r;
	int c;
	int direction;
}
