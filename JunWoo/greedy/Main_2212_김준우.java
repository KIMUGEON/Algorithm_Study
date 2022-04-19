package _0415_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int coverage;	//수신가능영역
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		//센서의 좌표 값을 입력받은 뒤 정렬
		int[] sensor = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensor);
		
		//가장 좌측에 있는 값과 우측에 있는 값의 차이로 초기화
		coverage = sensor[sensor.length-1] - sensor[0];
		
		//각 센서간의 거리를 배열로 만든 뒤 오름차순 정렬
		int[] distance = new int[N-1];
		for(int i = 0; i<N-1; i++) {
			distance[i] = sensor[i+1] - sensor[i];
		}
		Arrays.sort(distance);
		
		//가장 거리가 먼 간격을 K-1개 뽑아서 coverage에서 빼준다.
		for(int i = 0; i<K-1; i++) {
			if(distance.length -1 -i >= 0) {
				coverage -= distance[distance.length - 1 - i];
			}
		}
		
		System.out.println(coverage);
		
		
	}

}
