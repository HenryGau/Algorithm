import java.util.*;

//http://codeforces.com/contest/228/problem/E

public class Round141Div2E {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][n];

		for (int i = 0; i < m; i++) {
			Arrays.fill(arr[i], -1);

		}
		int A;
		int B;
		int len;
		for (int i = 0; i < m; i++) {
			A = sc.nextInt() - 1;
			B = sc.nextInt() - 1;
			len = sc.nextInt();
			arr[A][B] = len;
			arr[B][A] = len;
		}

		int[] visited = new int[n];
		int[] belong = new int[n];
		Arrays.fill(visited, 0);
		for (int i = 0; i < n; i++)
			belong[i] = -i - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (arr[i][j] == 1) {
					if (belong[i] == -1)
						belong[i] = i;
					belong[j] = belong[i];
				}
			}
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (arr[i][j] == 0) {
					if (belong[i] == belong[j]) {
						System.out.print("Impossible");
						return;
					}
				}
			}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (belong[i] != belong[j]
						&& (belong[i] != Integer.MIN_VALUE && belong[j] != Integer.MIN_VALUE)) {
					for (int k = 0; k < n; k++) {
						int checker = belong[j];
						if (belong[k] == checker) {
							belong[k] = Integer.MIN_VALUE;
						}
					}
				}
			}
		// TODO: chi moi simplify bai toan thoi chu chua giai quyet dc bai toan ...
		
		int count = 0;
		for (int i = 0; i < n; i++)
			if (belong[i] != Integer.MIN_VALUE)
				count++;

		System.out.println(count);
		for (int i = 0; i < n; i++)
			if (belong[i] != Integer.MIN_VALUE)
				System.out.print((i + 1) + " ");
	}
}
