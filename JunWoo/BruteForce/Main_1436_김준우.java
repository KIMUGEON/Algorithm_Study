import java.util.Scanner;

public class Main_1436_김준우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = 0;//1씩 증가할 숫자
		int i = 0;//N과 같으면 반복문 종료
		while(i < N) {
			//n++;
			int temp = n;
			int count = 0;//6의갯수
			
			while(temp>0) {
				if(temp%10 == 6)count++;else count=0;
				if(count==3)break;
				temp = temp/10;
			}
			if(count>=3) {
				i++;//6의갯수가 3 이상이면 i증가
			}
			if(i == N)break;
			n++;
		}
		System.out.println(n);
		
	}

}
