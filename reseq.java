import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class reseq {

	public static char[] data;
	public static int index;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("reseq.inp"));
		int numTest = Integer.parseInt(in.readLine());

		for (int i = 0; i < numTest; i++) {
			int n = Integer.parseInt(in.readLine());
			data = in.readLine().toCharArray();
			index = 0;
			int[] dub = new int[n];
			for (int j = 0; j < n; j++) {
				dub[j] = j+1;
			}
			int[] rs = revMergeSort(dub);
			int[] realRs = new int[n];
			for (int j = 0; j < n; j++) {
				realRs[rs[j] - 1] = j + 1;
			}
			System.out.println(checksum(realRs));
		}
	}
	
	public static int checksum(int[] arr){
		int rs = 1;
		for(int i = 0; i < arr.length; i++)
			rs = (31 * rs + arr[i])%1000003;
		return rs;
	}

	public static int[] revMergeSort(int[] arr) {
		int n = arr.length;
		if (n <= 1)
			return arr;
		int mid = n / 2;
		int[] first_half = revMergeSort(Arrays.copyOfRange(arr, 0, mid));// 0 - mid
		int[] second_half = revMergeSort(Arrays.copyOfRange(arr, mid, n));// mid -> end
		return merge(first_half, second_half);
	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int n = arr1.length + arr2.length;
		int no1 = 0;
		int no2 = 0;
		int[] rs = new int[arr1.length + arr2.length];
		for (int i = 0; i < n; i++) {
			if (data[index] == '1') {
				no1++;
				rs[i] = arr1[no1 - 1];
				index++;
				if (no1 == arr1.length)
					for (int j = no2; j < arr2.length; j++)
						rs[++i] = arr2[j];
			} else {
				no2++;
				rs[i] = arr2[no2 - 1];
				
				index++;
				if (no2 == arr2.length)
					for (int j = no1; j < arr1.length; j++)
						rs[++i] = arr1[j];
			}
		}
		return rs;
	}
}