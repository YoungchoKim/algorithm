import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N�� 1�� ��쿡�� ������ 0�� ��µǾ���ϴµ�, �� ó���� ������ �ʾҴ�.
 * dp�� �����ϴٰ� step�� ����ԵǸ� ������ϴµ� �ٽ� 0���ܺ��� �����ϰ��ϴ� �Ǽ��� ���ߴ�.
 * for���ȿ� ���� ������ �߰��Ͽ� ������ ����Ǹ� for���� ������������ �Ͽ���.
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
