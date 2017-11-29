import java.util.*;
import java.io.*;
class Pair{
	int r;
	int c;
	int cnt;
	public Pair(int r, int c, int cnt){
		this.r = r;
		this.c = c;
		this.cnt  = cnt;
	}
}
public class Main {
	public static int R, C;
	
	public static boolean[][] mAir;		//���� �迭
	public static int[][] mMap;
	

	public static Queue mQAir;		// ���� ġ����ġ ���� �� ���� ��Ʈ�� Q
	public static Queue mQCheese;		// ġ��� ���� �� Q
	
	public static int mCurrentHour = -1;		//���� �������� �ð� 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mAir = new boolean[R][C];
		mMap = new int[R][C];
		
		mQAir = new LinkedList();
		mQCheese = new LinkedList();
		
		
		for(int r = 0; r < R; r++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0; c < C; c++){
				mMap[r][c] = Integer.parseInt(st.nextToken());
				if(mMap[r][c] == 1){
					mQCheese.add(new Pair(r, c, 0));
				}
			}
		}
		mQAir.add(new Pair(0, 0, 0));		//ó�� ���� ť�� ���� �ϳ� �־���
		while(!mQCheese.isEmpty()){
			Pair pair = (Pair)mQCheese.poll();
			if(mCurrentHour < pair.cnt){	//�ð� üũ 
				spreadAir();
				mCurrentHour = pair.cnt;
			}
		
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			
			int cnt   = 0;
			for(int i = 0; i < 4; i++){
				int nextR = pair.r + dy[i];
				int nextC = pair.c + dx[i];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >=C
						|| mMap[nextR][nextC] == 1){
					continue;
				}
				
				if(mAir[nextR][nextC]){
					cnt++;
				}
				
			}
			if(cnt >=2){	//������
				mQAir.add(new Pair(pair.r, pair.c, pair.cnt));
			}
			else{		//���� ���� ��� 
				mQCheese.add(new Pair(pair.r, pair.c, pair.cnt + 1));
			}
		}
		
		System.out.println(mCurrentHour + 1);
		
	}
	public static void spreadAir(){	//���� ġ������ bfs
		
		while(!mQAir.isEmpty()){
			Pair pair = (Pair)mQAir.poll();
			mAir[pair.r][pair.c] = true;
			mMap[pair.r][pair.c] = 0;
			//�����ڸ��� ����
			int dx[] = {1, -1, 0, 0};
			int dy[] = {0, 0, 1, -1};
		
			for(int i = 0; i < 4; i++){
				int nextR = pair.r + dy[i];
				int nextC = pair.c + dx[i];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C
						|| mAir[nextR][nextC] || mMap[nextR][nextC] == 1){
					continue;
				}
				mAir[nextR][nextC] = true;
				mQAir.add(new Pair(nextR, nextC, 0));
			}
		}
	
	}

}

