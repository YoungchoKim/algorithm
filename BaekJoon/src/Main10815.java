import java.util.*;
import java.io.*;
public class Main10815 {
	private static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, 0, N);
		
		int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb =new StringBuilder();
		while(T-- > 0) {
			int k = Integer.parseInt(st.nextToken());
			int l = 0, r = N - 1;
			while(l <= r) {
				int m = (l + r)/2;
				if(arr[m] > k) {
					r = m - 1;
				}
				else if(arr[m] < k) {
					l = m + 1;
				}
				else {
					sb.append("1 ");
					break;
				}
				
			}
			if(l > r) {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString());
		
		
		
	}

}
