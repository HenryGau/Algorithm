package VOJ;

import java.io.*;
import java.util.*;

class TRIP {
	public static void main(String[] args) throws Exception{

		for (int input = 8; input <= 12; input++) {
			BufferedReader br = new BufferedReader(new FileReader(input + ".in"));
			Scanner sc = new Scanner(input + ".in");
			
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			br.close();

			int[][] rs = new int[1 << n][n];

			for (int i = 0; i < 1 << n; i++) {
				Arrays.fill(rs[i], Integer.MAX_VALUE / 2);
			}

			for (int i = 0; i < n; i++) { // fill in initial condition
				
				rs[1 << i][i] = 0;
			}

			for (int s = 0; s < (1 << n); s++) {
				for (int u = 0; u < n; u++) {
					if (((s >> u) & 1) == 1) {
						for (int v = 0; v < n; v++) {
							if (arr[v][u] > 0 && ((s >> v) & 1) == 1) {
								rs[s][u] = Math.min(rs[s][u],
										rs[s - (1 << u)][v] + arr[v][u]);
							}
						}
					}
				}
			}

			int finalRS = Integer.MAX_VALUE / 2;
			for (int i = 0; i < n; i++) {
				finalRS = Math.min(rs[(1 << n) - 1][i], finalRS);
			}
			System.out.println(finalRS);
		}
	}
}