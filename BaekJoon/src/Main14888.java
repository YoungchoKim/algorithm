import java.util.*;
public class Main14888 {
	static int[] operator = new int[4];
	static int[] num;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		for(int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}
		go(0, num[0]);
		
		System.out.println(max + " " + min);
	}
	public static void go(int cnt, int sum) {
		if(cnt == N - 1) {
			for(int i = 0; i < 4; i++) {
				if(operator[i] > 0) {
					operator[i]--;
					if(i == 0) {
						sum += num[cnt + 1];
					}
					else if(i == 1) {
						sum -= num[cnt + 1];
					}
					else if(i == 2) {
						sum *= num[cnt + 1];
					}
					else if(i == 3) {
						sum /= num[cnt + 1];
					}
					
					operator[i]++;
				}
			}
			
			if(max < sum) {
				max = sum;
			}
			if(min > sum) {
				min = sum;
			}
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				if(i == 0) {
					go(cnt + 1, sum + num[cnt + 1]);
				}
				else if(i == 1) {
					go(cnt + 1, sum - num[cnt + 1]);
				}
				else if(i == 2) {
					go(cnt + 1, sum * num[cnt + 1]);
				}
				else if(i == 3) {
					go(cnt + 1, sum / num[cnt + 1]);
				}
				
				operator[i]++;
			}
		}
	}
	
}
