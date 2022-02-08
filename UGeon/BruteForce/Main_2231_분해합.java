import java.util.Scanner;

public class Main_2231_분해합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		boolean check = false;

		for (int i = 1; i < N; i++) { // 1부터 N의 생성자 M 검사, 1부터 검사하기 때문에 가장 작은 생성자 비교할 필요x

			int temp = i;
			int sum = i;

			while (temp != 0) { // 분해합 ex) 198
				sum += (temp % 10); // +8 +9 +1
				temp = (temp / 10); // 19 1 0
			}

			if (sum == N) { // 분해합이 N과 같으면 출력 및 for문 탈출
				System.out.println(i);
				check = true;
				break;
			}

		}

		if (check == false) { // 생성자 M이 없는 경우 0 출력
			System.out.println(0);
		}
		
	}
}