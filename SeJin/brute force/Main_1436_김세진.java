

import java.util.Scanner;

public class B_1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long L = 666;
		int cnt=1;
		while(cnt != N)
		{
			L++;
			if(Long.toString(L).contains("666"))
			{
				cnt++;
			}
		}
		System.out.println(L);
	}
}
