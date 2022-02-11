import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main_1931_김세진 {
	static public class time
	{
		int start;
		int end;
		public time(){	}
		public time(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<time> input = new ArrayList<time>();
		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			input.add(new time(start,end));
		}
		Collections.sort(input, new Comparator<time>() {
			@Override
			public int compare(time o1, time o2) {
				// TODO Auto-generated method stub
					if(o1.end==o2.end)
						return o1.start-o2.start;
					return o1.end - o2.end;
			}
		});
		
		int cnt=0;
		int end_time=0;
		for(int i=0;i<input.size();i++)
		{
			if(input.get(i).end >= end_time)
			{
				if(input.get(i).start >= end_time)
				{
					cnt++;
					end_time = input.get(i).end;
				}
			}
		}
		System.out.println(cnt);
	}
}
