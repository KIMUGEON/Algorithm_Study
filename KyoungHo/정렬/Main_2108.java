package case_12.Silver4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_2108 { //통계학

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a[] = new int[N];
		ArrayList<Integer> b = new ArrayList<>();	//빈도수 비교
		double sum = 0;
		double avg =0;
		int temp = 0; //빈도
		
		int plus[] = new int[4001];	//양수 빈도
		int minus[] = new int[4001];//음수 빈도
		
		for(int i = 0; i<N; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
			if(a[i]>=0) {
				plus[a[i]]++; //양수 빈도
			}else {
				minus[a[i]*-1]++; //음수 빈도
			}
		}

		Arrays.sort(a);
		avg = sum/N;
		System.out.printf("%.0f%n",avg);
		System.out.println(a[N/2]);
		
		for(int i = 0; i<plus.length; i++) {
			if(plus[i] == 0 && minus[i] ==0) { //빈도 0일땐 건너뛰기
				continue;
			}				
			if(temp <= plus[i]) {
				if(temp < plus[i]) {
					b.clear();	//이전 빈도수보다 크면 초기화
				}
				temp = plus[i];
				b.add(i);
			}
			if(temp <= minus[i]) {
				if(temp < minus[i]) {
					b.clear();
				}
				temp = minus[i];
				b.add(i*-1);
			}
		}
		
		if(b.size() == 1) {	//최빈값 1개일 경우
			System.out.println(b.get(0));
		} else if(b.size() == N) { //최빈값이 입력한 수(N)와 같은 경우 
		System.out.println(a[1]); 
		} else {
			Collections.sort(b);
			System.out.println(b.get(1)); //여러개 일 경우 두번째로 작은 값
		}
		
		if(N==1) {
			System.out.println(0);
			return;
		}
		System.out.println(a[N-1] - a[0]);
	}

}
