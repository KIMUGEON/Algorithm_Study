import java.util.Scanner;

public class Main_2798_���ؿ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//N
		int max = sc.nextInt();//M
		int score = 0;//���� ���
		
		int[] arr = new int[n];//ī�尪
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Loop1 : for(int i =n-1;i>=0;i--) {
			for(int j = i-1;j>=0;j--) {
				for(int k =j-1;k>=0;k--) {
					//System.out.println(i+" "+j+" "+k);
					int temp = arr[i]+arr[j]+arr[k];
					if(temp>max)continue; //M�� ������ ��Ƽ��
					if(temp==max) { //M�̸� �ٷ� ����Ż��
						score = temp;
						break Loop1;
					}
					if(temp>score) //�ְ��� ���
						score = temp;
				}
			}
		}
		System.out.println(score);
	}
}
