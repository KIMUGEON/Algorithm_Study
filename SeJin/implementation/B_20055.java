import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20055 {
	static class location
	{
		int durability; //내구도
		boolean exist; //로봇 존재하는지
		public location(int durability, boolean exist) {
			super();
			this.durability = durability;
			this.exist = exist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); //벨트 길이
		int K = Integer.parseInt(st.nextToken()); //내구도 개수 체크
		
		int in=0, out=N-1; //올라오는자리, 내려가는 자리
		location belt[] = new location[N*2];
		st = new StringTokenizer(br.readLine()," ");
		
		//내구도와 해당 칸에 로봇 존재하는지 여부
		for(int i=0;i<2*N;i++)
			belt[i]=new location(Integer.parseInt(st.nextToken()), false);
		
		int result=0; //최종 단계 수
		while(true)
		{
			result++; // 단계 수 증가
			
			//1. 한칸 씩 회전시키기
			location temp = belt[2*N-1]; //올라와야하는 자리, 즉 가장 끝
			for(int i=N*2-1;i>0;i--)
				belt[i]=belt[i-1]; //가장 앞 칸을 제외하고 나머지 칸 한칸씩 땡겨주기
			
			belt[0] = temp; // 올라오는 자리에 가장 끝에 있던 것 올려주기
			
			belt[out].exist=false; // 내려가는 자리에 있는거 내리기 떨어져야 내리는게 아니라 내리는 자리에 와야 내림...
			
			//2. 로봇 한칸씩 전진
			for(int i=N-1;i>=0;i--)
			{
				if(belt[i].exist==true && belt[i+1].durability > 0 && belt[i+1].exist==false) //해당 칸에 로봇이 존재하며 해당 앞칸으로 이동하려할 때 내구도가 1 이상이고 로봇이 없을 때
				{
					belt[i].exist=false;
					belt[i+1].durability--;
					belt[i+1].exist=true;
				}
				
				if(i+1==out)
					belt[i+1].exist=false;
			}
			
			//3. 로봇올리기
			if(belt[in].durability>0) //내구도 1 이상일 때
			{
				belt[in].durability--;
				belt[in].exist=true;
			}
			int durability_cnt = 0; //내구도 0이 된 칸 개수 체크
			
			for(int i=0;i<2*N;i++) 
				if(belt[i].durability == 0)
				{
					durability_cnt++; 
					if(durability_cnt == K)
					{
						System.out.println(result);
						System.exit(0);
					}
				}	
		}
		
	}

}
