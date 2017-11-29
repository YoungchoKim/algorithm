import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Cho
 *<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
 *철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
 *여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
 *대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
 *지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
3
7
8
9
 */
public class Main {

	public final static int mMax = 25;	
	public static int[][] mMap;			//지도
	public static int[][] mCopyMap;		//카피한 지도
	public static int mSize;			//지도 크기 mSize X mSize
	public static ArrayList<Integer> mResult;	//단지 내 집의 수를 저장하는 list
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		solve();
		output();
		
	}
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mSize = Integer.parseInt(br.readLine());
		mResult = new ArrayList<Integer>();
		mMap = new int[mSize][mSize];
		mCopyMap = new int[mSize][mSize];
		
		for(int i = 0; i < mSize ; i++){
			String s = br.readLine();
			for(int j = 0; j < mSize; j++){
				mMap[i][j] = s.charAt(j) - '0';
			}
		}
		
//		mMap = new int[][]{
//			{0, 1, 1, 0, 1, 0, 0},
//			{0, 1, 1, 0, 1, 0, 1},
//			{1, 1, 1, 0, 1, 0, 1},
//			{0, 0, 0, 0, 1, 1, 1},
//			{0, 1, 0, 0, 0, 0, 0},
//			{0, 1, 1, 1, 1, 1, 0},
//			{0, 1, 1, 1, 0, 0, 0}
//		};
//		mCopyMap = new int[7][7];
	}
	public static void output(){
		
		Collections.sort(mResult);
		System.out.println(mResult.size());
		for(int i = 0; i < mResult.size(); i++){
			System.out.println(mResult.get(i));
		}
		
	}

	public static void solve(){
		copyMap();
		for(int i = 0; i < mSize; i++){
			for(int j = 0; j < mSize ; j++){
				if(mCopyMap[i][j] == 1){
					bfs(i , j);	
				}
			}
		}
	}
	
	
	public static void copyMap(){
		if(mSize <=0){
			return;
		}
		
		for(int i = 0; i < mSize; i++){
			for(int j = 0; j < mSize ; j++){
				mCopyMap[i][j] = mMap[i][j];
			}
		}
	}
	
	public static void bfs(int i, int j){
		int count = 0;	//단지내 집의수를 count하는 변수
		Queue queue;
		queue = new LinkedList<Dot>();
		queue.add(new Dot(i, j));
		mCopyMap[i][j] = 3;
		count++;
		while(!queue.isEmpty()){
			Dot tempDot = (Dot)queue.poll();
			if(inspectRange(tempDot.i + 1, tempDot.j)){
				queue.add(new Dot(tempDot.i + 1, tempDot.j));
				mCopyMap[tempDot.i + 1][tempDot.j] = 3;
				count++;
			}
			if(inspectRange(tempDot.i - 1, tempDot.j)){
				queue.add(new Dot(tempDot.i - 1, tempDot.j));
				mCopyMap[tempDot.i - 1][tempDot.j] = 3;
				count++;
			}
			if(inspectRange(tempDot.i, tempDot.j + 1)){
				queue.add(new Dot(tempDot.i, tempDot.j + 1));
				mCopyMap[tempDot.i][tempDot.j + 1] = 3;
				count++;
			}
			if(inspectRange(tempDot.i, tempDot.j - 1)){
				queue.add(new Dot(tempDot.i, tempDot.j - 1));
				mCopyMap[tempDot.i][tempDot.j - 1] = 3;
				count++;
			}
		}
		if(count > 0){
			mResult.add(count);
		}
		
	}
	
	public static boolean inspectRange(int i, int j){
		if(i >=0 && i < mSize && j >=0 && j < mSize){
			if(mCopyMap[i][j] == 1){
				return true;
			}
		}
		return false;
	}
	
	public static class Dot{
		public int i;
		public int j;
		
		public Dot(int i, int j){
			this.i = i;
			this.j = j;
		}
	}

}
