import java.util.*;

class MESSAGE {
	private static Scanner sc = new Scanner(System.in);

	public static int[][] arr;
	public static int noOfSet;
	static int[] num;
	static int[] low;
	static int[] instack;
	static int[] visited;
	static int n;
	static int cnt = 0;
	static int numComp = 0;
	static Stack<Integer> stack = new Stack();
	static int belong[];
	static HashMap<Integer, Vector<Integer>> hm;

	public static void main(String[] args) {
		n = sc.nextInt();
		int m = sc.nextInt();

		arr = new int[n][n];
		num = new int[n];
		Arrays.fill(num, 0);
		instack = new int[n];
		Arrays.fill(instack, 0);
		visited = new int[n];
		Arrays.fill(visited, 0);
		belong = new int[n];
		Arrays.fill(belong, 0);

		low = new int[n];

		Arrays.fill(low, Integer.MAX_VALUE / 2);

		hm = new HashMap<Integer, Vector<Integer>>();

		for (int i = 0; i < n; i++) {
			Arrays.fill(arr[i], 0);
		}

		for (int i = 0; i < m; i++) {
			int A = sc.nextInt() - 1;
			int B = sc.nextInt() - 1;
			arr[A][B] = 1;
			if (hm.containsKey(A)) {
				hm.get(A).add(B);
			} else {
				hm.put(A, new Vector());
				hm.get(A).add(B);
			}
		}
		sc.close();
		for (int i = 0; i < n; i++) {
			if (num[i] == 0)
				dfs(i);
		}

		int rs = numComp;
		int[][] rsArr = new int[numComp][numComp];
		for (int i = 0; i < numComp; i++) {
			Arrays.fill(rsArr[i], 0);
		}

		for (int i = 0; i < n; i++) {
			if (hm.containsKey(i)) {
				for (int j : hm.get(i)) {
					if (belong[i] != belong[j] && arr[i][j] == 1) {
						rsArr[belong[i] - 1][belong[j] - 1] = 1;
					}
				}
			}
		}
		for (int i = 0; i < numComp; i++) {
			for (int j = 0; j < numComp; j++) {
				if (rsArr[j][i] == 1) {
					rs--;
					break;
				}
			}
		}

		System.out.print(rs);
	}

	public static void dfs(int k) {
		num[k] = ++cnt;
		low[k] = cnt;
		stack.add(k);
		instack[k] = 1;
		if (hm.containsKey(k)) {
			for (int i : hm.get(k)) {
				if (arr[k][i] != 0) {
					if (num[i] == 0) {
						dfs(i);
						low[k] = Math.min(low[k], low[i]);
					} else if (instack[i] == 1) {
						low[k] = Math.min(low[k], num[i]);
					}
				}
			}
		}
		if (num[k] == low[k]) {
			numComp++;
			while (true) {
				int v = stack.pop();
				belong[v] = numComp;
				instack[v] = 0;
				if (v == k)
					break;
			}
		}
	}
}