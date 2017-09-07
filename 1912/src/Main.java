import java.util.*;
import java.io.*;
public class Main {
	public static int N;
	public static long[] d;
	public static int[] mArray;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mArray = new int[N + 1];
		d = new long[N + 1];
		Arrays.fill(d, Long.MIN_VALUE);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1 ; i++){
			mArray[i] = Integer.parseInt(st.nextToken());
		}
		long max = Long.MIN_VALUE;
		for(int i = 1; i < N + 1; i++){
			max = Math.max(max, go(i));
		}
		
		System.out.println(max);
		
		
	}
	public static long go(int n){
		if(d[n] > Long.MIN_VALUE){
			return d[n];
		}
		if(n == 1){
			d[n] = mArray[n];
			return d[n];
		}

		d[n] = mArray[n];
		if(go(n-1) + mArray[n] > d[n]){
			d[n] = go(n-1) + mArray[n];
		}
		
		return d[n];
	}

}
