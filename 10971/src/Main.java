import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static int mMapSize;
	public static int mMap[][];
	public static int mVisited[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mMapSize = Integer.parseInt(br.readLine());
		mMap = new int[mMapSize][mMapSize];
		mVisited = new int[mMapSize][mMapSize];
		StringTokenizer st;
		for(int i = 0; i < mMapSize; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < mMapSize; j++){
				mMap[i][j] = Integer.parseInt(st.nextToken());
				mVisited[i][j] = mMap[i][j];
			}
		}
		
		System.out.println(dfs( 0 , 0, mMapSize - 1, 0));
	}
	public static int dfs(int index, int count, int goal, int sum ){
		int min = Integer.MAX_VALUE;
		if(count == goal){
			if(mMap[index][0] > 0){
			
				return sum + mMap[index][0];
			}
			return min;
		}

		for(int i = 1; i < mMapSize; i++){
		
			if(mVisited[index][i] != 0){
				mVisited[index][i] = 0;
				for(int j = 0; j < mMapSize; j++){
					mVisited[j][index] = 0;
				}
				min = Math.min(min, dfs(i, count + 1, goal, sum + mMap[index][i] ));
				mVisited[index][i] = mMap[index][i];
				for(int j = 0; j < mMapSize; j++){
					mVisited[j][index] = mMap[j][index];
				}
			}
		}	
		return min;
	}
}
