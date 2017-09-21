import java.util.*;
public class Main1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1){
			System.out.println(1+"/" +1);
			return;
		}
		int i = 1;
		while((i * (i+1))/2 < n){
			i++;
		}
		
		
		
		int temp = (i * (i - 1))/ 2;
		if(i%2 == 0){
			System.out.println(n - temp+"/" +(i- (n-temp-1)));	
		}
		else{
			System.out.println((i- (n-temp-1))+"/" +(n - temp));	
	
		}
		
		
	}

}
