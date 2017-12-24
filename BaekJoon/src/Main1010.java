import java.util.*;
public class Main1010 {
	private static int mSelect, mEnd, mCnt;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			mSelect = sc.nextInt();
			mEnd = sc.nextInt();
			
			if(mSelect > mEnd/2) {
				mSelect = mEnd - mSelect;
			}
			check(0, 0);
			System.out.println(mCnt);
			mCnt = 0;
		}
	}
	
	private static void check(int select, int total) {
		if(mSelect - select + total > mEnd) {
			return;
		}
		if(select >= mSelect || total>= mEnd) {
			if(select >= mSelect) {
				mCnt++;
			}
			return;
		}
		check(select + 1, total + 1);
		check(select, total + 1);
	}

}
