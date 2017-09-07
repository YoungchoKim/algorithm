import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int M, N, H;
	public static int mMap[][][];
	public static Queue<Point> q;
	public static int mCountDay;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
		if(solve()){
			output();
		}
		
	}
	/**
	 * 
	 * @return 모두 다 익었을 경우 출력 후 return false를 하여 output함수 실행하지 않음
	 * 		   모두 다 익지 않았을 경우는 output함수를 통해 출력
	 */
	public static boolean solve(){
		q = new LinkedList<Point>();
		int count = 0;
		for(int h = 0; h < H; h++){
			for(int r = 0; r < N; r++){
				for(int c = 0; c < M; c++){
					if(mMap[h][r][c] == 1){
						q.add(new Point(h, r, c));
						count++;
					}
					if(mMap[h][r][c] == -1){
						count++;
					}
				}
			}
		}
		if(!(count == H * M * N)){	//익지 않은 토마토가 존재하는 경우
			bfs();
		}
		else{	// 모두 익어 있는 경우
			System.out.println(0);
			return false;
		}
		return true;
	}
	
	public static void bfs(){
		while(!q.isEmpty()){
			Point p = q.poll();
			int dh[] = {1, -1, 0, 0, 0, 0};
			int dr[] = {0, 0, 1, -1, 0, 0};
			int dc[] = {0, 0, 0, 0, 1, -1};
			for(int i = 0; i < 6; i++){
				int nextH = p.h + dh[i];
				int nextR = p.r + dr[i];
				int nextC = p.c + dc[i];
				if(nextH < 0 || nextH >= H ||
						nextR < 0 || nextR >= N ||
						nextC < 0 || nextC >=M){
					continue;
				}
				if(mMap[nextH][nextR][nextC] == 0){
					q.add(new Point(nextH, nextR, nextC));
					mMap[nextH][nextR][nextC] = mMap[p.h][p.r][p.c] + 1;
				}
			}
		}
		
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		mMap = new int[H][N][M];
		for(int h = 0; h < H; h++){
			for(int r = 0; r < N; r++){
				st = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < M; c++){
					mMap[h][r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		
	}
	
	public static void output(){
		int result = 0;
		for(int h = 0; h < H; h++){
			for(int r = 0 ; r < N; r++){
				for(int c = 0; c < M; c++){
					if(mMap[h][r][c] > result ){
						result = mMap[h][r][c];
						
					}
					if(mMap[h][r][c] == 0){
						result = -1;
						break;
					}
				}
				if(result == -1){
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
			System.out.println(result - 1);
		}
	}
}
class Point{
	public int r;
	public int c;
	public int h;
	
	public Point(int h, int r, int c){
		this.r = r;
		this.c = c;
		this.h = h;
	}
}