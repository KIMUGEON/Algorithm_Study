import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전광판 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numbers[][] = new int[10][7];
		//0~9까지 해당칸에 맞게 설정
		numbers[0] = new int[] {1,1,1,0,1,1,1};
		numbers[1] = new int[] {0,0,1,0,0,1,0};
		numbers[2] = new int[] {1,0,1,1,1,0,1};
		numbers[3] = new int[] {1,0,1,1,0,1,1};
		numbers[4] = new int[] {0,1,1,1,0,1,0};
		numbers[5] = new int[] {1,1,0,1,0,1,1};
		numbers[6] = new int[] {1,1,0,1,1,1,1};
		numbers[7] = new int[] {1,1,1,0,0,1,0};
		numbers[8] = new int[] {1,1,1,1,1,1,1};
		numbers[9] = new int[] {1,1,1,1,0,1,1};
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0;i<tc;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int before = Integer.parseInt(st.nextToken()); 
			int after = Integer.parseInt(st.nextToken());
			//before -> after
			int cnt=0;
			
			while(before!=0)
			{
				int Btemp = before%10; //1의자리 갖고오기
				if(after == 0) //after가 0이면 숫자에 맞는만큼 켜야함
				{
					for(int j=0;j<7;j++)
						if(numbers[Btemp][j]==1) //숫자 해당하는거 스위치 누르기
							cnt++;
				}
				else //0이 아니면
				{
					int Atemp = after%10; // 1의자리 가져오기
					for(int j=0;j<7;j++)
						if(numbers[Btemp][j]!=numbers[Atemp][j]) //Btemp, Atemp하고 각각 칸이 다를 시 스위치 누르기
							cnt++;
				}
				before/=10; //10으로나눠주기
				after/=10;
			}
			while(after!=0) //after가 더 자릿수가 클때 (1011 -> 10011)
			{
				int Atemp = after%10; //1의자리 가져와서
				for(int j=0;j<7;j++) //스위치 맞게 키기
					if(numbers[Atemp][j]==1)
						cnt++;
				after/=10; //10으로 나눠주기
			}
			System.out.println(cnt);
		}
	
		
	}

}
