import java.util.*;
/**
 *  BFS를 활용하여 각각의 날마다 주식을 산경우, 주식을 유지하는 경우, 파는경우 
 *  3 경우를 모두 탐색한다.
 *  Pair 클래스는 큐 안에 들어가는 모델 클래스이며, 
 *  구입한 주식 수, 주식 구매 비용, 현재 날짜, 이득 비용을 저장한다. 
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-- > 0){
			int result = 0;
			int n = Integer.parseInt(sc.nextLine());
			int[] cost = new int[n + 1];
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			for(int i = 1; i <= n; i++){
				cost[i] = Integer.parseInt(st.nextToken());
			}
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(new Pair(1, cost[1], 1, 0));	// 첫날 주식을 산 경우
			q.add(new Pair(0, 0, 1, 0));	// 첫날 아무것도 하지 않는 경우 
			
			while(!q.isEmpty()){
				Pair pair = (Pair)q.poll();
				if(pair.currentDay + 1 > n){	// 마지막 날 
					if(result < pair.profit){
						result = pair.profit;
					}
					continue;
				}
				
				int nextDay = pair.currentDay + 1;
				q.add(new Pair(pair.numberOfStock + 1, pair.totalCost + cost[nextDay], nextDay, pair.profit));	 // 주식을 산 경우
				q.add(new Pair(pair.numberOfStock, pair.totalCost, nextDay, pair.profit));		// 아무것도 하지 않는 경우 
				
				int profit = pair.numberOfStock * cost[nextDay] - pair.totalCost;
				q.add(new Pair(0, 0, nextDay,  pair.profit + profit));	// 주식을 파는 경우 
			}
			
			System.out.println(result);
			
		}
		
	}
	
}
class Pair{
	int numberOfStock;
	int totalCost;
	int currentDay;
	int profit;
	public Pair(int numberOfStock, int totalCost, int currentDay, int profit){
		this.numberOfStock = numberOfStock;
		this.totalCost = totalCost;
		this.currentDay = currentDay;
		this.profit = profit;
	}
}
