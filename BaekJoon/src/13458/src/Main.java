import java.io.*;
import java.util.*;
public class Main {
	public static int N;
	public static int mBossCost, mCost;
	public static int[] mRoom;
	public static long mSum;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		mRoom = new int[N];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++){
			mRoom[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		mBossCost = Integer.parseInt(st.nextToken());
		mCost = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++){
			mRoom[i] -= mBossCost;
			mSum++;
			
			if(mRoom[i] <= 0){
				
			}
			else{
				if(mRoom[i] % mCost == 0){
					mSum = mSum + (mRoom[i] / mCost);
				}
				else{
					mSum = mSum + (mRoom[i] / mCost) + 1;
				}
			}
		}
		System.out.println(mSum);
		
		
		
	}

}
