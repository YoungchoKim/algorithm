package koreatech1002;

import java.util.*;
public class Main {
	public static int N;
	public static String[] mStr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		mStr = new String[N];
		for(int i = 0; i < N; i++){
			mStr[i] = sc.nextLine();
			System.out.println(mStr[i].substring(2, 4));
		}
	}

}
