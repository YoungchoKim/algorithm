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
				for(int j = N - 1; j > 0; j--){		// 0이 아닌 숫자들을 한쪽으로 밀어넣기위한 FOR
					if(map[i][j] == 0){		//0일 경우 0이 아닌 다음수를 현재 자리에 집이 넣는다.
						k = j;
						while(k > 0 && map[i][k] == 0){	// 0일경우 K이동 
							k--;
						}
						map[i][j] = map[i][k];	// 이동한 값을 0자리에 넣기 
						map[i][k] = 0;
					}
				}
				k = N - 1;	// K: 값이 들어가는 현재 인덱스 , J: 값이 같은지 다른지 비교하는 인덱스 
				for(int j = N - 1; j >=0; j--){	//이전 값과 값이 같은지 다른지 비교하는 FOR
					if(j > 0 && map[i][j] == map[i][j- 1]){	//값이 같을 경우 
						map[i][k] = map[i][j] * 2;		// 현재 인덱스에 값의 두배를 넣고 비교 비교 인덱스를 점프시킨다. 
						j--;
					}
					else if(j > 0 && map[i][j] != map[i][j-1]){	//다를 경우 비교인덱스의 값을 현재 인덱스에 넣는다.
						map[i][k] = map[i][j];
					}
					else if(j == 0){	// 비교인덱스가 0일경우 비교하지 않고 그 값을 현재인덱스에 넣는다.
						map[i][k] = map[i][j];
					}
					
					k--;
				}
				while(k >=0){	// 같은게 하나라도 존재했다면 K는 중간위치에 있다. 그 이전 값은 0으로 초기화한다.
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
