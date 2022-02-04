package case_12.Silver5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_10814 {// 나이순 정렬

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String person[][] = new String[N][2];
		for (int i = 0; i < N; i++) { //나이, 이름 입력
			person[i][0] = sc.next();
			person[i][1] = sc.next();
		}

		Arrays.sort(person, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);	//양수면 o1 먼저 음수면 o2먼저 정렬 0이면 그대로
			} 
		});
		for(int i=0; i<N; i++) {
			System.out.println(person[i][0] + " " + person[i][1]);
		}
	}

}
