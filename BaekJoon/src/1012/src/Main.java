import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * ������ ������ �ѳ��� ������ �������� ����� ���߸� ����ϱ�� �Ͽ���. ����� ���� �ʰ� ���߸� ����Ϸ��� ���߸� �������κ��� ��ȣ�ϴ� ���� �߿��ϱ� ������, �ѳ��� ���� ������ ȿ������ �����������̸� �����ϱ�� ����Ѵ�. �� �����̴� ���߱�ó�� �����ϸ� ������ ��� �������ν� ���߸� ��ȣ�Ѵ�. Ư��, � ���߿� �����������̰� �� ������ ��� ������ �� �����̴� ������ �ٸ� ���߷� �̵��� �� �־�, �� ���ߵ� ���� �������κ��� ��ȣ���� �� �ִ�.
(�� ������ �����¿� �� ���⿡ �ٸ� ���߰� ��ġ�� ��쿡 ���� �������ִٰ� �����Ѵ�)
�ѳ��� ���߸� ����ϴ� ���� ���� ���ؼ� ���߸� �������� �ɾ���Ҵ�. ���ߵ��� ���ִ� ������ �����������̰� �� ������ ������ �ǹǷ� ���� �������ִ� ���ߵ��� �� ������ �����ִ��� �����ϸ� �� �� ������ �����̰� �ʿ����� �� �� �ִ�.
���� ��� ���߹��� �Ʒ��� ���� �����Ǿ� ������ �ּ� 5������ �����������̰� �ʿ��ϴ�.
(0�� ���߰� �ɾ��� ���� ���� ���̰�, 1�� ���߰� �ɾ��� �ִ� ���� ��Ÿ����.)

1	1	0	0	0	0	0	0	0	0
0	1	0	0	0	0	0	0	0	0
0	0	0	0	1	0	0	0	0	0
0	0	0	0	1	0	0	0	0	0
0	0	1	1	0	0	0	1	1	1
0	0	0	0	1	0	0	1	1	1

�Է�: 
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

���:
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
	 * �������� �ʱ�ȭ �޼ҵ�
	 */
	public static void init(){
		mCountOfWorms = 1;
		mMap = null;
		M = 0; N = 0; K = 0;
	}
	/**
	 * �Է� �޼ҵ�
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
	 * dfs�� �̿��� �� Ž��
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
	 * queue�� �̿��� bfs Ž��
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
	 * ���� ���߹� ���� �ȿ��ְ�, �� ���� 1���� ����
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
	 * ��� �޼ҵ�
	 * �ʱⰪ�� 1�̾����� -1 �Ͽ� ���
	 */
	public static void output(){
		System.out.println(mCountOfWorms - 1);
	}
}

