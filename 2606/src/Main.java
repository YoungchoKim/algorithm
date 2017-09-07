import java.util.*;
import java.io.*;
class Pair{
	int r;
	int c;
	
	public Pair(int r, int c){
		this.r = r;
		this.c = c;
	}
}
public class Main {
	public static int mTotalComputers, mTotalNetworks;
	public static boolean mMap[][];
	public static boolean mVisited[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mTotalComputers = Integer.parseInt(br.readLine());
		mTotalNetworks = Integer.parseInt(br.readLine());
		mMap = new boolean[mTotalComputers + 1][mTotalComputers + 1];
		mVisited = new boolean[mTotalComputers + 1];
		StringTokenizer st;
		for(int i = 0; i < mTotalNetworks; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			mMap[r][c] = true;
		}
		Queue<Pair> q = new LinkedList();
		mVisited[1] = true;
		for(int i = 1; i <= mTotalComputers; i++ ){
			if(mMap[1][i] == true || mMap[i][1]){
				q.add(new Pair(1, i));
				mVisited[i] = true;
			}
		}
		while(!q.isEmpty()){
			Pair pair = q.poll();
			for(int i =1; i <= mTotalComputers; i++){
				if((mMap[pair.c][i] == true || mMap[i][pair.c])&& mVisited[i] == false){
					mVisited[i] = true;
					q.add(new Pair(pair.c, i));
				}
			}
		}
		int count = 0;
		for(int i = 1; i <= mTotalComputers; i++ ){
			if(mVisited[i] == true){
				count++;
			}
		}
		
		System.out.println(count -1);
		
		
	}

}
