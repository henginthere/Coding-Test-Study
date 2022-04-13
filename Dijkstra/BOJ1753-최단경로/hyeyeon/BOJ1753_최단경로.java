package A0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int node;
	int cost;
	Edge(int node, int cost){
		this.node = node;
		this.cost = cost;
	}
	@Override
    public int compareTo(Edge node) { //�켱����: ����� ���� ��
        return this.cost <= node.cost ? -1 : 1;
    }
}
public class BOJ1753_�ִܰ�� {
	static int V, E, K;
	static ArrayList<ArrayList<Edge>> arr;
	static int[] dist;
	static void solve(int n) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[n]=0;
		pq.add(new Edge(n,dist[n])); //�켱���� ť�� ������ ���������� �� ���������� �ִ� �Ÿ��� ��´�
		
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int tmpNode = tmp.node;
			int tmpCost = tmp.cost;
			
			if(tmpCost>dist[tmpNode]) continue;
			
			for(Edge e : arr.get(tmpNode)) {
				int nxtNode = e.node;
				int nxtCost = e.cost;
				if(tmpCost+nxtCost<dist[nxtNode]) {
					dist[nxtNode]=tmpCost+nxtCost;
					pq.add(new Edge(nxtNode,dist[nxtNode]));
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		arr = new ArrayList<ArrayList<Edge>>();
		dist = new int[V+1];
		//��������Ʈ, �ִܰŸ� �迭 �ʱ�ȭ
		for(int i=0;i<=V;i++) {
			arr.add(new ArrayList<>());
			dist[i]=Integer.MAX_VALUE;
		}
		//��������Ʈ �Է�
		for(int i=1;i<=E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr.get(u).add(new Edge(v,w));
		}
		
		solve(K);
		
		for(int i=1;i<=V;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else
				System.out.println(dist[i]);
			
		}
		
	}

}
