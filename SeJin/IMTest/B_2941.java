import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_2941 {

	public static void main(String[] args) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("c=");
		list.add("c-");
		list.add("dz=");
		list.add("d-");
		list.add("lj");
		list.add("nj");
		list.add("s=");
		list.add("z=");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int sum=1;
		
		for(int i=1;i<input.length();i++)
		{
			if(input.charAt(i) == 'j')
			{
				if(input.charAt(i-1) =='l' || input.charAt(i-1)=='n')
				{
					continue;
				}
			}
			if(input.charAt(i) =='-')
			{
				if(input.charAt(i-1) =='c' || input.charAt(i-1)=='d')
				{
					continue;
				}
			}
			else if(input.charAt(i)=='=')
			{
				if(i>1 && input.charAt(i-1)=='z')
				{
					if(input.charAt(i-2)=='d')
					{
						sum--;
						continue;
					}
				}
				if(input.charAt(i-1)=='c' || input.charAt(i-1)=='s' || input.charAt(i-1)=='z')
				{
					continue;
				}
			}
			sum++;

		}
		System.out.println(sum);
	}

}
