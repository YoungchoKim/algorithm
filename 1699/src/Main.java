import java.util.*;
public class Main {
	public static int N;
	public static int[] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		d = new int[N + 1];
		System.out.println(go(N));
	}
	public static int go(int n){
		if(d[n] > 0){
			return d[n];
		}
		if(n == 0){
			d[n] = 0;
		}
		else if(n == 1){
			d[n] = 1;
		}
		
		else{
			int temp = (int)Math.sqrt(n) * (int)Math.sqrt(n);
			int min = Integer.MAX_VALUE;
			for(int i = (int)Math.sqrt(n); i > 0 ; i--){
				min = Math.min(min, 1 + go(n - i*i));  
			}
			d[n] = min;
		}
		
		return d[n];
	}

}
