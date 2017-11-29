import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static int mTestCase;
	public static Scanner sc;
	public static int mMapSize;
	public static int mMap[][];
	public static Point mSrcPoint;
	public static Point mDistPoint;
	public static int mCount;
	public static BufferedReader br;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		mTestCase = Integer.parseInt(br.readLine());
		for(int i = 0; i < mTestCase; i++){
			input();
			solve();
			output();
			mCount = 0;
			for(int j = 0; j < mMapSize; j++){
				for(int k = 0; k < mMapSize; k++){
					mMap[j][k] = 0;
				}
			}
		}
	}
	public static void output(){
		System.out.println(mMap[mDistPoint.i][mDistPoint.j]);
	}
	
	public static void solve(){

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(mSrcPoint.i, mSrcPoint.j));
		if(mSrcPoint.i == mDistPoint.i && mSrcPoint.j == mDistPoint.j){
			return;
		}
		
		while(!q.isEmpty()){
			int di[] = {1, 1, -1, -1, 2, 2, -2, -2};
			int dj[] = {-2, 2, 2, -2, 1, -1, 1, -1};
			Point tempPoint = q.poll();
			
			
			for(int i = 0; i < 8; i++){
				int nextI = tempPoint.i + di[i];
				int nextJ = tempPoint.j + dj[i];
				
				if(nextI < 0 || nextI >= mMapSize ||
						nextJ <0 || nextJ >= mMapSize){
					continue;
				}
				if(nextI == mDistPoint.i && nextJ == mDistPoint.j){
					mMap[nextI][nextJ] = mMap[tempPoint.i][tempPoint.j] + 1;
					q.clear();
					return;
				}
				else if(mMap[nextI][nextJ] == 0){
					q.add(new Point(nextI, nextJ));
					mMap[nextI][nextJ] = mMap[tempPoint.i][tempPoint.j] + 1;
				}
			}
			mCount++;
		}
	}
	
	public static void input() throws IOException{

		mMapSize = Integer.parseInt(br.readLine());
		mMap = new int[mMapSize][mMapSize];
		for(int i = 0; i < mMapSize; i++){
			for(int j = 0; j < mMapSize; j++){
				mMap[i][j] = 0;
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		mSrcPoint = new Point();
		mSrcPoint.i = Integer.parseInt(st.nextToken());
		mSrcPoint.j = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		mDistPoint = new Point();
		mDistPoint.i = Integer.parseInt(st.nextToken());
		mDistPoint.j = Integer.parseInt(st.nextToken());
	}
}
class Point{
	public int i;
	public int j;
	
	public Point(){
		
	}
	public Point(int i, int j){
		this.i = i;
		this.j = j;
	}
}