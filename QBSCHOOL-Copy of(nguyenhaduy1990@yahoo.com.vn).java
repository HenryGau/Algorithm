import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

class QBSCHOOL {

	/**
	 * 3 2 1 1 2 3 2 2 3 1
	 */

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt(); // no of Nodes

		int m = sc.nextInt(); // no of edges

		HashMap<Integer, Vector<Destination>> hashM = new HashMap<Integer, Vector<Destination>>();
		for (int i = 0; i < n; i++) {
			Vector<Destination> value = new Vector<Destination>();
			hashM.put(i, value);
		}
		int A, B, len;
		for (int i = 0; i < m; i++) {
			if (sc.nextInt() == 1) {

				A = sc.nextInt() - 1;
				B = sc.nextInt() - 1;
				len = sc.nextInt();
				hashM.get(A).add(new Destination(B, len));
			} else {
				A = sc.nextInt() - 1;
				B = sc.nextInt() - 1;
				len = sc.nextInt();
				hashM.get(A).add(new Destination(B, len));
				hashM.get(B).add(new Destination(A, len));
			}
		}
		int[][] rs = new int[n][3];
		// 0 - dist
		// 1 - no of ways
		// 2 - visited

		rs[0][0] = 0;
		rs[0][1] = 1;
		rs[0][2] = 0;
		for (int i = 1; i < n; i++) {
			rs[i][0] = Integer.MAX_VALUE / 2;
			rs[i][1] = 0;
			rs[i][2] = 0;
		}

		PriorityQueue<Element> q = new PriorityQueue<Element>();
		q.add(new Element(0, 0));
		while (!q.isEmpty()) {
			Element curr = q.poll();
			q.remove(curr);
			int u = curr.node;
			if (rs[u][2] != 0)
				continue;
			rs[u][2] = 1;

			for (Destination next : hashM.get(u)) {
				int v = next.node;
				int length = next.lenToNode;

				if (rs[v][0] > rs[u][0] + length) {
					rs[v][0] = rs[u][0] + length;
					q.add(new Element(v, rs[v][0]));
					rs[v][1] = rs[u][1];
				} else if (rs[v][0] == rs[u][0] + length) {
					rs[v][1] += rs[u][1];
				}
			}
		}
		System.out.print(rs[n - 1][0] + " " + rs[n - 1][1]);
	}
}

class Destination {
	public int node;
	public int lenToNode;

	public Destination(int node, int lenToNode) {
		this.node = node;
		this.lenToNode = lenToNode;
	}
}

class Element implements Comparable<Element> {
	public int node;
	public int len;

	public Element(int dest, int len) {
		this.node = dest;
		this.len = len;
	}

	public int compareTo(Element other) {
		return Double.compare(len, other.len);
	}
}
