import java.util.*;
public class Main {
	public static int N;
	public static int[] mArray;
	public static int[] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		mArray = new int[N+1];
		d = new int[N + 1];
		for(int i = 1; i < N+1 ;i++){
			mArray[i] = sc.nextInt();
		}
		for(int i = N; i > 0; i--){
			go(i);
		}
		
		int max = 0;
		for(int i = 1; i < N + 1; i++){
			max = Math.max(max, d[i]);
		}
		System.out.println(max);
		
	}
	
	public static int go(int n){
		if(d[n] > 0){
			return d[n];
		}
		if(n == 1){
			d[n] = 1;
		}
		
		else{
			d[n] = 1;
			for(int i = 1; i < n; i++){
				if(mArray[n - i] < mArray[n]){
					d[n] = Math.max(go(n), go(n - i) + 1);
				}
			}
		}
		return d[n];
	}

}
