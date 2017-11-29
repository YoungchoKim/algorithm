import java.util.*;
public class Main {
	public static int mCountDice;
	public static int mCountMap;
	
	public static int[] mDice;
	public static int[] mMap;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		//StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		
		mCountMap = sc.nextInt();
		mCountDice = sc.nextInt();
		
		mMap = new int[mCountMap + 1];
		mDice = new int[mCountDice];
		
		for(int i = 1; i < mCountMap + 1; i++){
			mMap[i] = sc.nextInt();
		}
		for(int i = 0; i < mCountDice; i++){
			mDice[i] = sc.nextInt();
		}
		long cnt = 0L;
		int SG = 1;
		for(int i = 0; i < mCountDice; i++){
			SG += mDice[i];
			cnt++;
			if(SG >= mCountMap){
				System.out.println(cnt);
				break;
			}
			
			
			SG += mMap[SG];
			if(SG >= mCountMap){
				System.out.println(cnt);
				break;
			}
		}
	
	}

}
