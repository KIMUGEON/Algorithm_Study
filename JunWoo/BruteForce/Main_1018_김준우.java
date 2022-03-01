import java.util.Scanner;

public class Main_1018_김준우 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] board = new char[N][M];
		char[][] board8 = new char[8][8];
		int min = 65;
		for(int i = 0;i<N;i++) {
			String temp = sc.next();
			for(int j = 0;j<M;j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<8;j++) {
				if(i%2 + j%2 == 1) {
					board8[i][j] = 'B';
				}
				else {
					board8[i][j] = 'W';
				}
			}
		}
		for(int i = 0;i<N-7;i++) {
			for(int j = 0;j<M-7;j++) {
				int count =0;
				for(int n =0;n<8;n++) {
					for(int m =0;m<8;m++) {
						if(board[i+n][j+m] != board8[n][m]) {
							count++;
						}
					}
				}
				//System.out.println(i+""+count+""+j);
				if(count>32)count = 64-count;
				if(count < min) {
					min = count;
				}
			}
		}
		System.out.println(min);
		
	}
}
