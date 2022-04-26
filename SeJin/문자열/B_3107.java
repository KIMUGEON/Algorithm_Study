import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_3107 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(":"); //콜론 기준으로 구분해 문자열 값 받아오기
		
		for(int i=0;i<input.length;i++)
		{
			if(input[i].length()==0)//::들어올 떄
			{
				if(i==0) //처음으로 들어오면 가장 앞에 0000 채워주기
					input[0]="0000";
				else //아닐시 그자리에 -1 넣기
					input[i]="-1";
			}
			else if(input[i].length()<4) //숫자가 들어오면 4자리 될떄까지 앞에 0 채워주기
			{
				while(input[i].length()!=4)
					input[i]="0"+input[i];
			}
		}
		
		
		int putZeros=8-input.length+1; //-1로 표시한 부분까지 0을 채워줘야 하므로 +1
		
		String result=""; //결과값 저장용
		int idx=0; // 결과값 8개 공간에 몇개 들어갔는지 체크용
		for(int i=0;i<input.length;i++)
		{
			if(input[i].equals("-1")) //-1이 나오면 해당 자리에 putZeros개수만큼 0000 채워줘야함
				for(int j=0;j<putZeros;j++)
				{
					result+="0000:"; //0000채워주기
					idx++;
				}
			else //숫자일때는 앞에서 채워놓은 4자리 수 각각 넣어주기
			{
				result+=input[i];
				if(idx!=7) //마지막엔 :들어가면 안되므로 끊어주기
					result+=":";
				idx++;
			}	
		}
		while(idx<8) //마지막에 ::이 붙으면 이 빈칸을 체크하지 않으므로 idx개수로 판단.
		{
			if(idx==7)
				result+="0000";
			else
				result+="0000:";
			idx++;
		}
		
		System.out.println(result);
	}

}
