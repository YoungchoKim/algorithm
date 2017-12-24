import java.util.*;
public class Main2503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayList list = new ArrayList();
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				if(i == j) {
					continue;
				}
				for(int k = 1; k <= 9; k++) {
					if(i == k || j == k) {
						continue;
					}
					list.add(Integer.parseInt("" + i + j + k));
				}
			}
		}
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			int answer = Integer.parseInt("" + sc.nextInt() + sc.nextInt());
			for(int j = 0; j < list.size(); j++) {
				int num2 = (int)list.get(j);
				if(check(num2, num) != answer) {
					list.remove(j);
					j--;
				}
			}
		}
		System.out.println(list.size());
	}
	public static int check(int num2, int num) {
		String n2 = Integer.toString(num2);
		String n1 = Integer.toString(num);
		int s = 0;
		int b = 0;
		for(int i = 0; i < 3; i++) {
			if(n2.charAt(i) == n1.charAt(i)) {
				s++;
			}
			for(int j = 0; j < 3; j++) {
				if(i == j) {
					continue;
				}
				if(n2.charAt(i) == n1.charAt(j)) {
					b++;
				}
			}
		}
		return Integer.parseInt("" + s + b);
	}
}
