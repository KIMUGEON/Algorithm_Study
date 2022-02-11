import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_김준우 {
	static int N,K;	//동전 총 개수, 만들고자하는 가격
	static int min;	//필요한 동전 최소값
	static int[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());	
		K = Integer.parseInt(st.nextToken());	
		input = new int[N];
		min = 10000;
		
		for(int n = 0;n<N; n++) {
			input[n] = Integer.parseInt(br.readLine());			
		}
		
		int price = 0; int count = 0;
		loop1:
		while(price < K) {
			for(int i = N-1; i>=0;i--) {
				int newprice = price + input[i];
				if(newprice<K) {
					price = newprice;
					count++;
					//System.out.println(price);
					break;
				}
				else if(newprice == K){
					count++;
					break loop1;
				}
			}
		}
		System.out.println(count);
		
	}
}




/*
public class Main_11047_김준우 {
	static int N,K;	//동전 총 개수, 만들고자하는 가격
	static int min;	//필요한 동전 최소값
	static int[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());	
		K = Integer.parseInt(st.nextToken());	
		input = new int[N];
		min = 10000;
		
		for(int n = 0;n<N; n++) {
			input[n] = Integer.parseInt(br.readLine());			
		}
		//Arrays.sort(input);
		//System.out.println(Arrays.toString(input));
		combination(0,0);
		System.out.println(min);
		
	}
	
	public static void combination(int cnt, int price) {
		if(cnt >= min) {
			return;
		}
		if(price > K) {
			//System.out.println(price);
			return;
		}
		if(price == K) {
			if(cnt<min) {
				min = cnt;
				System.out.println(price+" "+cnt);
			}
			return;
		}
		
		for(int i = N-1; i>=0;i--) {
			int newprice = price + input[i];
			if(newprice <= K && cnt < min) {
				combination(cnt+1,price+input[i]);
			}
			//return;
		}
		return;
	}
}
*/