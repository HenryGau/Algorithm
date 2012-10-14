import java.util.Arrays;
import java.util.Scanner;

class NKRACING {

	/**
	 * IN: 6 7 1 2 5 2 3 3 1 4 5 4 5 4 5 6 4 6 3 3 5 2 3 OUT: 6
	 */
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] graph = new int[n][n];

		int x;
		int y;
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();

			graph[x - 1][y - 1] = sc.nextInt();
		}
		int[][] out = graph.clone();
//		algo(graph, out);

	}

	public static void algo(int[][] in) {
		int[] dist = new int[in.length];
		int[] pred = new int[in.length];
		boolean[] visited = new boolean[in.length];

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		for (int i = 0; i < dist.length; i++) {
			final int next = minVertex(dist, visited);
			visited[next] = true;

//			final int[] n = G.neighbors(next);
//			for (int j = 0; j < n.length; j++) {
//				final int v = n[j];
//				final int d = G.getWeight(next, v);
//				if (dist[v] > d) {
//					dist[v] = d;
//					pred[v] = next;
//				}
//			}
		}
	}

	public static int minVertex(int[] dist, boolean[] v) {
		int x = Integer.MAX_VALUE;
		int y = -1;
		for (int i = 0; i < dist.length; i++)
			if (!v[i] && dist[i] < x) {
				y = i;
				x = dist[i];
			}
		return y;

	}

}
