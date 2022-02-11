//�κ����� 17��

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_13305_���ؿ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());//������ ����
		long[] price = new long[N];	//�� ������ �����Һ� ���ʹ� ����
		long[] dist = new long[N-1];	//�ش� �ε��� ����~ ���� ���ñ����� �Ÿ�
		boolean[] expensive = new boolean[N-1];	//�ش� �ε��� ������ �� ������ �����Ұ� ������ true
		long cost = 0;	//����� �ּҺ��. 
		long rest_dist = 0;		//������ Ȥ�� ���� ������ �����ұ��� ���� �Ÿ�
		
		//=========���ݰ� �Ÿ� �Է� �ޱ�=====================
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N-1;i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		//======������ �����ҿ� ù��° �����Ҹ� �����ϰ� Ž��==========================
		for(int i = N-2;i>0;i--) {	
			long cur_price = price[i];	//���� ������ ����
			boolean fill = false;
			rest_dist += dist[i];		//������ Ȥ�� ���� ������ �����ұ��� ���� �Ÿ�
			
			if(!expensive[i]) {
				for(int j = i-1;j>=0;j--) {
					long ex_price = price[i-1];	//���� ������ ����
					if(cur_price < ex_price) {
						expensive[j] = true;
						fill = true;
					}
					else {
						break;
					}
				}
				
				if(fill) {		//���� ������ ���� ���� �����Ұ� �� ��쿡�� ����
					cost += rest_dist * cur_price;	//(���� �Ÿ�*�����Ұ���) ��ŭ ����
					rest_dist = 0; 	//���⼭ ���������Ƿ� ���� �Ÿ� �ʱ�ȭ
				}
			}
		}
		
		//======ù��° �����ҿ��� �����ϱ�=============
		rest_dist += dist[0];		//������ Ȥ�� ���� ������ �����ұ��� ���� �Ÿ�
		cost += rest_dist * price[0]; //�����Ÿ� ��ŭ ����
		
		System.out.println(cost);
	}
}
