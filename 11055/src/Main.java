import java.util.*;
import java.io.*;
public class Main {
	public static long[] d = new long[1001];
	public static int[] array = new int[1001];
	public static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++){
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		long max = 0;
		for(int i = 1; i <=N ; i++){
			max = Math.max(max, go(i));
		}
		
		System.out.println(max);
	}
	public static long go(int n){
		if(d[n] > 0){
			return d[n];
		}

		d[n] = array[n];
		for(int i = 1; i < n ; i++){
			if(array[i] < array[n]){
				d[n] = Math.max(d[n], d[i] + array[n]);
			}
		}
	
	
		return d[n];
	}

}
