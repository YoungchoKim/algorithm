import java.io.*;
import java.util.*;

class Pair{
	int r;
	int c;
	
	public Pair(int r, int c){
		this.r = r;
		this.c = c;
	}
}
public class Main {
	public static final int R = 12;
	public static final int C = 6;
	public static boolean mVisited[][];
	public static char[][] mMap;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mMap = new char[R][C];
		mVisited = new boolean[R][C];
		
		for(int i = 0; i < R; i++){
			String s = br.readLine();
			for(int j = 0; j < C; j++){
				mMap[i][j] = s.charAt(j);
			}
		}
		
		int result = 0;
		while(bfs()){	//bfs 돌려서 true이면 
			result++;		//연쇄 증가 
			
			for(int c = C-1; c >= 0; c--){			//맵에서 0 제
				int k = R-1;
				for(int r = R-1; r >= 0; r--){
					if(mMap[r][c] != '0' && mMap[r][c] != '.'){
						mMap[k][c] = mMap[r][c];
						k--;
					}
				}

				while(k >= 0){
					mMap[k][c] = '.';
					k--;
				}
				
				
			}
		}
		System.out.println(result);
		
		
//		for(int i = 0; i < R; i++){
//			for(int j = 0 ; j < C; j++){
//				System.out.print(mMap[i][j]);
//				
//			}System.out.println();
//		}
	}
	
	public static boolean bfs(){
		Queue q = new LinkedList();
		boolean isYeonShoe = false;
		for(int r = 0; r < R; r++){
			for(int c = 0; c < C; c++){
				
				if(mMap[r][c] != '.' && !mVisited[r][c]){
				
					LinkedList list = new LinkedList();
					list.add(new Pair(r,c));			// 방문한 점 저장하는 리스
					q.add(new Pair(r,c));
					mVisited[r][c] = true;
					while(!q.isEmpty()){
						Pair pair = (Pair)q.poll();
						int dx[] = {0, 0, 1, -1};
						int dy[] = {1, -1, 0, 0};
						for(int i = 0 ; i < 4; i++){
							int nextR = pair.r + dy[i];
							int nextC = pair.c + dx[i];
							
							if(nextR < 0 || nextR >= R || nextC < 0 || nextC >=C
									||mVisited[nextR][nextC] || mMap[r][c] != mMap[nextR][nextC]){
								continue;
							}
							mVisited[nextR][nextC] = true;
							q.add(new Pair(nextR, nextC));
							list.add(new Pair(nextR, nextC));
						}
					}
					if(list.size() >= 4){
						for(int i = 0; i < list.size(); i++){
							Pair pair = (Pair)list.get(i);
							mMap[pair.r][pair.c] = '0';
							isYeonShoe = true;
						}
					}
					list.clear();
				}
			}
		}
		for(int r = 0; r < R; r++){
			for(int c = 0; c < C; c++){
				mVisited[r][c] = false;
			}
		}
		return isYeonShoe;
	}
}
