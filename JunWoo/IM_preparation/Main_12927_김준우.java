package _0301_IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1~N개 까지의 전구, 1~N개 까지의 스위치
 * i번 스위치를 누르면 i의 배수 번호 전구를 모두 토글
 * 최대 몇번 스위치를 눌러야 하는지
 */
public class Main_12927_김준우 {
	static int size, score;
	static boolean[] lights;
	
	public static void press(int n) {
		for(int i = 1;i<=size;i++) {
			if(i%n == 0) {
				if(lights[i]) lights[i] = false;
				else lights[i] = true;
			}
		}
	}
	
	public static boolean alloff() {
		for(int i = 1;i<=size;i++) {
			if(lights[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		size = str.length();
		lights = new boolean[size+1];
		score = 0;
		
		for (int i = 0; i < size; i++) {
			if(str.charAt(i) == 'Y')
				lights[i+1] = true;
			else lights[i+1] = false;
		}
		
		int i = 1;
		while(!alloff()) {
			if(lights[i]) {
				press(i);
				score++;
			}
			i++;
		}
		
		if(alloff()) System.out.println(score);
		else System.out.println(-1);
	}

}
