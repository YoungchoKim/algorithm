import java.io.*;
import java.util.*;
public class Main2675 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			
			String str = st.nextToken();
			for(int i = 0; i < str.length(); i++) {
				char a = str.charAt(i);
				for(int j = 0; j < n; j++) {
					sb.append(a);
				}
			}
			System.out.println(sb.toString());
			
		}
		
	}

}
