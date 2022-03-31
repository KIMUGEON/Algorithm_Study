package _0301_IM대비;
/*
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Main_2477_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int width = 0 ; int height = 0;
		int plen = 0; int pdir = -100;
		int corner = 0;
		
		for(int i = 0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int len= Integer.parseInt(st.nextToken());
			if(dir<=2) {
				if(len>width) {
					width = len;
				}
			}
			else if(len>height) height = len;
			//북서 서남 남동 동북  24 32 13 41
			
			if(	(dir == 4 && pdir == 2) || (dir == 2 && pdir == 3) || (dir == 3 && pdir == 1) ||	(dir == 1 && pdir == 4)	) {
				corner = plen*len;
			}
			pdir = dir;
			plen = len;
		}
	
		int result = ((height*width)-corner)*N;
		System.out.println(result);
	}

}
