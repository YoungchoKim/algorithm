import java.io.*;
import java.util.*;


/**
 * 1. ù ������ ���� �迭���� �����Ͽ� ���� ����Ʈ�� ���� �����߾��µ�, ������ ����� ���� �ʾҴ�.
 * 	���͵� �� ����Ʈ�� ��ť�� Ȱ���Ͽ� ���� ������ ã�� �� ������ �����.
 * 
 * 2. ������ ��� ���� �� ���� �� �Ǵ� �ڽ��� ���� �ִ� ������ �̵��ؾ��ϴµ�,
 *     �� �̵��� ó���ϰ�, �������� �̵��� ó���� ���� �ʾҴ�. -> ó���Ϸ� 
 *
 * 3. ������ ��� ���� �� ���� �� �Ǵ� �ڽ��� ���� �ִ� ������ �̵��ؾ��ϴµ�,
 * 	�̵��� �� ����� ���� ����� �ƴҰ�츦 ó������ �ʾҴ�. -> ó���Ϸ� 
 * 
 * 4. �Էºο��� �ð��� �Է¹����� 3 D 4 D �̸� 3���� ������, ������ 4���� ������ ���� �����߾��µ�,
 * 	��� �������� 3�� �� , ��߽������� 4�� �Ŀ���. 3 D , 4 D �� �ᱹ 3�� �̵��ϰ� ������ 1�� �̵��ϰ� �������� �ǹ�..
 * 	���� ��û�ߴ�... �Ѥ�^ 
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
			for(int j = 0; j < actionTime; j++){	// ���� �������� �̵�
				move(mHead.direction);		//�������� ���� �÷� ����ĭ �̵� 
				cnt++;
				if(mHead.r <1 || mHead.r > N || mHead.c < 1 || mHead.c > N){ // �� �� ��� 
					System.out.println(cnt);
					return;
				}
				if(isSnakeBody(mHead)){	// ���� ��� 
					System.out.println(cnt);
					return;
				}
				if(mIsApple[mHead.r][mHead.c]){	// ����� ��� 
					mIsApple[mHead.r][mHead.c] = false;	//��� ���� 
					mSnake.addLast(new Pair(mHead.r, mHead.c));
				}
				else{		//�ƹ��͵� �ƴ� ��� 
					mSnake.removeFirst();		//���� ���� 
					mSnake.addLast(new Pair(mHead.r, mHead.c));
				}
				
			}
			if(mAction[i].action == 'L'){		//���ʹ��� ��ȯ 
				mHead.direction = (mHead.direction + 1) %4;
			}
			else{		//������ ���� ��ȯ 
				mHead.direction = (mHead.direction + 3) % 4;
			}
		}
		cnt++;
		move(mHead.direction);
		
		while(mHead.r <= N && mHead.r > 0 && mHead.c <= N && mHead.c > 0 
				&& !isSnakeBody(mHead)){
			if(mIsApple[mHead.r][mHead.c]){	// ����� ��� 
				mIsApple[mHead.r][mHead.c] = false;	//��� ���� 
				mSnake.addLast(new Pair(mHead.r, mHead.c));
			}
			else{		//���  �ƴ� ��� 
				mSnake.removeFirst();		//���� ���� 
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
