package Silver3;

import java.util.Arrays;
import java.util.Scanner;

/*
  [입력]
첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다. 
둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)
 */
public class Main_11399 {// ATM

	public static void main(String[] args) {
//		===============  입력   ===============
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int sum = 0;	//총합
		int sum2 = 0;	//이전까지 합
		int time[] = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
//		===============  해결   ===============
		Arrays.sort(time);	//정렬

		for (int i = 0; i < N; i++) {
			sum += sum2 + time[i];	//이전까지 합과 현재 시간 더해줌
			sum2 += time[i];		//이전까지 합에 현재 시간 더해줌
		}
//		===============  출력   ===============
		System.out.println(sum);

	}

}
