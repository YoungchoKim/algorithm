import java.util.*;
class Pair{
	int floor;
	int cnt;
	public Pair(int floor, int cnt){
		this.floor = floor;
		this.cnt = cnt;
	}
}
public class Main {
	public static int mFloorCurrent, mFloorTotal, mFloorGoal;
	public static int UP, DOWN;
	
	public static boolean[] mVisited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		mFloorTotal = sc.nextInt();
		mFloorCurrent = sc.nextInt();
		mFloorGoal = sc.nextInt();
		UP = sc.nextInt();
		DOWN = sc.nextInt();
		
		mVisited = new boolean[mFloorTotal + 1];
		
		Queue<Pair> q = new LinkedList();
		q.add(new Pair(mFloorCurrent, 0));
		mVisited[mFloorCurrent] = true;
		while(!q.isEmpty()){
			Pair pair = q.poll();
			
			if(pair.floor == mFloorGoal){
				System.out.println(pair.cnt);
				return;
			}
			
			int nextFloor = pair.floor + UP;
			if(nextFloor <= mFloorTotal && !mVisited[nextFloor]){
				q.add(new Pair(nextFloor, pair.cnt+1));
				mVisited[nextFloor] = true;
			}
			
			nextFloor = pair.floor - DOWN;
			
			if(nextFloor >= 0 && !mVisited[nextFloor]){
				q.add(new Pair(nextFloor, pair.cnt + 1));
				mVisited[nextFloor] = true;
			}
		}
		
		System.out.println("use the stairs");
		
	}

}
