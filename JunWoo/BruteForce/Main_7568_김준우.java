import java.util.Scanner;

public class Main_7568_���ؿ� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] arr = new int[t][3];//�� ����� ������, Ű, ����� �����ϴ� �迭
		
		/*�迭�� �����Կ� Ű�� ����*/
		for(int i = 0; i<t ; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i= 0;i<t;i++) {
			for(int j = 0;j<t;j++) {//�񱳴���� �ڱ��� ��쵵 ���Եǳ� ����� ������Ű�� �����Ƿ� �׳� ����
				if(arr[i][0]<arr[j][0]) {
					if(arr[i][1]<arr[j][1]) {
						arr[i][2]++;//�񱳴���� �����Կ� Ű�� �ڱ⺸��  ū��� ����� ����
					}
				}
			}
			arr[i][2]++;
		}
		
		for(int i = 0;i<t;i++) {
			System.out.print(arr[i][2]+" ");
		}
		
		
	}

}