import java.util.*;
import java.io.*;
class Pair{
	int r;
	int c;
	int[] key;
	int cnt;
	
	public Pair(int r, int c, int[] key, int cnt){	// key -> 0~5 : a~f    
																						// key 없을 경우: g
		this.r = r;
		this.c = c;
		this.key = key;
		this.cnt = cnt;
	}
}
public class Main {
	public static char[][] mMap;
	public static boolean[][][][][][][][][] mVisited;
	public static int R, C;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mMap = new char[R][C];
		mVisited = new boolean[R][C][2][2][2][2][2][2][2];
		Queue q = new LinkedList();
		
		for(int i = 0; i < R; i++){
			String s = br.readLine();
			for(int j = 0; j < C; j++){
				mMap[i][j] = s.charAt(j);
				if(mMap[i][j] == '0'){
					mVisited[i][j][0][0][0][0][0][0][1] = true;
					int[] key =new int[7];
					key['g' - 'a'] = 1;
					
					q.add(new Pair(i, j, key, 0));
					mMap[i][j] = '.';
				}
			}
		}
		
		while(!q.isEmpty()){
			Pair pair = (Pair)q.poll();
			
			if(mMap[pair.r][pair.c] == '1'){
				System.out.println(pair.cnt);
				return;
			}
			
			int[] dy = {1, -1, 0, 0};
			int[] dx = {0, 0, 1, -1};
			
			for(int i = 0; i < 4; i++){
				int nextR = pair.r + dy[i];
				int nextC = pair.c + dx[i];
				
				//키가 추가되 방문 초기화, 기존에 키가 있으면 초기화 안해도 됨
				//방문 배열은 행, 열, 가지고있는 키에 따라 체크 
				if(nextR < 0 || nextR >=R || nextC < 0 || nextC >=C
						||mVisited[nextR][nextC][pair.key[0]][pair.key[1]][pair.key[2]][pair.key[3]][pair.key[4]][pair.key[5]][pair.key[6]]
								|| mMap[nextR][nextC] == '#'){
					continue;
				}
				
				
				// 다음 이동할 장소가 길이거나 목적지 일 경우 
				if(mMap[nextR][nextC] == '.' || mMap[nextR][nextC] == '1'){
					mVisited[nextR][nextC][pair.key[0]][pair.key[1]][pair.key[2]][pair.key[3]][pair.key[4]][pair.key[5]][pair.key[6]] = true;
					q.add(new Pair(nextR, nextC, pair.key, pair.cnt + 1));
				}
				// 다음 이동 장소가 열쇠일 경우
				if(mMap[nextR][nextC] >= 'a' && mMap[nextR][nextC] <= 'f'){
					// 보유하고있는 열쇠지만 방문하지 않은경우
					int keyIndex = mMap[nextR][nextC] - 'a';
					if(pair.key[keyIndex] == 1){
						pair.key[keyIndex] = 1;
						mVisited[nextR][nextC][pair.key[0]][pair.key[1]][pair.key[2]][pair.key[3]][pair.key[4]][pair.key[5]][pair.key[6]] = true;
						q.add(new Pair(nextR, nextC, pair.key, pair.cnt + 1));	
					}
					else{// 보유하지 않은 열쇠인 경우 
						int[] temp = (int[])pair.key.clone();
						temp[keyIndex] = 1;
						mVisited[nextR][nextC][temp[0]][temp[1]][temp[2]][temp[3]][temp[4]][temp[5]][temp[6]] = true;
						q.add(new Pair(nextR, nextC, temp, pair.cnt + 1));	
					
					}
				
				}
				if(mMap[nextR][nextC] >= 'A' && mMap[nextR][nextC] <= 'F'){
					if(pair.key[mMap[nextR][nextC] -'A'] ==1){
						mVisited[nextR][nextC][pair.key[0]][pair.key[1]][pair.key[2]][pair.key[3]][pair.key[4]][pair.key[5]][pair.key[6]] = true;
						q.add(new Pair(nextR, nextC, pair.key, pair.cnt + 1));	
					}
				}
				
			}
			
			
		}
		System.out.println(-1);
//		for(int i = 0; i < C; i++){
//			System.out.print(" " + mVisited[0][i][0][0][0][0][0][1][1]);
//		}
	}

}
