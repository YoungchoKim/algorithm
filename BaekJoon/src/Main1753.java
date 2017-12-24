import java.util.*;
import java.io.*;
public class Main1753 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		//LinkedList<Edge>[] edge = new LinkedList[V + 1];
		//Vector<Vector<Edge>> ed = new Vector<Vector<Edge>>();
		ArrayList<ArrayList<Edge>> ed2 = new ArrayList<ArrayList<Edge>>();
		for(int i = 0; i <= V; i++) {
			ed2.add(new ArrayList<Edge>());
			//edge[i] = new LinkedList<Edge>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			ed2.get(u).add(new Edge(v, w));
			//edge[u].add(new Edge(v, w));
		}
		
		int[] result = new int[V + 1];
		Arrays.fill(result, -1);
		
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		
		result[start] = 0;
		q.add(new Edge(start, 0));
		
		while(!q.isEmpty()) {
			Edge e = q.poll();
			int u = e.v;
			for(int i = 0; i < ed2.get(u).size(); i++) {
//				int v = edge[u].get(i).v;
//				int w = edge[u].get(i).w;
				int v = ed2.get(u).get(i).v;
				int w = ed2.get(u).get(i).w;
				int nextW = result[u] + w;
				
				if(result[v] == -1 || result[v] > nextW) {
					q.add(new Edge(v, nextW));
					
					result[v] = nextW;
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			System.out.println(result[i] == -1 ? "INF" : result[i]);
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		int v;
		int w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge arg0) {
			// TODO Auto-generated method stub
			return this.w - arg0.w;
		}
	}

}
