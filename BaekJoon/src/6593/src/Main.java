import java.io.*;
import java.util.*;
class Pair{
	int l;
	int r;
	int c;
	
	public Pair(int l, int r, int c){
		this.l = l;
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static int L, R, C;
	public static char[][][] mMap;
	public static int[][][] mVisited;
	public static Pair mSrc, mDist;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		while(true){
			st= new StringTokenizer(br.readLine(), " ");
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0){
				break;
			}
			mMap = new char[L][R][C];
			mVisited = new int[L][R][C];
			
			for(int l = 0; l < L; l++){
				for(int r = 0; r < R; r++){
					String s = br.readLine();
					for(int c = 0; c < C; c++){
						mMap[l][r][c] = s.charAt(c);
						if(mMap[l][r][c] == 'S'){
							mSrc = new Pair(l, r, c);
						}
						else if(mMap[l][r][c] == 'E'){
							mDist = new Pair(l, r, c);
						}
					}
				}
				br.readLine();
			}
		////////////////////////////////////////////////////////////////////////
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(mSrc);
			mVisited[mSrc.l][mSrc.r][mSrc.c] = 1;
			while(!q.isEmpty()){
				Pair pair = q.poll();
				
				int dx[] = {0, 0, 0, 0, 1, -1};
				int dy[] = {0, 0, 1, -1, 0, 0};
				int dz[] = {1, -1, 0, 0, 0, 0};
				for(int i = 0; i < 6; i++){
					int nextL = pair.l + dz[i];
					int nextR = pair.r + dy[i];
					int nextC = pair.c + dx[i];
					if(nextL < 0 || nextL >= L || nextR <0 || nextR >= R
							|| nextC <0 || nextC >= C || mVisited[nextL][nextR][nextC] > 0
							|| mMap[nextL][nextR][nextC] == '#' ){
						continue;
					}

					if(nextR == mDist.r && nextL == mDist.l && nextC == mDist.c){
						mVisited[nextL][nextR][nextC] = mVisited[pair.l][pair.r][pair.c]+ 1;
						q.clear();
					}
					else{
						q.add(new Pair(nextL, nextR, nextC));
						mVisited[nextL][nextR][nextC] = mVisited[pair.l][pair.r][pair.c]+ 1;
					}
				}
			}
			if((mVisited[mDist.l][mDist.r][mDist.c]) == 0){
				System.out.println("Trapped!");
			}
			else{
				System.out.println("Escaped in "+ (mVisited[mDist.l][mDist.r][mDist.c] - 1) +" minute(s).");
			}
		}
		
	}

}
