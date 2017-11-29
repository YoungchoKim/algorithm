import java.util.*;
import java.io.*;
public class Main {
	
	public static int N;
	public static int K;
	public static long[][] d;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		d = new long[K + 1][N + 1];
		
		for(int k = 1; k <= K; k++){
			for(int n = 0; n <= N; n++){
				if(k==1){
					d[k][n] = 1;
				}
				else{
					for(int i = n; i >= 0; i--){
						d[k][n] = (d[k][n] + d[k-1][i]) % 1000000000;
					}	
				}
				
			}
		}
		
		System.out.println((d[K][N])% 1000000000);
	}
}
