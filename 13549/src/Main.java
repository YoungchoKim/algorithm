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
					mMap[r][c] = ".";	// R���� ������ �����ϰ� �̵������� .���� �������� �����Ѵ�.
				}
				else if(mMap[r][c].equals("B")){
					start.setB(r, c);
					mMap[r][c] = ".";  // B���� ������ �����ϰ� �̵������� .���� �������� �����Ѵ�.
				}
				if(mMap[r][c].equals("O")){
					mDistR = r;
					mDistC = c;
				}
			}
		}
		/////////////////////////////////////////////////////// �Է� ��
		
		Queue<Pair> q = new LinkedList();
		q.add(start);
		// �������� ������ ����, �Ķ� ���� ������ ����
		// ���ÿ� ������ ����
		// �� ������ ���� ĭ�� ���� �� ����.
		// �ѱ����� ��ĭ
		// 10�� ���Ϸ� ������ �ִ��� ��� �����ϸ� 1 �Ұ����ϸ� 0
		
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
		for(int i = 0; i < 2; i++){	// R�� G ��ġ�� ������� �̵���Ű�� ����
			if(direction == RIGHT){
				// . �ϰ�� �̵�, �������� ������ ���� ��� �̵�
				while(mMap[pair.Rr][pair.Rc].equals(".") && !(pair.Rr == pair.Br && pair.Rc == pair.Bc)){
					pair.Rc++;
				}
				//while���� ���� ���� : # �̰ų� O �̰ų� ������ ��ġ�ų� 3���� ����
				//O�ϰ��� �״�� ���ΰ� # �̰ų� O �ϰ�� �ٽ� . �� ��ġ�� ���ư���.
				//������ �������� ���ÿ� �����ϸ� ��ġ�鼭 �������̱� ������ ������ �˻縦 �ؾ��Ѵ�.
				//������ ���ĵ� �������̸� �״�� ���־��Ѵ�.
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
