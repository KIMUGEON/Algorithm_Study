import java.util.Scanner;

/*
  [입력]
첫째 줄에 전구의 상태가 1번 전구부터 차례대로 주어진다. 
Y는 전구가 켜 있는 경우, N은 전구가 꺼져있는 경우이다. 
전구의 개수는 1보다 크거나 같고 1,000보다 작거나 같은 자연수이다.

  [출력]
모든 전구를 끄기 위해서 스위치를 몇 번 눌러야 하는지 출력한다. 만약, 모든 전구를 끌 수 없다면 -1을 출력한다.
 */
public class Main_12927 {// Silver4_배수 스위치

	public static void main(String[] args) {
//		=============  입력   =================
		Scanner sc = new Scanner(System.in);

		String line = sc.next(); //한줄 읽어서
		int N = line.length(); //줄 길이 저장

		char light[] = new char[N]; //줄 길이만큼 배열 만들기

		for (int i = 0; i < N; i++) {
			light[i] = line.charAt(i); //전구 배열에 값 넣기 (Y=켜져있는 경우, N=꺼져있는 경우)
		}

//		=============  풀이   =================
		int cnt = 0; //스위치 눌러야하는 횟수

		for (int i = 0; i < N; i++) { 
			if (light[i] == 'Y') { //전구가 Y면
				cnt++; //카운트 증가하고
				for (int j = i; j < N; j += i + 1) { //i번째부터 i의 배수들 스위치 상태 바꾸기
					light[j] = light[j] == 'Y' ? 'N' : 'Y';
				}
			}
		}
		
//		=============  출력   =================
		System.out.println(cnt);
	}
}
