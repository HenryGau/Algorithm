

import java.util.*;

public class Round140Div2E1 {
	static int[][] arr;

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

		boolean visited[] = new boolean[n];
		Arrays.fill(visited, false);
		
		int[] compul = new int[n];
		Arrays.fill(compul, -1);
		
		for (int i = 0; i < n; i++) {
			for(int j = 0 ; j < n ; j++){
				if(arr[i][j] == 0){
					
					visited[i] = true;
					for(int k = 0 ; k < n ; k ++){
						if(arr[i][k] == 1){
							compul[k] = 1;
						}else if(arr[i][k] == 0)
							compul[k] = 0;
					}
					return;
				}
			}
		}
	}

}
