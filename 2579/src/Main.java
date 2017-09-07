import java.io.*;
public class Main {
	public static int N;
	public static int[] mArray;
	public static long[] d;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mArray = new int[N+1];
		d = new long[N + 1];
		
		for(int i = 1; i < N + 1 ;i++){
			mArray[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(go(N));
		
	}
	public static long go(int n){
		if(d[n] > 0){
			return d[n];
		}
		if(n == 1){
			d[n] = mArray[n];
			return d[n];
		}
		else if(n == 2){
			d[n] = mArray[1] + mArray[2];
			return d[n];
		}
		else if(n == 3){
			int max = mArray[1] + mArray[3];
			if(max < mArray[2] + mArray[3]){
				max = mArray[2] + mArray[3];
			}
			d[3] = max;
			return d[n];
		}
		
		else{
			long max = go(n-2) + mArray[n];
			if(max < go(n-3) + mArray[n] + mArray[n-1]){
				max = go(n-3) + mArray[n] + mArray[n-1];
			}
			d[n] = max;
			
		}
		return d[n];
	}

}
