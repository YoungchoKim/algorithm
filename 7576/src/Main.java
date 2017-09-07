import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int M,N;
	public static BufferedReader mBr;
	public static int mMap[][];

	public static Queue<Point> mQueue;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		mQueue = new LinkedList();
		input();
		solve();
		
		
		
	}
	
	public static void input() throws IOException{
		mBr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(mBr.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		mMap = new int[N][M];

		for(int i = 0 ; i < N; i++){
			st = new StringTokenizer(mBr.readLine(), " ");
			for(int j = 0 ; j < M; j++){
				mMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	/**
	 * 입력정보 중 토마토 위치를 큐에 넣고 bfs시작
	 */
	public static void solve(){
		int count = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(mMap[i][j] == 1){
					mQueue.add(new Point(i, j));

					count++;
				}
				else if(mMap[i][j] == -1){
					count++;
				}
			}
		}
		if(!(count == M * N)){
			bfs();
			output();
		}
		else{		//모두다 익어있는 경우
			System.out.println(0);
		}
	}
	/**
	 * 주어진 map에서 상, 하, 좌, 우로 소요 일수를 map에 마킹
	 */
	public static void bfs(){
		int dx[] = {0, 0, -1, 1};
		int dy[] = {1, -1, 0, 0};
		while(!mQueue.isEmpty()){
			Point point = mQueue.poll();
			for(int i = 0; i < 4; i++){
				if(point.r + dy[i] >=0 && point.r + dy[i] < N &&
						point.c +dx[i] >=0 && point.c +dx[i] <M &&
						mMap[point.r+dy[i]][point.c+dx[i]] == 0){
					
					mMap[point.r+dy[i]][point.c+dx[i]] = mMap[point.r][point.c] + 1;
					mQueue.add(new Point(point.r+dy[i],point.c+dx[i]));
				}
				
			}
		}
	}
	
	/**
	 * 지도에 마킹된 값들 중 가장 큰 값을 출력
	 */
	public static void output(){
		int result = 0;
		for(int i = 0 ; i < N; i++){
			for(int j = 0; j < M; j++){
				if( result < mMap[i][j]){
					result = mMap[i][j];
				}
				else if(mMap[i][j] == 0){	// 익지 않은 토마토가 있는 경우
					result = -1;
					break;
				}
			}
			if(result == -1){
				break;
			}
		}
		if(result == -1){
			System.out.println(result);
		}
		else{
			System.out.println(result-1);	
		}
		
	}

}
/**
 * row와 col을갖는 point 클래스
 * @author Cho
 *
 */
class Point{
	int r;
	int c;
	
	public Point(int r, int c){
		this.r = r;
		this.c = c;
	}
}