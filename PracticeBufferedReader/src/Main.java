//������ ���� java.math.*�� Scanner�� �����߽��ϴ�.
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//readLine()�̿��� String ���·� ���๮��(����)���� ������ ������ ��°�� �Է¹޾� int�� ����ȯ
		int a = Integer.parseInt(br.readLine());
		int[] result = new int[a];
		for (int i = 0; i < a; i++) {
			
			//int a�� ����
			int size = Integer.parseInt(br.readLine());
			int[][] dp = new int[size][2];
			int[][] arr = new int[size][2];
			for (int j = 0; j < 2; j++) {
				
				//arr�� �ε����� k
				int k=0;
				
				//��Ʈ�� ��ũ�������� �̿��� readLine()�� ���� �� ���� �ѹ��� �Է¹������� ����(" ")�� �������� �ɰ�
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				//�ɰ� ���� �����Ҷ����� �ݺ�
				while(st.hasMoreTokens()){
					//nextToken()�� ���� ����(" ")�� �����ϰ� ���� ���ڸ� ��Ʈ�� ���¿��� int�� ����ȯ�Ͽ� arr�� ����. k++�� �̿��� �ε��� ����
					arr[k++][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = arr[0][0];
			dp[0][1] = arr[0][1];
			dp[1][0] = arr[0][1] + arr[1][0];
			dp[1][1] = arr[0][0] + arr[1][1];
			for (int j = 2; j < size; j++) {
				dp[j][0] = arr[j][0] + Math.max(dp[j - 1][1], dp[j - 2][1]);
				dp[j][1] = arr[j][1] + Math.max(dp[j - 1][0], dp[j - 2][0]);
			}
			result[i] = Math.max(dp[size - 1][0], dp[size - 1][1]);
		}
		for (int i = 0; i < a; i++) {
			System.out.println(result[i]);
		}
	}
}