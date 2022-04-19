package _0415_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1543_김준우 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] doc = br.readLine().toCharArray();
		char[] word = br.readLine().toCharArray();
		
		int score = 0;
		
		for (int i = 0; i < doc.length; i++) {
			if(doc[i] == word[0]) {
				for(int j = 0; j<word.length; j++) {
					if(i+j > doc.length-1) break;
					if(doc[i+j] != word[j]) {
						break;
					}
					
					if(j == word.length-1) {
						i += word.length-1;
						score++;
					}
				}
			}
		}
		
		System.out.println(score);
	}
}
