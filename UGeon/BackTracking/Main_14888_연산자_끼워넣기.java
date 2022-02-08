import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.OperatingSystemMXBean;
import java.util.StringTokenizer;

public class Main_14888_연산자_끼워넣기 {

	static int N;
	static int Max;
	static int Min;
	static int[] number;
	static int[] operator;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		number = new int[N];
		operator = new int[4];
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int n = 0; n < N; n++) {
			number[n] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());

		for (int n = 0; n < 4; n++) {
			operator[n] = Integer.parseInt(st.nextToken());
		}
		Max=Integer.MIN_VALUE;
		Min=Integer.MAX_VALUE;
		cal(number[0],1);
		
		System.out.println(Max);
		System.out.println(Min);

	}

	public static void cal(int num, int idx ) {
		
		if(idx==N) {
			Max = Math.max(Max, num);
			Min = Math.min(Min, num);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(operator[i]>0) {
				
				operator[i]--;
				
				
				if(i==0) {
					cal(num + number[idx], idx+1);
				}
				else if(i==1)
			    {
					cal(num - number[idx], idx+1);
		        }
				else if(i==2)
		        {
					cal(num * number[idx], idx+1);
		        }
				else if(i==3)
		        {
					cal(num / number[idx], idx+1);
		        }

		        operator[i]++;
				
			}
		}
		
	}

}
