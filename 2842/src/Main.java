// 1. 최단 거리가 아님... 갔던 길 또 갈수 있음
// 2. 도착했을때의 최소 (갔던 길로 돌아오면 된다.)
// 2. 

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
	public static int N;
	public static char[][] mMap;
	public static int[][] mHeight;	//고도 저장 배열
	public static int[][] mHeightCopy;
	public static boolean[][] mVisited;	//dfs 방문한곳 체크용 배열
	public static Pair mSrc;	//출발지 저장
	public static LinkedList<Pair> mListDist;	//목적지 저장 list
	public static LinkedList<Integer> mListHeight;	//높이 저장 list
	
	public static int mStartValueLow = Integer.MAX_VALUE;
	public static int mStartValueHigh;
	
	public static int mMinResult = Integer.MAX_VALUE;
	public static int mCountK;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mMap = new char[N][N];
		mHeightCopy = new int[N][N];
		mVisited = new boolean[N][N];
		mHeight = new int[N][N];
		mListDist = new LinkedList();
		mListHeight = new LinkedList();
		
		for(int i = 0; i < N; i++){
			String s = br.readLine();
			for(int j = 0; j < N ; j++){
				mMap[i][j] = s.charAt(j);
				if(mMap[i][j] == 'P'){	//출발지 저장
					mSrc = new Pair(i, j);
				}
				if(mMap[i][j] == 'K'){	//목적지 저장
					mListDist.add(new Pair(i, j));
				}
			}
		}
		StringTokenizer st;
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++){	//높이 저장
				mHeight[i][j] = Integer.parseInt(st.nextToken());
				
				if(!mListHeight.contains(mHeight[i][j])){
					mListHeight.add(mHeight[i][j]);
				}
			}
		}
		
		mListHeight.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2){
					return 1;
				}
				else if (o1 < o2){
					return -1;
				}
				return 0;
			}
		});
		
		for(int i = 0; i < mListDist.size(); i++){
			int r = mListDist.get(i).r;
			int c = mListDist.get(i).c;
			if(mHeight[r][c]< mStartValueLow){
				mStartValueLow = mHeight[r][c];
			}
			if(mHeight[r][c] > mStartValueHigh){
				mStartValueHigh = mHeight[r][c];
			}
		}
		
		dfs(mStartValueLow, mStartValueHigh);

		
		System.out.println(mMinResult);
		
	}
	public static void dfs(int lowValue, int highValue){
		copyHeight(lowValue, highValue);
		mVisited[mSrc.r][mSrc.c] = true;
		fill(mSrc.r, mSrc.c);
		if(mCountK == mListDist.size()){
			if(mMinResult > (highValue - lowValue)){
				mMinResult = highValue - lowValue;
				return;
			}
		}
		else{
			mCountK = 0;
		}
		int nextLow = mListHeight.indexOf(lowValue) - 1;
		int nextHigh = mListHeight.indexOf(highValue) + 1;
		//System.out.println("nextLow:" + nextLow + " nextHigh" + nextHigh);
		if(nextLow >= 0){
			dfs(mListHeight.get(nextLow), highValue);
		}
		if(nextHigh < mListHeight.size() ){
			dfs(lowValue, mListHeight.get(nextHigh));
		}
		
		
		
	}
	public static void fill(int r, int c){
		int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
		int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
		
		for(int i = 0; i < 8; i++){
			int nextR = r + dy[i];
			int nextC = c + dx[i];
			
			if(nextR < 0 || nextR >=N || nextC < 0 || nextC >=N
					|| mVisited[nextR][nextC] || mHeightCopy[nextR][nextC] == 0){
				continue;
			}
			if(mMap[nextR][nextC] == 'K'){
				mCountK++;
				mVisited[nextR][nextC] = true;
				fill(nextR, nextC);
			}
			else{
				mVisited[nextR][nextC] = true;
				fill(nextR, nextC);
			}
		}
	}
	public static void copyHeight(int lowValue, int highValue){
		for(int r = 0; r < N; r++){
			for(int c = 0; c < N; c++){
				mHeightCopy[r][c] = 0;
				mVisited[r][c] = false;
				if(mHeight[r][c] >= lowValue && mHeight[r][c] <= highValue){
					mHeightCopy[r][c] = mHeight[r][c];
				}
			}
		}
	}
}
