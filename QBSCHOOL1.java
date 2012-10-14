import java.util.*;

class QBSCHOOL1 {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();

		int[][] input = new int[n][n];
		for(int i = 0 ; i < n ; i ++)
			Arrays.fill(input[i], -1);

		for (int i = 0; i < m; i++) {
			int cond = in.nextInt();
			int A = in.nextInt() - 1;
			int B = in.nextInt() - 1;
			int len = in.nextInt();
			if (cond == 1) {
				input[A][B] = len;
			} else {
				input[A][B] = len;
				input[B][A] = len;
			}
		}
		
		// int lab[] = new int[n];
		// Arrays.fill(lab, 0);

		int[] len = new int[n];
		Arrays.fill(len, Integer.MAX_VALUE);
		len[0] = 0;

		Boolean[] visited = new Boolean[n];
		Arrays.fill(visited, false);
		visited[0] = true;

		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		q.add(new Vertex(0, 0));

		while (!q.isEmpty()) {
			Vertex u = q.poll();
			q.remove(u);

			for (int i = 0; i < n; i++) {
				if (input[u.verID][i] != -1) {
					if (len[i] > u.lenToVer + input[u.verID][i] && !visited[i]) {
						len[i] = u.lenToVer + input[u.verID][i];
						q.add(new Vertex(i, len[i]));
					}
				}
			}
		}
		
		System.out.print(len[2]);

	}

}

class Vertex implements Comparable<Vertex> {
	int verID;
	int lenToVer;

	@Override
	public int compareTo(Vertex arg0) {
		return Double.compare(lenToVer, arg0.lenToVer);
	}

	public Vertex(int verId, int len) {
		this.verID = verId;
		this.lenToVer = len;
	}
}
