import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 

'.': 빈 공간
'#': 벽
'@': 상근이의 시작 위치
'*': 불

 * @author Cho
 *
 */
class Pair{
	int c;
	int r;
	boolean isFirePair;
	
	public Pair(int r, int c, boolean isFirePair){
		this.r = r;
		this.c = c;
		this.isFirePair = isFirePair;
	}
}
public class Main {
	public static BufferedReader mBr;
	public static char mMap[][];
	public static int mVisited[][];
	public static boolean mFire[][];
	public static int mC;
	public static int mR;
	public static Queue<Pair> mQ;
	public static int mResult;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		mBr = new BufferedReader(new InputStreamReader(System.in));
		mQ = new LinkedList<Pair>();
		int testCase = Integer.parseInt(mBr.readLine());
		
		for(int i = 0; i < testCase; i++){
			input();
			if(solve()){
				
				output();
			}
			
			mResult = 0;
			mQ.clear();
		}
	}
	public static void input() throws IOException{
		StringTokenizer st = new StringTokenizer(mBr.readLine(), " ");
		mC = Integer.parseInt(st.nextToken());
		mR = Integer.parseInt(st.nextToken());
		mMap = new char[mR][mC];
		mVisited = new int[mR][mC];
		mFire = new boolean[mR][mC];
		for(int i = 0; i < mR; i++){
			String s = mBr.readLine();
			for(int j = 0 ; j < mC; j++){
				mMap[i][j] = s.charAt(j);
			}
		}
	}
	public static boolean solve(){
		Pair startPair = null;
		for(int i = 0; i < mR; i++){
			for(int j = 0; j < mC; j++){
				if(mMap[i][j] == '*'){
					mFire[i][j] = true;
					mQ.add(new Pair(i, j, true));
				}
				else if(mMap[i][j] == '@'){
					startPair = new Pair(i, j, false);
					mVisited[i][j] = 1;
				}
			}
		}
		mQ.add(startPair);
		if(startPair.r == 0 || startPair.r == mR-1 || startPair.c == 0 || startPair.c == mC-1){
			System.out.println(1);
			return false;
		}
		
		while(!mQ.isEmpty()){
			Pair temp = mQ.poll();
			int dx[] = {1, -1, 0, 0};
			int dy[] = {0, 0, 1, -1};
			
			for(int i = 0; i < 4; i++){
				int nextR = temp.r + dy[i];
				int nextC = temp.c + dx[i];
				if(nextR < 0 || nextR >= mR || nextC <0 || nextC >= mC 
						|| mMap[nextR][nextC] == '#' || mFire[nextR][nextC] == true){
					continue;
				}
				if((temp.isFirePair == true )&& mFire[nextR][nextC] == false){
					mQ.add(new Pair(nextR, nextC, true));
					mFire[nextR][nextC] = true;
				}
				
				if(temp.isFirePair == false && mVisited[nextR][nextC] == 0
						&&	mFire[nextR][nextC] == false){
					mQ.add(new Pair(nextR, nextC, false));
					mVisited[nextR][nextC] = mVisited[temp.r][temp.c]+1;
					if(nextR == 0 || nextC == 0 || nextR == mR -1 || nextC == mC-1){
						mResult = mVisited[nextR][nextC];
						mQ.clear();	// q비워서 while문 탈출
						break;
					}
				}
				
			}
			
		}
		return true;
	}
	
	
	public static void output(){
		if(mResult == 0){
			System.out.println("IMPOSSIBLE");
		}
		else{
			System.out.println(mResult);
		}
	}
}
