import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pair{
	int r;	//행
	int c;	//열
	int dir;	//방향
	public Pair(int r, int c, int dir){
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
}

public class Main {
	public static int mResult;
	public static int mMap[][];
	public static int mVisited[][][];
	public static int R;		//지도의 행 크기
	public static int C;		//지도의 열 크기
	public static Pair mSrc, mDist;
	
	public static final int DIR_EAST = 1;	//방향 정보
	public static final int DIR_WEST = 2;
	public static final int DIR_SOUTH = 3;
	public static final int DIR_NORTH = 4;

	public static final int ACTION_GO1 = 1; // 명령 정보
	public static final int ACTION_GO2 = 2;
	public static final int ACTION_GO3 = 3;
	public static final int ACTION_LEFT = 4;	
	public static final int ACTION_RIGHT = 5;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mMap = new int[R + 1][C + 1];
		mVisited = new int[R + 1][C + 1][5];
		
		for(int r = 1; r < R + 1; r++){
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c < C + 1 ; c++){
				mMap[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " " );
		int tempR = Integer.parseInt(st.nextToken());
		int tempC = Integer.parseInt(st.nextToken());
		int tempDir = Integer.parseInt(st.nextToken());
		
		mSrc = new Pair(tempR, tempC, tempDir);
		st = new StringTokenizer(br.readLine(), " " );
		tempR = Integer.parseInt(st.nextToken());
		tempC = Integer.parseInt(st.nextToken());
		tempDir = Integer.parseInt(st.nextToken());
		mDist = new Pair(tempR, tempC, tempDir);
		
///////////////////////////////////////////////////////////////////////
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(mSrc);
		mVisited[mSrc.r][mSrc.c][mSrc.dir] = 1;
		while(!q.isEmpty()){
			Pair pair = q.poll();

			for(int i = 1; i <= 5; i++){
				boolean escape = false;
				if(i  == ACTION_LEFT || i == ACTION_RIGHT){
					switch(i){
					case ACTION_LEFT:
						
						switch(pair.dir){
						case DIR_EAST:
							
							if(mVisited[pair.r][pair.c][DIR_NORTH] > 0){
								continue;
							}
							mVisited[pair.r][pair.c][DIR_NORTH] = mVisited[pair.r][pair.c][pair.dir] + 1;
	
							q.add(new Pair(pair.r, pair.c, DIR_NORTH));
							break;
						case DIR_WEST:
							if(mVisited[pair.r][pair.c][DIR_SOUTH] > 0){
								continue;
							}
							mVisited[pair.r][pair.c][DIR_SOUTH] = mVisited[pair.r][pair.c][pair.dir] + 1;
							q.add(new Pair(pair.r, pair.c, DIR_SOUTH));
							break;
						case DIR_SOUTH:
							if(mVisited[pair.r][pair.c][DIR_EAST] > 0){
								continue;
							}
							mVisited[pair.r][pair.c][DIR_EAST] = mVisited[pair.r][pair.c][pair.dir] + 1;
							q.add(new Pair(pair.r, pair.c, DIR_EAST));
							break;
						case DIR_NORTH:
							if(mVisited[pair.r][pair.c][DIR_WEST] > 0){
								continue;
							}
							mVisited[pair.r][pair.c][DIR_WEST] = mVisited[pair.r][pair.c][pair.dir] + 1;
							q.add(new Pair(pair.r, pair.c, DIR_WEST));
							break;
						}
						break;
						
						
					case ACTION_RIGHT:
						
						switch(pair.dir){
						case DIR_EAST:
							if(mVisited[pair.r][pair.c][DIR_SOUTH] > 0){
								continue;
							}
							mVisited[pair.r][pair.c][DIR_SOUTH] = mVisited[pair.r][pair.c][pair.dir] + 1;
							q.add(new Pair(pair.r, pair.c, DIR_SOUTH));
							break;
						case DIR_WEST:
							if(mVisited[pair.r][pair.c][DIR_NORTH] > 0){
								continue;
							}
							mVisited[pair.r][pair.c][DIR_NORTH] = mVisited[pair.r][pair.c][pair.dir] + 1;
							q.add(new Pair(pair.r, pair.c, DIR_NORTH));
							break;
						case DIR_SOUTH:
							if(mVisited[pair.r][pair.c][DIR_WEST] > 0){
								continue;
							}
							mVisited[pair.r][pair.c][DIR_WEST] = mVisited[pair.r][pair.c][pair.dir] + 1;
							q.add(new Pair(pair.r, pair.c, DIR_WEST));
							break;
						case DIR_NORTH:
							if(mVisited[pair.r][pair.c][DIR_EAST] > 0){
								continue;
							}
							mVisited[pair.r][pair.c][DIR_EAST] = mVisited[pair.r][pair.c][pair.dir] + 1;
							q.add(new Pair(pair.r, pair.c, DIR_EAST));
							break;
						}
						break;
					}
				}
				else{
					switch(pair.dir){
					case DIR_EAST:
						if(pair.c + i >= C + 1 ||mVisited[pair.r][pair.c + i][DIR_EAST] > 0){
							continue;
						}
						
						for(int j = pair.c + 1; j <= pair.c + i ; j++){
							if(mMap[pair.r][j] == 1 ){
								escape = true;
								break;
							}
						}
						if(escape){
							continue;
						}
						mVisited[pair.r][pair.c + i][DIR_EAST] = mVisited[pair.r][pair.c][pair.dir] + 1;
						q.add(new Pair(pair.r, pair.c +i, DIR_EAST));
						
						break;
					case DIR_WEST:
						if(pair.c - i < 1 ||mVisited[pair.r][pair.c - i][DIR_WEST] > 0){
							continue;
						}
						for(int j = pair.c - 1; j >=pair.c - i ; j--){
							if( mMap[pair.r][j] == 1 ){
								escape = true;
								break;
							}
						}
						if(escape){
							continue;
						}
						mVisited[pair.r][pair.c - i][DIR_WEST] = mVisited[pair.r][pair.c][pair.dir] + 1;
						q.add(new Pair(pair.r, pair.c - i, DIR_WEST));
						break;
						
					case DIR_SOUTH:
						if(pair.r + i >= R + 1 ||mVisited[pair.r + i][pair.c][DIR_SOUTH] > 0){
							continue;
						}
						for(int j = pair.r + 1; j <= pair.r + i ; j++){
							if( mMap[j][pair.c] == 1 ){
								escape = true;
								break;
							}
						}
						if(escape){
							continue;
						}
						mVisited[pair.r + i][pair.c][DIR_SOUTH] = mVisited[pair.r][pair.c][pair.dir] + 1;
						q.add(new Pair(pair.r + i, pair.c, DIR_SOUTH));
						break;
					case DIR_NORTH:
						if(pair.r - i < 1 ||mVisited[pair.r - i][pair.c][DIR_NORTH] > 0){
							continue;
						}

						for(int j = pair.r - 1; j >= (pair.r - i) ; j--){
							
							if( mMap[j][pair.c] == 1 ){
								
								escape = true;
								break;
							}
						}
						if(escape){
							continue;
						}
						mVisited[pair.r - i][pair.c][DIR_NORTH] = mVisited[pair.r][pair.c][pair.dir] + 1;
						q.add(new Pair(pair.r - i, pair.c, DIR_NORTH));
						break;
					}
					
				}
			}
		}

		if(mVisited[mDist.r][mDist.c][mDist.dir] == 0){
			System.out.println(0);
		}
		else{
			System.out.println(mVisited[mDist.r][mDist.c][mDist.dir] -1);
		}
		
	}

}
