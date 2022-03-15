import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17281_김세진 {
	static int inning, order[], hitter[][];
	static boolean player[];
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//총 진행하는 이닝 수
		inning = Integer.parseInt(br.readLine());
		//타자들 이닝 별 타구기록
		hitter = new int[inning][9];
		//타순
		order = new int[9];
		//타자들 쳤는지 확인하기위함
		player = new boolean[9];
		
		for(int i=0;i<inning;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<9;j++)
				hitter[i][j] = Integer.parseInt(st.nextToken());
		}
		
		order[3]=0;
		player[0]=true;
		permutation(0);
		System.out.println(result);
	}
	static void permutation(int cnt)
	{
		if(cnt==3)
		{
			permutation(cnt+1);
			return;
		}
		if(cnt==9)
		{
			play();
			return;
		}
		else
		{
			for(int i=0;i<9;i++)
			{
				if(player[i]==false)
				{
					player[i]=true;
					order[cnt]=i;
					permutation(cnt+1);
					player[i]=false;
				}
			}
		}
	}
	
	static void play()
	{
		//이번 경기에서 나오는 점수
		int score=0;
		int idx=0;
		for(int i=0;i<inning;i++)
		{
			//각 베이스 상태저장용
			int base[] = new int[3];
			int outCnt=0;
			while(true)
			{
				//순서대로 타자 나와서 치기
				idx%=9;
				int hit = hitter[i][order[idx]];
				switch(hit)
				{
					//아웃
					case 0: 
						outCnt++;
						break;
					//안타
					case 1:
						if(base[2]==1)
						{
							score++;
							base[2]=0;
						}
						if(base[1]==1)
						{
							base[2]=1;
							base[1]=0;
						}
						if(base[0]==1)
							base[1]=1;
						
						base[0]=1;
						break;
					//2루타
					case 2:
						if(base[2]==1)
						{
							score++;
							base[2]=0;
						}
						if(base[1]==1)
						{
							score++;
							base[1]=0;
						}
						if(base[0]==1)
						{
							base[2]=1;
							base[0]=0;
						}
						base[1]=1;
						break;
					//3루타
					case 3:
						if(base[2]==1)
							score++;
						if(base[1]==1)
						{
							score++;
							base[1]=0;
						}
						if(base[0]==1)
						{
							score++;
							base[0]=0;
						}
						base[2]=1;
						break;
					//홈런
					case 4:
						if(base[2]==1)
						{
							score++;
							base[2]=0;
						}
						if(base[1]==1)
						{
							score++;
							base[1]=0;
						}
						if(base[0]==1)
						{
							score++;
							base[0]=0;
						}
						score++;
						break;
				}
				idx++;
				if(outCnt==3)
					break;
				
			}
		}
		if(result < score)
			result=score;
	}
}
