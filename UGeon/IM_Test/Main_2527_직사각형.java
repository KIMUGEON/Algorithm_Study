import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());
			
			/*
			 *           x1,y2        x2,y2        x3,y4       x4,y4
			 *                                   
			 * 
			 *           x1,y1        x2,y1        x3,y3       x4,y3         
			 */
				
			if ((x1==x4 && y1==y4) || (x1==x4 && y2==y3) || (x2==x3 && y1==y4) || (x2==x3 && y2==y3)) {
				System.out.println("c");
			}
			else if (x1>x4 || x2<x3 || y1>y4 || y2<y3) {
				System.out.println("d");
			}
			else if(x1==x4 || x2==x3  || y1==y4 || y2==y3){
				System.out.println("b");
			}
			else {
				System.out.println("a");

			}
		}
	}
}