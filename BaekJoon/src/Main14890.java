import java.util.*;
public class Main14890 {
	private static int N, L;
	private static int[][] mMap;
	private static boolean[][][] mVisited;
	private static int mResult;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		mMap = new int[N][N];
		mVisited = new boolean[N][N][2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				mMap[i][j] = sc.nextInt();
			}
		}
		
		for(int i= 0; i < N; i++) {
			int j = 0;
			int cur = mMap[i][j];
			int stack = 0;
			for( ; j < N; j++) {
				if(cur == mMap[i][j]) {
					stack++;
				}
				else if(cur + 1 == mMap[i][j]) {
					if(stack >= L) {
						stack = 1;
						cur++;
					}
					else {
						break;
					}
				}
				else if(cur - 1 == mMap[i][j]) {
					stack = 0;
					cur--;
					if(j + L - 1 >= N) {
						break;
					}
					int cnt = 0;
					for(int k = 0; k < L; k++) {
						if(cur == mMap[i][j + k]) {
							cnt++;
						}
					}
					if(cnt == L) {// 가능
						j = j + L - 1;
					}
					else {
						break;
					}
				}
				else {
					break;
				}
				if(j == N - 1) {
					mResult++;
				}
			}///////////////////////////////////////////가로 검사
		}
		
		for(int i= 0; i < N; i++) {
			int j = 0;
			int cur = mMap[j][i];
			int stack = 0;
			for( ; j < N; j++) {
				if(cur == mMap[j][i]) {
					stack++;
				}
				else if(cur + 1 == mMap[j][i]) {
					if(stack >= L) {
						stack = 1;
						cur++;
					}
					else {
						break;
					}
				}
				else if(cur - 1 == mMap[j][i]) {
					stack = 0;
					cur--;
					if(j + L - 1 >= N) {
						break;
					}
					int cnt = 0;
					for(int k = 0; k < L; k++) {
						if(cur == mMap[j + k][i]) {
							cnt++;
						}
					}
					if(cnt == L) {// 가능
						j = j + L - 1;
					}
					else {
						break;
					}
				}
				else {
					break;
				}
				if(j == N - 1) {
					mResult++;
				}
			}///////////////////////////////////////////세로 검사
		}
		
		System.out.println(mResult);
		
	}
	

}
