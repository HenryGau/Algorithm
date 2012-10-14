package VOJ;

import java.util.*;

public class TRIP {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);;
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		for(int i = 0 ; i < n ; i++){
			for(int j = 0; j < n ; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		int[][] rs = new int[1<<n][n];
		
		for(int i = 0 ; i < 1<<n; i ++){
			Arrays.fill(rs, Integer.MAX_VALUE/2);
		}
		
		for(int i = 0 ; i < n; i ++){
			rs[1<<i][i] = 0;
		}
		
		for( int u = 0 ; u < 1<<n-1; u ++){
			for( int v = 0 ; v < n ; v ++){
				if(((u >> v & 1) == 1) && arr[v][u] > 0){
					rs[u][v] = Math.min(rs[u][v], rs[u - (1 << v)][v] + arr[v][u]);
				}
			}
		}
		int finalRS = Integer.MAX_VALUE/2;
		for(int i = 0 ; i < n; i ++){
			finalRS = Math.min(rs[1 << n - 1][i], finalRS);
		}
		System.out.println(finalRS);
	}

}

