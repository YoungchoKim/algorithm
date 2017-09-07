import java.util.*;
class Pair{
	int Rr;
	int Rc;
	int Br;
	int Bc;
	
	int cnt;
	public Pair(int Rr, int Rc, int Br, int Bc, int cnt){
		this.Rr = Rr; 
		this.Rc = Rc;
		this.Br = Br;
		this.Bc = Bc;
		this.cnt = cnt;
	}
	public void setR(int Rr, int Rc){
		this.Rr = Rr;
		this.Rc = Rc;
	}
	public void setB(int Br, int Bc){
		this.Bc = Bc;
		this.Br = Br;
	}
	public String toString(){
		
		return "Br:" + Br + " Bc:" + Bc + " Rr:" + Rr + " Rc:" + Rc;
	}
}
public class Main {
	public static int R, C;
	public static String[][] mMap;
	public static boolean SUCCESS;
	
	public static final int RIGHT = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int UP = 3;
	
	public static int mDistR;
	public static int mDistC;
	public static boolean[][][][][] mVisited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mMap = new String[R][C];
		mVisited = new boolean[4][R][C][R][C];
		Pair start = new Pair(0, 0, 0, 0, 0);
		for(int r = 0; r < R; r++){
			String s = sc.nextLine();
			for(int c = 0; c < C; c++){
				mMap[r][c] = s.substring(c, c+1);
				if(mMap[r][c].equals("R")){
					start.setR(r, c);
					mMap[r][c] = ".";	// R구슬 정보를 저장하고 이동가능한 .으로 맵정보를 변경한다.
				}
				else if(mMap[r][c].equals("B")){
					start.setB(r, c);
					mMap[r][c] = ".";  // B구슬 정보를 저장하고 이동가능한 .으로 맵정보를 변경한다.
				}
				if(mMap[r][c].equals("O")){
					mDistR = r;
					mDistC = c;
				}
			}
		}
		/////////////////////////////////////////////////////// 입력 끝
		
		Queue<Pair> q = new LinkedList();
		q.add(start);
		// 빨간것이 빠지면 성공, 파란 구슬 빠지면 실패
		// 동시에 빠져도 실패
		// 두 구슬은 같은 칸에 있을 수 없다.
		// 한구슬당 한칸
		// 10번 이하로 빼낼수 있는지 출력 가능하면 1 불가능하면 0
		
		while(!q.isEmpty()){
			Pair pair = q.poll();
			if(pair.cnt > 10 || (pair.Br == mDistR && pair.Bc == mDistC)){
				continue;
			}
			
			if(pair.Rr == mDistR && pair.Rc == mDistC){
				System.out.println(1);
				return;
			}
//			public static final int RIGHT = 0;
//			public static final int DOWN = 1;
//			public static final int LEFT = 2;
//			public static final int UP = 3;
			
			for(int i = 0; i < 4; i++){
				Pair nextPair = new Pair(pair.Rr, pair.Rc, pair.Br, pair.Bc, pair.cnt+1);
		
				go(nextPair, i);
				if(mVisited[i][nextPair.Rr][nextPair.Rc][nextPair.Br][nextPair.Bc]){
					continue;
				}
				q.add(nextPair);
				mVisited[i][nextPair.Rr][nextPair.Rc][nextPair.Br][nextPair.Bc] = true;
			}
			
		}
	
		System.out.println(0);
	}
	
	public static void go(Pair pair, int direction){
		for(int i = 0; i < 2; i++){	// R과 G 위치에 상관없이 이동시키기 위해
			if(direction == RIGHT){
				// . 일경우 이동, 구슬끼리 만나지 않을 경우 이동
				while(mMap[pair.Rr][pair.Rc].equals(".") && !(pair.Rr == pair.Br && pair.Rc == pair.Bc)){
					pair.Rc++;
				}
				//while문이 끝난 상태 : # 이거나 O 이거나 구슬이 겹치거나 3가지 상태
				//O일경우는 그대로 납두고 # 이거나 O 일경우 다시 . 의 위치로 돌아간다.
				//구슬이 목적지에 동시에 도착하면 겹치면서 목적지이기 때문에 목적지 검사를 해야한다.
				//구슬이 겹쳐도 목적지이면 그대로 냅둬야한다.
				if((mMap[pair.Rr][pair.Rc].equals("#") )	|| ((pair.Rr == pair.Br && pair.Rc == pair.Bc)
						&& !mMap[pair.Rr][pair.Rc].equals("O"))){
					pair.Rc--;
				}
				while(mMap[pair.Br][pair.Bc].equals(".") && !(pair.Rr == pair.Br && pair.Rc == pair.Bc)){
					pair.Bc++;
				}
				if((mMap[pair.Br][pair.Bc].equals("#") )	|| ((pair.Rr == pair.Br && pair.Rc == pair.Bc)
						&& !mMap[pair.Rr][pair.Rc].equals("O"))){
					pair.Bc--;
				}
			}
			else if(direction == LEFT){
				while(mMap[pair.Rr][pair.Rc].equals(".") && !(pair.Rr == pair.Br && pair.Rc == pair.Bc)){
					pair.Rc--;
				}
				if((mMap[pair.Rr][pair.Rc].equals("#"))	|| ((pair.Rr == pair.Br && pair.Rc == pair.Bc) 
						&& !mMap[pair.Rr][pair.Rc].equals("O"))){
					pair.Rc++;
				}
				while(mMap[pair.Br][pair.Bc].equals(".") && !(pair.Rr == pair.Br && pair.Rc == pair.Bc)){
					pair.Bc--;
				}
				if((mMap[pair.Br][pair.Bc].equals("#"))	|| ((pair.Rr == pair.Br && pair.Rc == pair.Bc) 
						&& !mMap[pair.Rr][pair.Rc].equals("O"))){
					pair.Bc++;
				}
			}
			else if(direction == UP){
				while(mMap[pair.Rr][pair.Rc].equals(".") && !(pair.Rr == pair.Br && pair.Rc == pair.Bc)){
					pair.Rr--;
				}
				if(mMap[pair.Rr][pair.Rc].equals("#")	|| ((pair.Rr == pair.Br && pair.Rc == pair.Bc)
						&& !mMap[pair.Rr][pair.Rc].equals("O"))){
					pair.Rr++;
				}
				while(mMap[pair.Br][pair.Bc].equals(".") && !(pair.Rr == pair.Br && pair.Rc == pair.Bc)){
					pair.Br--;
				}
				if(mMap[pair.Br][pair.Bc].equals("#")	|| ((pair.Rr == pair.Br && pair.Rc == pair.Bc)
						&& !mMap[pair.Rr][pair.Rc].equals("O"))){
					pair.Br++;
				}
			}
			else if(direction == DOWN){
				while(mMap[pair.Rr][pair.Rc].equals(".") && !(pair.Rr == pair.Br && pair.Rc == pair.Bc)){
					pair.Rr++;
				}
				if(mMap[pair.Rr][pair.Rc].equals("#")	|| ((pair.Rr == pair.Br && pair.Rc == pair.Bc)
						&& !mMap[pair.Rr][pair.Rc].equals("O"))){
					pair.Rr--;
				}
				while(mMap[pair.Br][pair.Bc].equals(".") && !(pair.Rr == pair.Br && pair.Rc == pair.Bc)){
					pair.Br++;
				}
				if(mMap[pair.Br][pair.Bc].equals("#")	|| ((pair.Rr == pair.Br && pair.Rc == pair.Bc)
						&& !mMap[pair.Rr][pair.Rc].equals("O"))){
					pair.Br--;
				}
			}
		}
	}

}
