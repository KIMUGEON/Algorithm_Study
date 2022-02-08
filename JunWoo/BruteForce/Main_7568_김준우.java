import java.util.Scanner;

public class Main_7568_김준우 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] arr = new int[t][3];//각 사람의 몸무게, 키, 등수를 저장하는 배열
		
		/*배열에 몸무게와 키를 저장*/
		for(int i = 0; i<t ; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i= 0;i<t;i++) {
			for(int j = 0;j<t;j++) {//비교대상이 자기인 경우도 포함되나 등수를 증가시키지 않으므로 그냥 썼음
				if(arr[i][0]<arr[j][0]) {
					if(arr[i][1]<arr[j][1]) {
						arr[i][2]++;//비교대상의 몸무게와 키가 자기보다  큰경우 등수를 증가
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