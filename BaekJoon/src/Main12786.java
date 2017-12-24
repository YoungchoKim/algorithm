import java.util.*;
public class Main12786 {
	static boolean[][] mMap;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int treeCount = sc.nextInt();
		int tCount = sc.nextInt();
		mMap = new boolean[21][treeCount];
		boolean[][][] visited = new boolean[21][treeCount][tCount + 1];
		for(int i = 0; i < treeCount; i++) {
			int n = sc.nextInt();
			for(int j = 0; j < n; j++) {
				int height = sc.nextInt();
				mMap[height][i] = true;
			}
		}
		PriorityQueue<Pair> q = new PriorityQueue<Pair>(new Comparator<Pair>() {
			@Override
			public int compare(Pair arg0, Pair arg1) {
				// TODO Auto-generated method stub
				if(arg0.tCount == arg1.tCount) {
					return arg0.goCnt - arg1.goCnt;
				}
				return arg0.tCount - arg1.tCount;
			}
			
		});
//		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(1, 0, -1));
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int nextGo = pair.goCnt + 1;
			int nextO = pair.curHeight;
			int nextA = pair.curHeight + 1;
			int nextB = pair.curHeight >= 10 ? 20 : pair.curHeight * 2;
			int nextC = pair.curHeight - 1;
			if(nextGo == treeCount) {
				int result = pair.tCount;
				System.out.println(result);
				return;
			}
			
			if(mMap[nextO][nextGo] && !visited[nextO][nextGo][pair.tCount]) {
				visited[nextO][nextGo][pair.tCount] = true;
				q.add(new Pair(nextO, pair.tCount, nextGo));
			}
			if(nextA < 21 && mMap[nextA][nextGo] && !visited[nextA][nextGo][pair.tCount]) {
				visited[nextA][nextGo][pair.tCount] = true;
				q.add(new Pair(nextA, pair.tCount, nextGo));
			}
			if(mMap[nextB][nextGo] && !visited[nextB][nextGo][pair.tCount]) {
				visited[nextB][nextGo][pair.tCount] = true;
				q.add(new Pair(nextB, pair.tCount, nextGo));
			}
			if(nextC > 0 && mMap[nextC][nextGo] && !visited[nextC][nextGo][pair.tCount]) {
				visited[nextC][nextGo][pair.tCount] = true;
				q.add(new Pair(nextC, pair.tCount, nextGo));
			}
			if(pair.tCount < tCount) {
				for(int i = 1; i < 21; i++) {
					if(mMap[i][nextGo] && !visited[i][nextGo][pair.tCount + 1]) {
						visited[i][nextGo][pair.tCount + 1] = true;
						q.add(new Pair(i, pair.tCount + 1, nextGo));
					}
				}				
			}
		}
		System.out.println(-1);
	}

	static class Pair{
		int curHeight;
		int tCount;
		int goCnt;
		public Pair(int curHeight, int tCount, int goCnt) {
			this.curHeight = curHeight;
			this.tCount = tCount;
			this.goCnt = goCnt;
		}
	}
}
