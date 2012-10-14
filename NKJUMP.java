import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

class NKJUMP {
	private static Scanner sc = new Scanner( System.in );
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i ++){
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		HashMap<Integer, Vector<Integer>> hashM = new HashMap<Integer, Vector<Integer>>();
		for(int i = 0; i < n ; i ++){
			Vector<Integer> a = new Vector<Integer>();
			a.add((int)-i);
			hashM.put(arr[i], a);
		}
		
		for(int i = 0; i < n ; i ++){
			for(int j = 0; j < n ; j++)
			{
				if (i == j) continue;
				if(hashM.containsKey(arr[i] + arr[j])){
					hashM.get(arr[i]).add(arr[i] + arr[j]);
				}
			}
		}
		int[] rs = new int[n];
		
		Arrays.fill(rs, 1);
		
		//Dynamic Programming
		rs[0] = 1;
		int dest, loc;
		int Size;
		
		for(int i = 0 ; i < n ; i ++){
			Size = hashM.get(arr[i]).size();
			
			for(int j = 0; j < Size; j ++){
				dest = hashM.get(arr[i]).get(j);
				if( dest <= 0)
					continue;
				loc = hashM.get(dest).get(0);
				
				rs[(int)-loc] = Math.max(rs[(int)-loc],rs[i] + 1);
			}
		}
		
		int RS = 1;
		for(int i = 0 ; i < n ; i ++)
			RS = Math.max(RS, rs[i]);
		System.out.print(RS);
	}
}
