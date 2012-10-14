

import java.util.Arrays;
import java.util.Scanner;

public class Round140Div1D {
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		boolean[] changeRow = new boolean[n];
		boolean[] changeCol = new boolean[m];
		Arrays.fill(changeRow, false);
		Arrays.fill(changeCol, false);
		
		int sum;
		boolean changed = false;
		while (true) {
			changed = false;
			for (int i = 0; i < n; i++) {
				sum = 0;
				for (int j = 0; j < m; j++) {
					sum += arr[i][j];
				}
				if (sum < 0) {
					changed = true;
					changeRow[i] = !changeRow[i];
					for (int k = 0; k < m; k++)
						arr[i][k] = -arr[i][k];
					break;
				}
			}
			for (int i = 0; i < m; i++) {
				sum = 0;
				for (int j = 0; j < n; j++) {
					sum += arr[j][i];
				}
				if (sum < 0) {
					changed = true;
					changeCol[i] = !changeCol[i];
					for (int k = 0; k < n; k++)
						arr[k][i] = -arr[k][i];
					break;
				}
			}
			if(changed == false)
				break;
		}
		int rs = 0;
		
		for(int i = 0 ; i < n; i ++)
			if(changeRow[i])
				rs ++;
		
		System.out.print(rs + " ");
		for(int i = 0 ; i < n; i ++)
			if(changeRow[i])
				System.out.print((i+1) + " ");
		
		rs = 0;
		for(int i = 0 ; i < m; i ++)
			if(changeCol[i])
				rs ++;
		System.out.println();
		System.out.print(rs + " ");
		for(int i = 0 ; i < m; i ++)
			if(changeCol[i])
				System.out.print((i+1) + " ");
	}
}