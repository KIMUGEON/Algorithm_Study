import java.util.Scanner;

public class Main_1436_���ؿ� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = 0;//1�� ������ ����
		int i = 0;//N�� ������ �ݺ��� ����
		while(i < N) {
			//n++;
			int temp = n;
			int count = 0;//6�ǰ���
			
			while(temp>0) {
				if(temp%10 == 6)count++;else count=0;
				if(count==3)break;
				temp = temp/10;
			}
			if(count>=3) {
				i++;//6�ǰ����� 3 �̻��̸� i����
			}
			if(i == N)break;
			n++;
		}
		System.out.println(n);
		
	}

}
