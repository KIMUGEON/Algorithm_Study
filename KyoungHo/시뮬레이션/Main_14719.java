import java.util.Scanner;
/*
  [입력]
첫 번째 줄에는 2차원 세계의 세로 길이 H과 2차원 세계의 가로 길이 W가 주어진다. (1 ≤ H, W ≤ 500)
두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개 주어진다.
따라서 블록 내부의 빈 공간이 생길 수 없다. 또 2차원 세계의 바닥은 항상 막혀있다고 가정하여도 좋다.

  [출력]
2차원 세계에서는 한 칸의 용량은 1이다. 고이는 빗물의 총량을 출력하여라.
빗물이 전혀 고이지 않을 경우 0을 출력하여라.
 */
public class Main_14719 { //빗물
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		int 빗물[] = new int[W];
		int 블록[] = new int[W];
		int 최대높이  = 0;
		int cnt = 0;
		
		for(int i=0; i<W; i++) { //왼쪽부터 블록 입력, 최대높이 저장해주기, 일단 빗물 = 최대높이로 설정
			블록[i] = sc.nextInt();
			최대높이 = Math.max(최대높이, 블록[i]);
			빗물[i] = 최대높이;
		}
		
		최대높이 = 0;
		for(int i=W-1; i>=0; i--) { //오른쪽부터 최대높이와 빗물높이(빗물이 최대높이보다 크면 최대높이로 줄여주기) 저장 
			최대높이 = Math.max(최대높이, 블록[i]);
			빗물[i] = Math.min(최대높이, 빗물[i]);
			cnt += 빗물[i] - 블록[i];
		}
		System.out.println(cnt);
	}

}
