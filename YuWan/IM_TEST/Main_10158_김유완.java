package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 
 *  - Y좌표는 012321012321->0부터H까지 계속 반복해서 나옴
 *  - X좌표는 w+h가 홀수면 12345654321->0없이 계속 반복
 *         w+h가 짝수면 0123456543210 ->0있게 계속 반복
 *  ## java 11에서는 시간초과인데 java8로 돌리면 됨 ##
 *         
 */
public class Main_10158_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 개미 초기 위치
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		long t = Long.parseLong(br.readLine());
		long x,y;
		// 홀수이면 0포함 하지 않음
		// 이거 계산하느라 어려움
		x = w - Math.abs(w-(p+t)%(w*2));
		y = h - Math.abs(h-(q+t)%(h*2));
		System.out.println(x+" "+y);
	}
}