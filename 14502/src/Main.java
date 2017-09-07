import java.io.*;
import java.util.*;

class Pair{
	int r;
	int c;
	public Pair(int r, int c){
		this.r = r;
		this.c = c;
	}
}
public class Main {
	public static int R, C;
	public static int[][] mMap;		//��
	public static int[][] mCopyMap;	// ī�� ��
	public static boolean[][] mVisited;
	
	public static Pair[] mWall;		// �� 3���� ���� ������ ��� ����
	
	public static LinkedList<Pair> mList;	//���̷��� ��� list
	public static Queue<Pair> q;	//list�� �ִ� ���̷������� bfs �ϱ����� q 
	
	public static int mResult;	//0�� ����
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		q = new LinkedList();
		mList = new LinkedList();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mMap = new int[R][C];
		mCopyMap = new int[R][C];
		mVisited = new boolean[R][C];
		mWall = new Pair[3];
		for(int r = 0; r < R; r++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0; c < C; c++){
				mMap[r][c] = Integer.parseInt(st.nextToken());
				if(mMap[r][c] == 2){
					mList.add(new Pair(r, c));   
				}
			}
		}
		
		
		for(int r0 = 0; r0 < R; r0++){
			for(int c0 = 0; c0 < C; c0++){
				if(!(mMap[r0][c0] == 0)){
					continue;
				}
				mWall[0] = new Pair(r0, c0);	//�������� ���� 0�� ù��° ��
				for(int r1 = r0 ; r1 < R ;r1++){
					for(int c1 = 0; c1< C; c1++){
						if((r0 == r1 && c0 >= c1) || !(mMap[r1][c1] ==0)){
							continue;
						}
						mWall[1] = new Pair(r1, c1);	//�������� ���� 0�� �ι�° ��
						for(int r2 = r1; r2 < R; r2++){
							for(int c2 = 0; c2 < C; c2++){
								if((r1 == r2 && c1 >= c2) || !(mMap[r2][c2] ==0)){
									continue;
								}
								
								mWall[2] = new Pair(r2, c2);	//�������� ���� 0�� ����° ��
								copyMap(mWall);
								for(int i = 0; i < mList.size(); i++){
									mVisited[mList.get(i).r][mList.get(i).c] = true;
									q.add(mList.get(i));
								}
								
								while(!q.isEmpty()){
									Pair pair = q.poll();
									int[] dx = {1, -1, 0, 0};
									int[] dy = {0, 0, 1, -1};
									
									for(int i = 0; i < 4; i++){
										int nextR = pair.r + dy[i];
										int nextC = pair.c + dx[i];
										
										
										if(nextR < 0 || nextR >= R || nextC < 0 || nextC >=C
												|| mVisited[nextR][nextC] || mCopyMap[nextR][nextC] == 1){
											continue;
										}
										q.add(new Pair(nextR, nextC));
										mCopyMap[nextR][nextC] = 1;
										mVisited[nextR][nextC] = true;
									}
								}
								int cnt =0;
								for(int i = 0; i < R; i++){
									for(int j = 0; j < C; j++){
										
										if(mCopyMap[i][j] == 0){
											cnt++;
										}
										if(mResult < cnt){
											mResult = cnt;
										}
									}
								}
								
//								for(int a = 0 ; a < R; a++){
//									for(int b = 0; b < C; b++){
//										System.out.print(mCopyMap[a][b] + " ");
//									}
//									System.out.println();
//								}
//								System.out.println();
								
								
								
								
							}
						}
					}
				}
			}
		}	
		
		System.out.println(mResult);
	}
	public static void copyMap(Pair[] wall){	// �� ī�� �� visited�迭 �ʱ�ȭ �� �� �����
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				mCopyMap[i][j] = mMap[i][j];
				mVisited[i][j] = false;
			}
		}
		mCopyMap[wall[0].r][wall[0].c] = 1;
		mCopyMap[wall[1].r][wall[1].c] = 1;
		mCopyMap[wall[2].r][wall[2].c] = 1;
	}
}
