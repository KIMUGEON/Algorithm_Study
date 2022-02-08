import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14888_김준우 {
	static int N, len;
	static int cn, clen;
	static int[] num;
	static int[] calc, calcs;
	static boolean[] isSelected_c;
	static ArrayList<Integer[]> calclist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		
		//숫자 입력
		num = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i =0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		//연산자 배열 입력
		int[] calc_in = new int[4];
		st = new StringTokenizer(br.readLine()," ");
		for(int i =0;i<4;i++) {
			calc_in[i] = Integer.parseInt(st.nextToken());
		}
		
		len = calc_in[0]+calc_in[1]+calc_in[2]+calc_in[3]+1;
		cn = len-1; clen = len-1;
		calcs = new int[clen];
		calc = new int[clen];
		isSelected_c = new boolean[cn];
		calclist = new ArrayList<Integer[]>();
		
		for(int j = 0; j<calc_in[0]; j++) {calc[j] = 0;}
		for(int j = 0; j<calc_in[1]; j++) { calc[j+calc_in[0]] = 1;}
		for(int j = 0; j<calc_in[2]; j++) { calc[j+calc_in[0]+calc_in[1]] = 2;}
		for(int j = 0; j<calc_in[3]; j++) { calc[j+calc_in[0]+calc_in[1]+calc_in[2]] = 3;}
		
		solve();
		
	}
	
	public static void permutation_c(int cnt) {
		if(cnt == clen) {
			Integer[] arr = Arrays.stream(calcs).boxed().toArray(Integer[]::new);
			calclist.add(arr);
			return;
		}
		for(int i = 0;i<cn;i++) {
			if(isSelected_c[i]) continue;
			
			calcs[cnt] = calc[i];
			if(isSelected_c[i]) continue;
			
			calcs[cnt] = calc[i];
			isSelected_c[i] = true;
			
			permutation_c(cnt+1);
			isSelected_c[i] = false;
		}
	}
	
	public static void solve() {
		permutation_c(0);
		int max = -1000000000; int min = 1000000000;
		for(int j = 0; j<calclist.size();j++) {
			int[] arrn = num;
			Integer[] arrc = calclist.get(j);
			int temp = arrn[0];
			for(int n = 0;n<clen;n++) {
				switch(arrc[n]) {
				case 0:
					temp = temp+arrn[n+1];
					break;
				case 1:
					temp = temp-arrn[n+1];
					break;
				case 2:
					temp = temp*arrn[n+1];
					break;
				case 3:
					temp = temp/arrn[n+1];
					break;
				default:
					break;
				}
			}
			if(temp>max) max = temp;
			if(temp<min) min = temp;
		}
		System.out.println(max);System.out.println(min);
			
	}
}
