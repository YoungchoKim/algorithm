import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static char mMap[][];
	public static char mMap1[][];	//정상인
	public static char mMap2[][];		//적녹색약
	
	public static int N;
	public static int mCountMap1, mCountMap2;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		input();
		solve();
		output();
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mMap = new char[N][N];
		mMap1 = new char[N][N];	
		mMap2 = new char[N][N];
		
		
		for(int i = 0; i < N; i++){
			String s = br.readLine();
			for(int j =0; j < N; j++){
				mMap[i][j] = s.charAt(j);
				mMap1[i][j] = mMap[i][j];
				mMap2[i][j] = mMap[i][j];
				if(mMap2[i][j] == 'G'){	//입력 변환
					mMap2[i][j] = 'R';
				}
			}
		}
	}
	public static void solve(){
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N ; j++){
				char value[] = {'R', 'G', 'B'};
				for(int k = 0; k < 3; k++){
					if(mMap1[i][j] == value[k]){
						//mMap1[i][j] = (char)(mCountMap1 + '0');
						mMap1[i][j] = '9';
						dfs(mMap1, new Point(i, j), value[k], mCountMap1);
						mCountMap1++;
					}
					if(mMap2[i][j] == value[k]){
						//mMap1[i][j] = (char)(mCountMap1 + '0');
						mMap2[i][j] = '9';
						
						dfs(mMap2, new Point(i, j), value[k], mCountMap2);
						mCountMap2++;
					}
					
				}
			}
		}
	}
	/**
	 * 
	 * @param myMap		탐색할 map
	 * @param p			현재 위치 정보
	 * @param mapValue	'R' or 'G' or 'B'
	 * @param count		현재 찾은 구역의 수
	 */
	public static void dfs(char[][] myMap, Point p, char mapValue, int count){
		int dx[] = {0, 0, -1, 1};
		int dy[] = {1, -1, 0, 0};
		for(int i = 0; i < 4; i++){
			if(p.i + dy[i] >=0 && p.i + dy[i] < N
					&& p.j + dx[i] >=0 && p.j + dx[i] < N
					&& myMap[p.i + dy[i]][p.j + dx[i]] == mapValue){
				
				//myMap[p.i + dy[i]][p.j + dx[i]] = (char)(count + '0');
				myMap[p.i + dy[i]][p.j + dx[i]] = ('9');
				dfs(myMap, new Point(p.i + dy[i], p.j + dx[i]), mapValue, count);
			}
		}
	}
	
	public static void output(){
		System.out.println((mCountMap1) + " "+ (mCountMap2));
	}

}
class Point{
	int i;
	int j;
	
	public Point(int i, int j){
		this.i = i;
		this.j = j;
	}
}