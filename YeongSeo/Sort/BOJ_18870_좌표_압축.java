package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/18870
 * 걸린 시간 : 60분 이상
 * 리뷰 : 처음에는 배열을 정렬하여 stream으로 정렬한 배열의 중복을 없앤 뒤 indexof로
 * index를 반환하는 방법과, 2중 for문을 이용하여 정렬한 배열을 전부 탐색하여 rank를 구하는 방법,
 * 2가지 방법 모두 써보았지만 시간초과만 나왔다..
 * 일단 BufferedReader와 StringBuilder가 필수라는 생각이 들어서 이것도 적용해보았지만 시간초과..
 * 중복을 없애는 과정과 2중 for문이 시간복잡도가 크기 때문에 안되는게 확실한 것 같다.
 * 결국 답지를 봐서 Map을 이용하는 힌트를 얻고 풀었다.
 * Map을 사용하는것이 key값을 이용하여 중복을 없애는데 가장 탁월한 방법인 것 같다.
*/
public class BOJ_18870_좌표_압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
		int N = new Integer(br.readLine());
        int[] arr = new int[N]; // 입력 받은 원본 배열
        int[] sort = new int[N]; // 원본 배열을 오름차순 정렬한 배열
		
        Map<Integer, Integer> hMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sort[i] = arr[i];
        }
		
        Arrays.sort(sort); // 오름차순 정렬
        
        int rank = 0; // 값의 크기 순위
        
        // 정렬된 배열 탐색
        for(int i=0; i<N; i++) {
        	// map에 중복된 key가 있으면 continue;
        	if(hMap.containsKey(sort[i])) continue;
        	// 없으면 크기 순위(rank)와 함께 map에 저장
        	hMap.put(sort[i], rank++);
        }
        
        //입력된 배열 순서대로 크기 순위 rank 출력
        for(int i=0; i<N; i++) {
        	sb.append(hMap.get(arr[i])).append(' ');
        }
        
		System.out.println(sb);
	}
}
