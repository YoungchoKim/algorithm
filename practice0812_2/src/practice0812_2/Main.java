package practice0812_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
	int num;
	String s;
	Pair(int num, String s){
		this.num = num;
		this.s = s;
	}
}
public class Main {

	static int N;
	static int M;
	static int K;
	static int[][] map;
	static Queue<Integer> c;
	static Queue<Pair> q;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		int x = Integer.parseInt(str[2]);
		int y = Integer.parseInt(str[3]);
		K = Integer.parseInt(str[4]);
		map = new int[N][M];
		for(int i=0; i<N; i++){
			String[] str1 = br.readLine().split(" ");
			for(int j=0; j<M; j++){
				map[i][j] = Integer.parseInt(str1[j]);
			}
		}
		c = new LinkedList<>();
		String[] str2 = br.readLine().split(" ");
		for(String i : str2)
			c.add(Integer.parseInt(i));
		q = new LinkedList<>();
		q.add(new Pair(map[x][y], "x"));
		int nx = x;
		int ny = y;
		int tmp = 0;
		int top=0;
		while(!c.isEmpty()){
			int size = q.size();
			int command = c.remove();
			top = -1;
			if(command == 1){
				nx = nx + 1;
				ny = ny;
				if(nx < 0 || nx >= M || ny < 0 || ny >= N){
					nx = nx-1;
					ny = ny;
					continue;
				}
					tmp = map[ny][nx];
					for(int i=0; i<size; i++){
						Pair p = q.remove();
						
						if(p.s.equals("top")){
							q.add(new Pair(p.num, "right"));
						}
						else if(p.s.equals("bottom")){
							q.add(new Pair(p.num, "left"));
						}
						else if(p.s.equals("left")){
							q.add(new Pair(p.num, "top"));
							top = p.num;
						}
						else if(p.s.equals("right")){
							if(map[ny][nx] == 0){
								map[ny][nx] = p.num;
								tmp = p.num;
							}
						}
						else{
							q.add(new Pair(p.num, p.s));
						}
						
					}
				
					q.add(new Pair(tmp, "bottom"));
					map[ny][nx] = 0;
					System.out.println(top == -1 ? 0 : top);
				
			}
			else if(command == 2){
				nx = nx - 1;
				ny = ny;
				if(nx < 0 || nx >= M || ny < 0 || ny >= N){
					nx = nx+1;
					ny = ny;
					continue;
				}
					tmp = map[ny][nx];
					for(int i=0; i<size; i++){
						Pair p = q.remove();
						if(p.s.equals("top")){
							q.add(new Pair(p.num, "left"));
						}
						else if(p.s.equals("bottom")){
							q.add(new Pair(p.num, "right"));
//							map[ny][nx] = 0;
						}
						else if(p.s.equals("left")){
							if(map[ny][nx] == 0){
								map[ny][nx] = p.num;
								tmp = p.num;
							}
						}
						else if(p.s.equals("right")){
							q.add(new Pair(p.num, "top"));
							top = p.num;
						}
						else{
							q.add(new Pair(p.num, p.s));
						}
					}
					q.add(new Pair(tmp, "bottom"));
					map[ny][nx] = 0;
					System.out.println(top == -1 ? 0 : top);
			}
			else if(command == 3){
				nx = nx;
				ny = ny - 1;
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N){
					nx = nx;
					ny = ny+1;
					continue;
				}
					tmp = map[ny][nx];
					for(int i=0; i<size; i++){
						Pair p = q.remove();
						if(p.s.equals("top")){
							q.add(new Pair(p.num, "back"));
						}
						else if(p.s.equals("bottom")){
							q.add(new Pair(p.num, "front"));
						}
						else if(p.s.equals("front")){
							q.add(new Pair(p.num, "top"));
							top = p.num;
						}
						else if(p.s.equals("back")){
							if(map[ny][nx] == 0){
								map[ny][nx] = p.num;
								tmp = p.num;
							}
						}
						else{
							q.add(new Pair(p.num, p.s));
						}
					}
					q.add(new Pair(tmp, "bottom"));
					map[ny][nx] = 0;
					System.out.println(top == -1 ? 0 : top);
				
			}
			else{ 
				nx = nx;
				ny = ny + 1;
				if(nx < 0 || nx >= M || ny < 0 || ny >= N){
					nx = nx;
					ny = ny-1;
					continue;
				}
					tmp = map[ny][nx];
					for(int i=0; i<size; i++){
						Pair p = q.remove();
						if(p.s.equals("top")){
							q.add(new Pair(p.num, "front"));
						}
						else if(p.s.equals("bottom")){
							q.add(new Pair(p.num, "back"));
						}
						else if(p.s.equals("front")){
							if(map[ny][nx] == 0){
								tmp = p.num;
								map[ny][nx] = p.num;
							}
						}
						else if(p.s.equals("back")){
							q.add(new Pair(p.num, "top"));
							top = p.num;
						}
						else{
							q.add(new Pair(p.num, p.s));
						}
					}
					q.add(new Pair(tmp, "bottom"));
					map[ny][nx] = 0;
					System.out.println(top == -1 ? 0 : top);
				
			}
			
		}
	}

}