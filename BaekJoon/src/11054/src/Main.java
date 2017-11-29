import java.util.*;
import java.io.*;
public class Main {
	public static int N;
	public static int[] mArray;
	public static int[] dpInc;
	public static int[] dpDec;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		mArray = new int[N + 1];
		dpInc = new int[N + 1];
		dpDec = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++){
			mArray[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for(int i = 1; i < N + 1; i++){
			inc(i);
			dec(i);
			max = Math.max(max, dpInc[i] + dpDec[i] -1);
				
		}
		
		System.out.println(max);
	
	}
	public static int inc(int n){
		if(dpInc[n] > 0){
			return dpInc[n];
		}
		dpInc[n] = 1;
		for(int i = n-1; i > 0; i--){
			if(mArray[i] < mArray[n]){
				dpInc[n] = Math.max(dpInc[n], inc(i) + 1);
			}
		}
		
		return dpInc[n];
	}
	public static int dec(int n){
		if(dpDec[n] > 0){
			return dpDec[n];
		}
		
		dpDec[n] = 1;
		for(int i = n+1; i <= N; i++){
			if(mArray[n] > mArray[i]){
				dpDec[n] = Math.max(dpDec[n], dec(i) + 1);
			}
		}
		
		
		return dpDec[n];
	}

}
