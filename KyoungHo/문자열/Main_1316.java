import java.util.Arrays;
import java.util.Scanner;

public class Main_1316 { //그룹 단어 체커

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean used[] = new boolean[26];
		int cnt=N;
		
		for(int i=0; i<N; i++) {
			String A = sc.next();
			Arrays.fill(used, false);
			
			for(int j=0; j<A.length(); j++) {
				if(used[A.charAt(j)-'a']==false) {
					used[A.charAt(j)-'a'] = true;
				}else if(A.charAt(j) != A.charAt(j-1)) {
					cnt--;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
