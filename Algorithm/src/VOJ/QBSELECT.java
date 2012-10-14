package VOJ;

import java.util.Scanner;

class QBSELECT {

	// start 5:07 pm
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] arr = new int[4][n];
		int[][] rs = new int[n][(2 << 4) - 1];
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < n; i++) {
				arr[j][i] = sc.nextInt();
			}
		}
		for (int i = 0; i <= 15; i++) {
			for (int j = 0; j < 4; j++)
				if ((((i >> j) & 1) == 1) && check(i))
					rs[0][i] += arr[j][0];
		}
		int sum;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= 15; j++) {// new column
				if (!check(j))
					continue;
				sum = 0;
				for (int k = 0; k < 4; k++) {
					if (((j >> k) & 1) == 1)
						sum += arr[k][i];
				}
				for (int k = 0; k <= 15; k++) {// check old row cell
					if (((j & k) == 0)){
						rs[i][j] = Math.max(rs[i][j], rs[i - 1][k] + sum);
					}
				}
			}
		}
		int result = 0;
		for(int i = 0; i <= 15; i ++)
			if(check(i))
				result = Math.max(result, rs[n-1][i]);
		if(result < 0){
			int min = Integer.MIN_VALUE;
			for(int i = 0; i < n; i ++){
				for(int j = 0; j < 4; j++)
					min = Math.max(min, arr[i][j]);
				System.out.println(min);
			}
		}else 
			System.out.println(result);
		
	}

	public static boolean check(int i) {
		if ((i & (8 + 4)) == 12)
			return false;
		if ((i & (4 + 2)) == 6)
			return false;
		if ((i & (2 + 1)) == 3)
			return false;
		return true;
	}
}
