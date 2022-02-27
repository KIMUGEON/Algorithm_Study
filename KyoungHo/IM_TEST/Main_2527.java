package IM_Test.Silver1;

import java.util.Scanner;
/*
  [입력]
4개의 줄로 이루어져 있다. 
각 줄에는 8개의 정수가 하나의 공백을 두고 나타나는데, 
첫 4개의 정수는 첫 번째 직사각형을, 
나머지 4개의 정수는 두 번째 직사각형을 각각 나타낸다. 
단 입력 직사각형의 좌표 값은 1이상 50,000 이하의 정수로 제한된다. 

  [출력]
4개의 각 줄에 주어진 두 직사각형의 공통부분을 조사해서 해당하는 코드 문자를 출력파일의 첫 4개의 줄에 각각 차례대로 출력해야 한다.
 */
public class Main_2527 {// 직사각형

	public static void main(String[] args) {
//		============  입력   ==================
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 4; tc++) {

			int x = sc.nextInt();
			int y = sc.nextInt();

			int x1 = sc.nextInt();
			int y1 = sc.nextInt();

			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			
//			=======================================  풀이 및 출력   ==========================================
			
			// 점
			if ((x == x3 && y == y3) || (x1 == x2 && y1 == y2) || (x1 == x2 && y == y3) || (x == x3 && y1 == y2)) {
				System.out.println("c");
			}

			// 공통부분이 없음
			else if (x > x3 || x1 < x2 || y > y3 || y1 < y2) {
				System.out.println("d");
			} 
			
			// 선분
			else if (y == y3 || y1 == y2 || x == x3 || x1 == x2) {
				System.out.println("b");
			} 
			
			// 직사각형
			else
				System.out.println("a");
		}
	}

}
