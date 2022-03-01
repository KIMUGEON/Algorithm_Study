package _0301_IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527_김준우 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 for(int t = 0;t<4;t++) {
			 StringTokenizer st = new StringTokenizer(br.readLine()," ");
			 
			 char result = 'a';
			 int[] x = new int[2];
			 int[] y = new int[2];
			 int[] x2 = new int[2];
			 int[] y2 = new int[2];
			 for (int i = 0; i < 2; i++) {
				 x[i] = Integer.parseInt(st.nextToken());
				 y[i] = Integer.parseInt(st.nextToken());
			 }
			 for (int i = 0; i < 2; i++) {
				 x2[i] = Integer.parseInt(st.nextToken());
				 y2[i] = Integer.parseInt(st.nextToken());
			 }
			 
			 if(x[0] > x2[0]) {//두번째 직사각형이 더 왼쪽인 경우
				 int right = x[1]+(x[0]-x2[0]);
				 int left = x[1]+(x[0]-x2[1]);
				 x2[0] = left;
				 x2[1] = right;
			 }
			 
			 if(y[0] > y2[0]) {//두번째 직사각형이 더 위쪽인 경우
				 int up = y[1]+(y[0]-y2[0]);
				 int bottom = y[1]+(y[0]-y2[1]);
				 y2[0] = bottom;
				 y2[1] = up;
			 }
			 
			 if(x2[0] <= x[0] && y2[0] <= y[0]) {
				 result = 'a';
			 }
			 else if(x2[0] <= x[0]) {
				 if(y2[0] == y[1]) {
					 result = 'b'; 
				 }
				 if(y2[0] > y[1]) {
					 result = 'd'; 
				 }
			 }
			 else if(y2[0] <= y[0]) {
				 if(x2[0] == x[1]) {
					 result = 'b'; 
				 }
				 if(x2[0] > x[1]) {
					 result = 'd'; 
				 }
			 }
			 else {
				 if(x[1] == x2[0] && y2[0]>= y[0] && y2[0] < y[1]) result = 'b';
				 if(y[1] == y2[0] && x2[0]>= x[0] && x2[0] < x[1]) result = 'b';
				 if(x[1] == x2[0] && y[1] == y2[0]) result = 'c';
				 if(x[1] < x2[0] || y[1] < y2[0]) result = 'd';
			 }
			 sb.append(result);
			 sb.append("\n");
		 }
		 System.out.println(sb);
		 
		 
	}

}
