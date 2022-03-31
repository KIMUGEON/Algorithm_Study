package _0322_다이나믹프로그래밍;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11052_김준우 {
	public static class pack implements Comparable<pack>{
		int cost, n;
		double comp;
		
		public pack(int cost, int n) {
			this.cost = cost;
			this.n = n;
			comp = (double)cost/n*10000;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
		}

		public double getComp() {
			return comp;
		}

		public void setComp(double comp) {
			this.comp = comp;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("pack [cost=");
			builder.append(cost);
			builder.append(", n=");
			builder.append(n);
			builder.append(", comp=");
			builder.append(comp);
			builder.append("]");
			return builder.toString();
		}
		
		@Override
		public int compareTo(pack p) {
			return (int)(p.getComp() - this.getComp());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<pack> Q = new PriorityQueue<>();
		
		for(int i = 1; i<=n; i++) {
			int cost = sc.nextInt();
			Q.add(new pack(cost,i));
		}
		
		System.out.println(Q.toString());
		//pack sdf = new pack(1,2);
		//System.out.println(sdf.getCost());
		
		int a = 1;
		int b= 2;
		double c = (double)(a)/(double)(b);
		//System.out.println(c);
	}

}
