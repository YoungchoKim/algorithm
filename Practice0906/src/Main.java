import java.util.*;
/**
 *  BFS�� Ȱ���Ͽ� ������ ������ �ֽ��� ����, �ֽ��� �����ϴ� ���, �Ĵ°�� 
 *  3 ��츦 ��� Ž���Ѵ�.
 *  Pair Ŭ������ ť �ȿ� ���� �� Ŭ�����̸�, 
 *  ������ �ֽ� ��, �ֽ� ���� ���, ���� ��¥, �̵� ����� �����Ѵ�. 
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
			q.add(new Pair(1, cost[1], 1, 0));	// ù�� �ֽ��� �� ���
			q.add(new Pair(0, 0, 1, 0));	// ù�� �ƹ��͵� ���� �ʴ� ��� 
			
			while(!q.isEmpty()){
				Pair pair = (Pair)q.poll();
				if(pair.currentDay + 1 > n){	// ������ �� 
					if(result < pair.profit){
						result = pair.profit;
					}
					continue;
				}
				
				int nextDay = pair.currentDay + 1;
				q.add(new Pair(pair.numberOfStock + 1, pair.totalCost + cost[nextDay], nextDay, pair.profit));	 // �ֽ��� �� ���
				q.add(new Pair(pair.numberOfStock, pair.totalCost, nextDay, pair.profit));		// �ƹ��͵� ���� �ʴ� ��� 
				
				int profit = pair.numberOfStock * cost[nextDay] - pair.totalCost;
				q.add(new Pair(0, 0, nextDay,  pair.profit + profit));	// �ֽ��� �Ĵ� ��� 
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
