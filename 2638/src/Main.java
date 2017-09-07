import java.util.*;
import java.io.*;
class Pair{
	int r;
	int c;
	int cnt;
	public Pair(int r, int c, int cnt){
		this.r = r;
		this.c = c;
		this.cnt  = cnt;
	}
}
public class Main {
	public static int R, C;
	
	public static boolean[][] mAir;		//공기 배열
	public static int[][] mMap;
	

	public static Queue mQAir;		// 녹인 치즈위치 저장 후 공기 퍼트릴 Q
	public static Queue mQCheese;		// 치즈들 저장 할 Q
	
	public static int mCurrentHour = -1;		//현재 진행중인 시간 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mAir = new boolean[R][C];
		mMap = new int[R][C];
		
		mQAir = new LinkedList();
		mQCheese = new LinkedList();
		
		
		for(int r = 0; r < R; r++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0; c < C; c++){
				mMap[r][c] = Integer.parseInt(st.nextToken());
				if(mMap[r][c] == 1){
					mQCheese.add(new Pair(r, c, 0));
				}
			}
		}
		mQAir.add(new Pair(0, 0, 0));		//처음 공기 큐에 공기 하나 넣어줌
		while(!mQCheese.isEmpty()){
			Pair pair = (Pair)mQCheese.poll();
			if(mCurrentHour < pair.cnt){	//시간 체크 
				spreadAir();
				mCurrentHour = pair.cnt;
			}
		
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			
			int cnt   = 0;
			for(int i = 0; i < 4; i++){
				int nextR = pair.r + dy[i];
				int nextC = pair.c + dx[i];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >=C
						|| mMap[nextR][nextC] == 1){
					continue;
				}
				
				if(mAir[nextR][nextC]){
					cnt++;
				}
				
			}
			if(cnt >=2){	//녹을경
				mQAir.add(new Pair(pair.r, pair.c, pair.cnt));
			}
			else{		//녹지 않을 경우 
				mQCheese.add(new Pair(pair.r, pair.c, pair.cnt + 1));
			}
		}
		
		System.out.println(mCurrentHour + 1);
		
	}
	public static void spreadAir(){	//녹인 치즈들부터 bfs
		
		while(!mQAir.isEmpty()){
			Pair pair = (Pair)mQAir.poll();
			mAir[pair.r][pair.c] = true;
			mMap[pair.r][pair.c] = 0;
			//가장자리는 공기
			int dx[] = {1, -1, 0, 0};
			int dy[] = {0, 0, 1, -1};
		
			for(int i = 0; i < 4; i++){
				int nextR = pair.r + dy[i];
				int nextC = pair.c + dx[i];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C
						|| mAir[nextR][nextC] || mMap[nextR][nextC] == 1){
					continue;
				}
				mAir[nextR][nextC] = true;
				mQAir.add(new Pair(nextR, nextC, 0));
			}
		}
	
	}

}

