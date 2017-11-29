import java.util.*;
import java.io.*;

public class Main {
	public static boolean[] mIsnotSoSoo;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		mIsnotSoSoo = new boolean[10000];

		for (int i = 2; i < 10000; i++) {
			if (!mIsnotSoSoo[i]) {
				for (int j = 2; j * i < 10000; j++) {
					mIsnotSoSoo[i * j] = true;
				}
			}
		}

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10000];
			visited[start] = true;
			
			Queue q = new LinkedList();
			q.add(new Pair(start, 0));
			
			boolean success = false;
			while (!q.isEmpty()) {
				Pair pair = (Pair) q.poll();
				if (pair.num == end) {
					System.out.println(pair.cnt);
					q.clear();
					success = true;
					break;
				}
				int dx[] = { 1000, 100, 10, 1 };
				for (int i = 0; i < 4; i++) {
					int temp = calcNum(pair.num, dx[i]);
					for (int j = 0; j < 9; j++) {
						if (!mIsnotSoSoo[temp] && !visited[temp]) {
							visited[temp] = true;
							q.add(new Pair(temp, pair.cnt + 1));
						}
						temp = calcNum(temp, dx[i]);

					}
				}
			}
			if(!success){
				System.out.println("Impossible");
			}
		}
	}

	public static int calcNum(int num1, int num2) {
		int value = num1;
		switch (num2) {
		case 1:
			if (num1 % 10 == 9) {
				value = num1 - 9;
			} else {
				value++;
			}
			break;
		case 10:
			if (num1 % 100 >= 90) {
				value = num1 - 90;
			} else {
				value += 10;
			}
			break;
		case 100:
			if (num1 % 1000 >= 900) {
				value = num1 - 900;
			} else {
				value += 100;
			}
			break;
		case 1000:
			if (num1 % 10000 >= 9000) {
				value = num1 - 8000;
			} else {
				value += 1000;
			}
			break;
			
		}
		return value;
	}
}

class Pair {
	int num;
	int cnt;

	public Pair(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}