import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N이 1일 경우에는 무조건 0이 출력되어야하는데, 이 처리를 해주지 않았다.
 * dp를 수행하다가 step이 끊기게되면 멈춰야하는데 다시 0스텝부터 시작하게하는 실수를 범했다.
 * for문안에 다음 문구를 추가하여 스텝이 끊기되면 for문을 빠져나오도록 하였다.
 * if(i > 0 && dp[i] == 0){
				break;
			}
			
 * @author cho
 *
 */
public class Main {
	public static int N;
	public static int mArray[];
	public static int mResult;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();

		int[] dp = new int[N];
		for(int i = 0; i < N; i++){
			if(i > 0 && dp[i] == 0){
				break;
			}
			for(int j = 1; j <= mArray[i]; j++){
				if(i + j < N && dp[i + j] > 0){
					continue;
				}
				else if(i + j < N && dp[i + j] == 0){
					dp[i+j] = dp[i] + 1;
				}
			}
		}
		if(dp[N-1] == 0 && N-1 != 0){
			System.out.println(-1);
		}
		else{	
			System.out.println(dp[N - 1]);
		}
		
	}
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mArray = new int[N];
		mResult = N;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++){
			mArray[i] = Integer.parseInt(st.nextToken());
		}
		
	}
}
