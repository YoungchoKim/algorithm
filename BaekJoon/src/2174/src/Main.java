import java.io.*;
import java.util.*;
class Robot{
	int r;
	int c;
	int dir;
	public Robot(int r, int c, int dir){
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
}
class Action{
	int robot;
	char action;
	int repeat;
	
	public Action(int robot, char action, int repeat){
		this.robot = robot;
		this.action = action;
		this.repeat = repeat;
	}
}
public class Main {
	public static int R, C;
	public static Robot mRobot[];
	public static Action mAction[];
	public static int mVisited[][];
	public static int N; //·Îº¿ ¼ö
	public static int M; //¸í·É ¼ö
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		mVisited = new int[R+1][C+1];
		
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mRobot = new Robot[N + 1];
		mAction = new Action[M + 1];
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			mVisited[r][c] = i;
			mRobot[i] = new Robot(r, c, returnDirectionNumber(dir));
		}
		for(int i = 1; i <= M; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int robotNum = Integer.parseInt(st.nextToken());
			char action = st.nextToken().charAt(0);
			int repeat = Integer.parseInt(st.nextToken());
			mAction[i] = new Action(robotNum, action, repeat);
		}
//		for(int i = 1; i <= R; i++){
//			for(int j = 1; j <= C ; j++){
//				System.out.print(mVisited[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();

		
		
		for(int i = 1; i <= M; i++){
			int robotNum = mAction[i].robot;
			if(mAction[i].action == 'F'){
				int dy[] = {1, 0, -1, 0};	//ºÏµ¿³²¼­
				int dx[] = {0, 1, 0, -1};			
				for(int j = 1; j <= mAction[i].repeat; j++){
					int dir = mRobot[robotNum].dir;
		
					int nextC = mRobot[robotNum].c + dx[dir];
					int nextR = mRobot[robotNum].r + dy[dir];
					if(nextC <1 || nextC >= C+1 || nextR < 1 || nextR >= R+1){
						System.out.println("Robot "+ robotNum +" crashes into the wall");
						return;
					}
					if(mVisited[nextR][nextC] > 0){
						System.out.println("Robot "+robotNum+" crashes into robot "+mVisited[nextR][nextC]);
						return;
					}
					else{
						mVisited[mRobot[robotNum].r][mRobot[robotNum].c] = 0;
						mVisited[nextR][nextC] = robotNum;
						mRobot[robotNum].r = nextR;
						mRobot[robotNum].c = nextC;
					}
				}
			}
			else{
				for(int j = 1; j <= mAction[i].repeat; j++){
					if(mAction[i].action == 'R'){
						mRobot[robotNum].dir++;
					}
					else if(mAction[i].action == 'L'){
						mRobot[robotNum].dir--;
					}
					if(mRobot[robotNum].dir == 4){
						mRobot[robotNum].dir = 0;
					}
					else if (mRobot[robotNum].dir == -1){
						mRobot[robotNum].dir = 3;
					}
				}
				
			}
		}
//		for(int i = 1; i <= R; i++){
//			for(int j = 1; j <= C ; j++){
//				System.out.print(mVisited[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();

		
		
		System.out.println("OK");
		
	}
	public static int returnDirectionNumber(String s){
		if(s.charAt(0) == 'W'){
			return WEST;
		}
		else if(s.charAt(0) == 'E'){
			return EAST;
		}
		else if(s.charAt(0) == 'N'){
			return NORTH;
		}
		else if(s.charAt(0) == 'S'){
			return SOUTH;
		}
		
		return 0;
	}

}
