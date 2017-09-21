import java.util.*;
public class Main2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		if(n == 1){
			System.out.println(1);
			return;
		}
		int cnt = 2;
		int number = 2;
		int gap = 6;
		while(number <= n){
			number += gap;
			cnt++;
			gap +=6;
		}
		System.out.println(cnt - 1);
	}

}
