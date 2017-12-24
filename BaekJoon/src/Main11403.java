import java.util.*;
public class Main11403 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] map = new boolean[N][N];
		boolean[][] output = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(sc.nextInt() == 1) {
					map[i][j] = true;
				}
				else {
					map[i][j] = false;
				}
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j]) {
						continue;
					}else if(map[i][k] && map[k][j]) {
						map[i][j] = true;
					}
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j]) {
					System.out.print(1 + " ");					
				}
				else {
					System.out.print(0 + " ");
				}
			}System.out.println();
		}
		
	}

}
