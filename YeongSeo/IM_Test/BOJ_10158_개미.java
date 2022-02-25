package Etc;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/10158
 * 걸린 시간 : 90분
 * 리뷰 : 처음에는 경계면에 부딪칠 때마다 방향을 바꿔주는 공식을 적용해가면서
 * t시간 만큼 한칸씩 이동해가면서 최종 좌표를 구해주었다.
 * 하지만 입력 조건의 t가 1 ≤ t ≤ 200,000,000 이고 시간제한은 0.15초 이므로 시간초과가 무조건 발생했다.
 * 즉, O(1)로 풀기위한 산술적 규칙을 찾아내는 것이 중요한 문제였다.
*/
public class BOJ_10158_개미 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(); // 가로 길이
		int h = sc.nextInt(); // 세로 길이
		int p = sc.nextInt(); // 초기 x 위치
		int q = sc.nextInt(); // 초기 y 위치
		int t = sc.nextInt(); // 개미가 움직일 시간
		
		// x와 y 좌표는 t시간 동안 항상 1이 증가 또는 감소함
		// x 좌표가 제자리에 돌아오는 왕복주기는 2*w, y 좌표 또한 마찬가지로 2*h
		// 처음 시작 좌표에 t를 더한 값(p+t)을 왕복주기로 나눈 나머지는 구하고자 하는 현재 좌표
		// but, 그 값이 격자 공간의 경계를 벗어났으면 방향이 바뀌었다는 뜻이므로 왕복주기에서 그 값을 빼준다.
		int x = (p+t)%(2*w);
		if(x>w) x = 2*w-x;
		
		int y = (q+t)%(2*h);
		if(y>h) y = 2*h-y;
		
		System.out.println(x+" "+y); // 결과 출력
	}

}
