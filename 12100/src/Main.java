import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] mMap;
	public static final int ACTION_LEFT = 0;
	public static final int ACTION_UP = 1;
	public static final int ACTION_RIGHT = 2;
	public static final int ACTION_DOWN = 3;
	
	public static int mResult;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		mMap = new int[N][N];
		StringTokenizer st;
		for(int i = 0 ; i < N; i++){
			st  =new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N ;j++){
				mMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//changeMap(mMap, ACTION_UP);
//		for(int i = 0 ; i < N; i++){
//			for(int j = 0; j < N ;j++){
//				System.out.print(mMap[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int i = 0; i < 4; i ++){
			int[][] map1 = new int[N][N];
			copyMap(mMap, map1);
			changeMap(map1, i);
			for(int j = 0; j < 4; j++){
				int[][] map2 = new int[N][N];
				copyMap(map1, map2);
				changeMap(map2, j);
				for(int k = 0; k < 4; k++){
					int[][] map3 = new int[N][N];
					copyMap(map2, map3);
					changeMap(map3, k);
					for(int l = 0; l < 4; l++){
						int[][] map4 = new int[N][N];
						copyMap(map3, map4);
						changeMap(map4, l);
						for(int m=0; m < 4; m++){
							int[][] map5 = new int[N][N];
							copyMap(map4, map5);
							changeMap(map5, m);
							for(int r = 0; r < N; r++){
								for(int c = 0; c < N; c++){
									if(mResult < map5[r][c]){
										mResult = map5[r][c];	
									}
								}
							}
					
							
						}
					}
				}
			}
		}
		System.out.println(mResult);
		
	}
	public static void copyMap(int[][] src, int[][] dist){
		for(int i = 0; i < src.length; i++){
			for(int j = 0; j < src[0].length; j++){
				dist[i][j] = src[i][j];
			}
		}
	}
	
	public static void changeMap(int[][] map, int action){
		if(action == ACTION_RIGHT){
			for(int i = 0; i < N; i++){
				int k;
				for(int j = N - 1; j > 0; j--){		// 0�� �ƴ� ���ڵ��� �������� �о�ֱ����� FOR
					if(map[i][j] == 0){		//0�� ��� 0�� �ƴ� �������� ���� �ڸ��� ���� �ִ´�.
						k = j;
						while(k > 0 && map[i][k] == 0){	// 0�ϰ�� K�̵� 
							k--;
						}
						map[i][j] = map[i][k];	// �̵��� ���� 0�ڸ��� �ֱ� 
						map[i][k] = 0;
					}
				}
				k = N - 1;	// K: ���� ���� ���� �ε��� , J: ���� ������ �ٸ��� ���ϴ� �ε��� 
				for(int j = N - 1; j >=0; j--){	//���� ���� ���� ������ �ٸ��� ���ϴ� FOR
					if(j > 0 && map[i][j] == map[i][j- 1]){	//���� ���� ��� 
						map[i][k] = map[i][j] * 2;		// ���� �ε����� ���� �ι踦 �ְ� �� �� �ε����� ������Ų��. 
						j--;
					}
					else if(j > 0 && map[i][j] != map[i][j-1]){	//�ٸ� ��� ���ε����� ���� ���� �ε����� �ִ´�.
						map[i][k] = map[i][j];
					}
					else if(j == 0){	// ���ε����� 0�ϰ�� ������ �ʰ� �� ���� �����ε����� �ִ´�.
						map[i][k] = map[i][j];
					}
					
					k--;
				}
				while(k >=0){	// ������ �ϳ��� �����ߴٸ� K�� �߰���ġ�� �ִ�. �� ���� ���� 0���� �ʱ�ȭ�Ѵ�.
					map[i][k] = 0;
					k--;
				}
				
			}
			
			
		
		}
		
		
		else if(action == ACTION_LEFT){
			for(int i = 0; i < N; i++){
				int k;
				for(int j =0; j < N; j++){
					if(map[i][j] == 0){
						k = j;
						while(k < N-1 && map[i][k] == 0){
							k++;
						}
						map[i][j] = map[i][k];
						map[i][k] = 0;
					}
				}
				k = 0;
				for(int j = 0; j < N; j++){
					if(j < N - 1 && map[i][j] == map[i][j + 1]){
						map[i][k] = map[i][j] * 2;
						j++;
					}
					else if(j < N -1 && map[i][j] != map[i][j + 1]){
						map[i][k] = map[i][j];
					}
					else if(j == N-1){
						map[i][k] = map[i][j];
					}
					
					k++;
				}
				while(k < N){
					map[i][k] = 0;
					k++;
				}
				
			}
			
			
		
		}
		
		
		else if(action == ACTION_UP){
			for(int j = 0; j < N; j++){
				int k;
				for(int i = 0; i < N ; i++){
					if(map[i][j] == 0){
						k = i;
						while(k < N-1 && map[k][j] == 0){
							k++;
						}
						map[i][j] = map[k][j];
						map[k][j] = 0;
					}
				}
				k = 0;
				for(int i = 0; i < N; i++){
					if(i < N - 1 && map[i][j] == map[i + 1][j]){
						map[k][j] = map[i][j] * 2;
						i++;
					}
					else if(i < N - 1 && map[i][j] != map[i + 1][j]){
						map[k][j] = map[i][j];
					}
					else if(i == N - 1){
						map[k][j] = map[i][j];
					}
					
					k++;
				}
				while(k < N){
					map[k][j] = 0;
					k++;
				}
				
			}
			
			
		
		}
		
		else if(action == ACTION_DOWN){
			for(int j = 0; j < N; j++){
				int k;
				for(int i = N - 1; i >= 0 ; i--){
					if(map[i][j] == 0){
						k = i;
						while(k > 0 && map[k][j] == 0){
							k--;
						}
						map[i][j] = map[k][j];
						map[k][j] = 0;
					}
				}
				k = N - 1;
				for(int i = N - 1; i >= 0; i--){
					if(i  > 0 && map[i][j] == map[i - 1][j]){
						map[k][j] = map[i][j] * 2;
						i--;
					}
					else if(i > 0 && map[i][j] != map[i - 1][j]){
						map[k][j] = map[i][j];
					}
					else if(i == 0){
						map[k][j] = map[i][j];
					}
					
					k--;
				}
				while(k >= 0){
					map[k][j] = 0;
					k--;
				}
				
			}
				
		}
	}
	

}
