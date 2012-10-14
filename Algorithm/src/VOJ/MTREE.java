package VOJ;

import java.util.Arrays;
import java.util.Scanner;

public class MTREE {

	static int rs = 0;
	static int[][] arr;
	static int n;
	static int visited[];
	static int fu[];
	static int sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n][n];
		for(int i = 0 ; i < n ; i ++){
			Arrays.fill(arr[i], -1);
		}
		visited = new int[n];
		fu = new int[n];
		
		int a,b;
		for(int i = 0 ; i < n-1 ; i++){
			a = sc.nextInt() - 1;
			b = sc.nextInt() - 1;
			int c = sc.nextInt();
			arr[a][b] = c;
			arr[b][a] = c;
		}
		dfs(0);
		System.out.println(sum);
	}
	
	public static void dfs(int u){
		visited[u] = 2;
		int summer = 1;
		int counter = 0;
		boolean leaf = true;
		for(int i = 0 ; i < n; i ++){
			if(visited[i] == 0 && arr[u][i] != -1){ 
				visited[i] = 1;
				dfs(i);
				fu[u] += arr[u][i]*fu[i] + arr[u][i];
				summer *= fu[i] == 0 ? arr[u][i] : arr[u][i]*fu[i];
//				sum += arr[u][i];
				leaf = false;
				counter+=1;
			}
		}
		for(int i = 0; i < n ; i ++){
			if(visited[i] == 1 && arr[u][i] != -1){
//				if(counter > 1 || fu[i] != 0)
					sum += arr[u][i] + 3;
				visited[i] = 2;
			}
		}
		
		if(leaf)
			fu[u] = 0;
		else 
			sum += summer;
	}

}
