import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pair{
	int c;
	int r;
	public Pair(int r, int c){
		this.r = r;
		this.c = c;
	}
}
public class Main {
	public static int mMapSize;
	public static int mMap[][];
	public static int mVisited[][];
	public static Queue<Pair> mQ;
	public static int mResult;
	public static int mCountLand;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mQ = new LinkedList<Pair>();
		mMapSize = Integer.parseInt(br.readLine());
		mMap = new int[mMapSize][mMapSize];
		mVisited = new int[mMapSize][mMapSize];
		mResult = mMapSize * 2;
		
		for(int i = 0; i < mMapSize; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
			for(int j = 0; j < mMapSize; j++){
				mMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i < mMapSize; i++){
			for(int j = 0; j < mMapSize; j++){
				if(mMap[i][j] == 1){
					
					mMap[i][j] = --mCountLand;
					mQ.add(new Pair(i, j));
					mVisited[i][j] = 1;
					while(!mQ.isEmpty()){
						Pair temp = mQ.poll();
						int dx[] = {0, 0, 1, -1};
						int dy[] = {1, -1, 0, 0};
						
						for(int k =0 ; k < 4; k++){
							int r = temp.r + dy[k];
							int c = temp.c + dx[k];
							if(r < 0 || r >= mMapSize || c <0 || c >= mMapSize 
									|| mMap[r][c] <= 0 ){
								continue;
							}
							if(mMap[r][c] == 1){
								mQ.add(new Pair(r,c));
								mMap[r][c] = mMap[temp.r][temp.c];
							}
						}
					}
				}
			}
		}
		
//		for(int a = 0; a < mMapSize; a++){
//			for(int b = 0; b < mMapSize; b++){
//				System.out.print(mMap[a][b] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		mQ.clear();
		for(int i = 0; i < mMapSize; i++){
			for(int j = 0; j < mMapSize; j++){
				if(mMap[i][j] < 0 ){
					mVisited[i][j] = 1;
					mQ.add(new Pair(i, j));
				}
			}
		}
		
	
		
		while(!mQ.isEmpty()){
			Pair temp = mQ.poll();
			int dx[] = {0, 0, 1, -1};
			int dy[] = {1, -1, 0, 0};
			
			for(int i = 0; i < 4; i++){
				int r = temp.r + dy[i];
				int c = temp.c + dx[i];
				
				if(r < 0 || r >= mMapSize || c < 0 || c >= mMapSize
						|| mMap[r][c] == mMap[temp.r][temp.c]){
					continue;
				}
				if(mMap[r][c] == 0){
					mQ.add(new Pair(r,c));
					mMap[r][c] = mMap[temp.r][temp.c];
					mVisited[r][c] = mVisited[temp.r][temp.c] + 1;
				}
				if(mMap[r][c] != mMap[temp.r][temp.c]){
					int tmp = mVisited[r][c] + mVisited[temp.r][temp.c];
					if(tmp < mResult){
						mResult = tmp;
					}
				}
				
			}
		}
		
//		for(int a = 0; a < mMapSize; a++){
//			for(int b = 0; b < mMapSize; b++){
//				System.out.print(mVisited[a][b] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		
		if(mResult == 0){
			System.out.println(0);
		}
		else
			System.out.println(mResult-2);
	}

}
