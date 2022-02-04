import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class B_1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<N;i++)
		{
			String temp = br.readLine();
			set.add(temp);
		}
		ArrayList<String> input = new ArrayList(set);
		Collections.sort(input);
		Collections.sort(input,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) { 	
					return o1.length() - o2.length();
			}
		});
		
		for(String s : input)
		{
			System.out.println(s);
		}
	}

}
