import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12927_김세진 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char temp[] = input.toCharArray();
		int cnt=0;
		for(int i=0;i<temp.length;i++)
		{
			if(check(temp))
			{
				System.out.println(cnt);
				return;
			}
			if(temp[i] == 'Y')
			{
				cnt++;
				for(int j=i;j<temp.length;j+=(i+1))
				{
					if(temp[j]=='Y')
						temp[j]='N';
					else
						temp[j]='Y';
				}
			}
		}
		if(check(temp))
		{
			System.out.println(cnt);
			return;
		}
		System.out.println(-1);
	}
	
	static boolean check(char[] input)
	{
		boolean result=false;
		for(int i=0;i<input.length;i++)
		{
			if(input[i]=='Y')
				return false;
		}
		return true;
	}
}
