import java.util.*;
import java.io.*;

class Pair{
	int r;
	int c;
	int cnt;
	public Pair(int r, int c, int cnt){
		this.cnt = cnt;
		this.r = r;
		this.c = c;
	}
}


public class Main {
	public static int R, C;
	public static char[][] mMap;
	public static boolean[][] mVisited;
	public static Queue mQ;
	public static LinkedList  mList;
	public static int mResult; // 
	/**
	 * @param args
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mMap = new char[R][C];
		mVisited = new boolean[R][C];
		mList = new LinkedList();
		mQ = new LinkedList();
		for(int r = 0; r < R; r++){	//맵정보를 입력받으며 육지일 경우 리스트에 추가
			String s = br.readLine();
			for(int c = 0; c < C; c++){
				mMap[r][c] = s.charAt(c);
				if(mMap[r][c] == 'L'){	
					mList.add(new Pair(r, c, 0));	
				}
				
			}
		}
		for(int i = 0; i < mList.size(); i++){	//각각의 육지마다 bfs를 돌려본다.
			Pair temp = (Pair)mList.get(i);
			mQ.add(temp);
			mVisited[temp.r][temp.c] = true;
			
			
			while(!mQ.isEmpty()){
				Pair pair = (Pair)mQ.poll();
				int[] dy = {0, 0, 1, -1};
				int[] dx = {1, -1, 0, 0};
				for(int j = 0; j < 4; j++){
					int nextR = pair.r + dy[j];
					int nextC = pair.c + dx[j];
					if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C
							|| mVisited[nextR][nextC] || mMap[nextR][nextC] == 'W'){
						continue;
					}
					mQ.add(new Pair(nextR, nextC, pair.cnt + 1));
					mVisited[nextR][nextC] = true;
					if(mResult < pair.cnt +1){
						mResult = pair.cnt + 1;
					}
					
					
				}
				
			}
			for(int r =0; r < R; r++){
				for(int c = 0; c < C; c++){
					mVisited[r][c] = false;
				}
			}
			
		}
		System.out.println(mResult	);

		
	}

}
