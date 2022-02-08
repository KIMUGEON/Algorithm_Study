import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_���ؿ� {
	static int N, M;
	static int[] numbers;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];	//������ ����
		isSelected = new boolean[N];	//���� �ߺ�üũ
		
		permutation(0);
	}
	
	public static void permutation(int cnt) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder(); 
			for(int i = 0;i<M;i++) {
				sb.append(numbers[i]);
				sb.append(" ");
			}
			System.out.println(sb);
			return;
		}
		for(int i = 0; i<N; i++) {
			if(isSelected[i]) continue;	//�ߺ��� ��� continue
			
			numbers[cnt] = i+1;
			isSelected[i] = true; 
			permutation(cnt+1);
			isSelected[i] = false; 
		}
	}

}
