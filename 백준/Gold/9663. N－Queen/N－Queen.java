import java.io.*;

public class Main {
	public static int[] arr;
	public static int cnt = 0;
	public static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		nQueen(0);
		System.out.println(cnt);
	}
	
	public static void nQueen(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			if (Possibility(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	
	public static boolean Possibility(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			}
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
