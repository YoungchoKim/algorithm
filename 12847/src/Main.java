import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static long mMax;		//최대 이익
	public static int mPeriodTotal;	//총 기간
	public static int mPeriodWorking;	//일할 수 있는 기간
	public static long mCost[];		//비용
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		mPeriodTotal = Integer.parseInt(st.nextToken());
		mPeriodWorking = Integer.parseInt(st.nextToken());
		mCost = new long[mPeriodTotal];
		st = new StringTokenizer(br.readLine(), " ");
		
		
		for(int i = 0; i < mPeriodTotal; i++){
			mCost[i] = Long.parseLong(st.nextToken());
		}
		
		for(int i = 0; i <mPeriodTotal - mPeriodWorking + 1; i++){
			mMax = Math.max(mMax, dfs(i, 0 ,mPeriodWorking -1));
		}
		
//		for(int i = 0; i < mPeriodTotal - mPeriodWorking + 1; i++){
//			long temp = 0L;
//			for(int j = i; j < i + mPeriodWorking ; j++ ){
//				temp += mCost[j];
//			}
//			//System.out.println(temp);
//			if(temp > mMax){
//				mMax = temp;
//			}
//		}
		System.out.println(mMax);
	}
	public static long dfs( int i,int current ,int goal){
		int max = 0;
		if(current == goal){
			return mCost[i];
		}
		max += mCost[i] + dfs(i + 1, current + 1, goal);
		return max;
	}
}



