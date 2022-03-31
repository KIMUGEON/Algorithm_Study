package _0315_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main_16637_김준우 {
	static int N;
	static LinkedList<Integer> num ;
	static LinkedList<Character> sym;

	public static void calc(int start, int end) {
		LinkedList<Integer> n =  (LinkedList<Integer>) num.clone();
		LinkedList<Character> s =  (LinkedList<Character>) sym.clone();
		
		int i = 0; int j = 0;
		while(j<s.size()) {
			if(s.get(j) == '*') {
				int a = n.remove(i);
				int b = n.remove(i);
				n.add(i, a*b);
				s.remove(j);
			}
			else {
				i++; j++;
			}
		}
		
		i = 0; j = 0;
		while(j<s.size()) {
			if(s.get(j) == '+') {
				int a = n.remove(i);
				int b = n.remove(i);
				n.add(i, a+b);
				s.remove(j);
			}
			if(s.get(j) == '-') {
				int a = n.remove(i);
				int b = n.remove(i);
				n.add(i, a-b);
				s.remove(j);
			}
			else {
				i++; j++;
			}
		}

		//System.out.println(n.toString());
		//System.out.println(s.toString());
		
		System.out.println(n.pop());
		
	}
	/*
	public static void calc() {
		LinkedList<Integer> n =  (LinkedList<Integer>) num.clone();
		LinkedList<Character> s =  (LinkedList<Character>) sym.clone();
		
		int i = 0; int j = 0;
		while(j<s.size()) {
			if(s.get(j) == '*') {
				int a = n.remove(i);
				int b = n.remove(i);
				n.add(i, a*b);
				s.remove(j);
			}
			else {
				i++; j++;
			}
		}
		
		i = 0; j = 0;
		while(j<s.size()) {
			if(s.get(j) == '+') {
				int a = n.remove(i);
				int b = n.remove(i);
				n.add(i, a+b);
				s.remove(j);
			}
			if(s.get(j) == '-') {
				int a = n.remove(i);
				int b = n.remove(i);
				n.add(i, a-b);
				s.remove(j);
			}
			else {
				i++; j++;
			}
		}

		//System.out.println(n.toString());
		//System.out.println(s.toString());
		
		System.out.println(n.pop());
		
	}*/
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		num = new LinkedList<>();
		sym = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			char temp = str.charAt(i);
			if (temp >= '0' && temp <= '9' ) {
				num.add(temp-'0'); 
			}
			else {
				sym.add(temp);
			}
		}
		
		System.out.println(num.toString());
		System.out.println(sym.toString());
		
		//calc();
		
		for(int i = 0; i<num.size()-1;i++) {
			for(int j = i+1; j<num.size(); j++) {
				System.out.println(i + " " + j);
				calc(i,j);
			}
		}
		
	}

}
