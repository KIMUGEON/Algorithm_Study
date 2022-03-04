import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12927_배수_스위치 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = new String(bf.readLine());
		
		char[] arr = new char[str.length()+1]; // 전구의 상태 저장 배열
		int cnt = 0; // 스위치 클릭 횟수
		
		for (int i = 0; i < str.length(); i++) { // 전구의 상태 입력받기
			arr[i+1] = str.charAt(i);
		}
		
		for (int i = 0; i <= str.length(); i++) { // 모든 전구 끄기
			if(arr[i]=='Y') { // 현재 전구가 켜져있다면
				cnt++; // 스위치 클릭 횟수 +1
				int temp = i; // i의 배수를 위한 변수
				while (temp<=str.length()) {
					if(arr[temp] == 'N') arr[temp] = 'Y'; // 전구의 상태 반전
					else arr[temp] = 'N';
					temp += i;
				}
			}
		}
		
		System.out.println(cnt); // 출력
	}
}
