import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_2108_±èÁØ¿ì {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		double avg = 0; int center; int mode = 0; int gap;
		ArrayList<Integer> freq = new ArrayList<Integer>(); int[] index = new int[N]; int max_freq = 0;
		
		for(int n = 0 ;n<N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
			avg += arr[n];
		}
		avg = avg/N;
		Arrays.sort(arr);
		center = arr[N/2];
		
		for(int i = 0; i<N;i++) {
			if(freq.contains(arr[i])) {
				freq.indexOf(arr[i]);
				index[freq.size()-1]++;
				if(max_freq < index[freq.size()-1]) {
					max_freq = index[freq.size()-1];
				}
			}else {
				freq.add(arr[i]);
				index[freq.size()-1]++;
			}
		}
		
		for(int i = 0; i<freq.size();i++) {
			if(index[i]>=max_freq) {
				if(mode == 0) {
					mode = freq.get(i);
				}
				else {
					mode = freq.get(i);
					break;
				}
			}
		}
		
		gap = arr[N-1]-arr[0];
		
		sb.append(Math.round(avg));sb.append("\n");
		sb.append(center);sb.append("\n");
		sb.append(mode);sb.append("\n");
		sb.append(gap);sb.append("\n");
		
		System.out.println(sb);
		
	}

}
