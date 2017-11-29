import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다. 이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다.
(한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있다고 간주한다)
한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어놓았다. 배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다.
(0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.)

1	1	0	0	0	0	0	0	0	0
0	1	0	0	0	0	0	0	0	0
0	0	0	0	1	0	0	0	0	0
0	0	0	0	1	0	0	0	0	0
0	0	1	1	0	0	0	1	1	1
0	0	0	0	1	0	0	1	1	1

입력: 
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5

출력:
5
1

 * @author Cho
 *
 */
public class Main {
	public static int mCountOfWorms = 1;
	public static int T, M, N, K;
	public static int mMap[][];
	public static BufferedReader mBr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//mSc = new Scanner(System.in);
		mBr = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(mBr.readLine());
		for (int i = 0; i < T; i++){
			init();
			input();
			solve();
			output();
			
		}
		
	}
	/**
	 * 전역변수 초기화 메소드
	 */
	public static void init(){
		mCountOfWorms = 1;
		mMap = null;
		M = 0; N = 0; K = 0;
	}
	/**
	 * 입력 메소드
	 */
	public static void input() throws IOException{
		StringTokenizer st = new StringTokenizer(mBr.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		mMap = new int[N][M];
		
		for(int row = 0; row < N; row++){
			for(int col = 0; col < M; col++){
				mMap[row][col] = 0;
			}
		}
		for(int i = 0; i < K; i++){
			st = new StringTokenizer(mBr.readLine(), " ");
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			mMap[row][col] = 1;
		}
		
		
		
		
//		M = 10;
//		N = 8;
//		K = 17;
//		
//		mMap = new int[N][M];
//		mMap[0][0] = 1;
//		mMap[0][1] = 1;
//		mMap[1][1] = 1;
//		mMap[2][4] = 1;
//		mMap[3][4] = 1;
//		mMap[5][4] = 1;
//		mMap[4][2] = 1;
//		mMap[4][3] = 1;
//		mMap[4][7] = 1;
//		mMap[4][8] = 1;
//		mMap[4][9] = 1;
//		mMap[5][7] = 1;
//		mMap[5][8] = 1;
//		mMap[5][9] = 1;
//		mMap[6][7] = 1;
//		mMap[6][8] = 1;
//		mMap[6][9] = 1;
//		
//		M = 10;
//		N = 10;
//		K = 1;
//		mMap = new int[10][10];
//		mMap[5][5] = 1;
		
	}
	
	public static void solve(){
		for(int row = 0; row < N; row++){
			for(int col = 0; col < M; col++){
				if(mMap[row][col] == 1){
					mCountOfWorms++;
					mMap[row][col] = mCountOfWorms;
					
					dfs(row, col);
					//bfs(row, col);
				}
				
			}
		}
	}
	/**
	 * dfs로 이웃한 점 탐색
	 * @param row
	 * @param col
	 */
	public static void dfs(int row, int col){
		if(inspectRange(row + 1, col)){
			mMap[row + 1][col] = mCountOfWorms;
			dfs(row + 1, col);
		}
		if(inspectRange(row - 1, col)){
			mMap[row - 1][col] = mCountOfWorms;
			dfs(row - 1, col);
		}
		if(inspectRange(row, col + 1)){
			mMap[row][col + 1] = mCountOfWorms;
			dfs(row, col + 1);
		}
		if(inspectRange(row, col - 1)){
			mMap[row][col - 1] = mCountOfWorms;
			dfs(row, col - 1);
		}
		
	}
	
	/**
	 * queue를 이용한 bfs 탐색
	 * @param row
	 * @param col
	 */
	public static void bfs(int row, int col){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(row);
		queue.add(col);
		
		while(!queue.isEmpty()){
			int tempRow = queue.poll();
			int tempCol = queue.poll();
			
			if(inspectRange(tempRow + 1, tempCol)){
				mMap[tempRow + 1][tempCol] = mCountOfWorms;
				dfs(tempRow + 1, tempCol);
			}
			if(inspectRange(tempRow - 1, tempCol)){
				mMap[tempRow - 1][tempCol] = mCountOfWorms;
				dfs(tempRow - 1, tempCol);
			}
			if(inspectRange(tempRow, tempCol + 1)){
				mMap[tempRow][tempCol + 1] = mCountOfWorms;
				dfs(tempRow, tempCol + 1);
			}
			if(inspectRange(tempRow, tempCol - 1)){
				mMap[tempRow][tempCol - 1] = mCountOfWorms;
				dfs(tempRow, tempCol - 1);
			}		
			
		}
	}
	/**
	 * 점이 배추밭 범위 안에있고, 그 값이 1인지 조사
	 * @param i 
	 * @param j 
	 * @return
	 */
	public static boolean inspectRange(int row, int col){
		if(row < 0 || row >= N || col < 0 || col >=M
				|| mMap[row][col] != 1){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 출력 메소드
	 * 초기값이 1이었으니 -1 하여 출력
	 */
	public static void output(){
		System.out.println(mCountOfWorms - 1);
	}
}

