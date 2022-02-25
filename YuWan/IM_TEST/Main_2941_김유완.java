package study_0225;

import java.util.Scanner;

public class Main_2941_김유완 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int count = 0;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c == 'c') { // =,-가 붙어있어야함
				if((i+1<str.length() && str.charAt(i+1)=='=') ||
					(i+1<str.length() && str.charAt(i+1)=='-')) {
					i++; // 두개세트니까 넘기기
				}
			}
			else if(c == 'd') {
				if(i+2<str.length() && str.charAt(i+1)=='z' && str.charAt(i+2)=='=') {
					i += 2; // 3개가 세트
				}
				else if (i+1<str.length() && str.charAt(i+1)=='-') i++;
			}
			else if(c == 'l') { // j가 붙어있어야함
				if(i+1<str.length() && str.charAt(i+1)=='j') i++;
			}
			else if(c == 'n') { // j가 붙어있어야함
				if(i+1<str.length() && str.charAt(i+1)=='j')  i++;
			}
			else if(c == 's') { // =가 붙어있어야함
				if(i+1<str.length() && str.charAt(i+1)=='=') i++;
			}
			else if(c == 'z') {// =가 붙어있어야함
				if(i+1<str.length() && str.charAt(i+1)=='=') i++; // 두개세트니까 넘기기
			}
			count++;

		}
		System.out.println(count);
		sc.close();
	}
}
//public class Main_2941_김유완 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		String st[] =  {"c=","c-","dz=","d-","lj","nj","s=","z="};
//		for (int i = 0; i < st.length; i++) {
//			if(str.contains(st[i])) str = str.replace(st[i], ".");
//		}
//		System.out.println(str.length());
//	}
//
//}