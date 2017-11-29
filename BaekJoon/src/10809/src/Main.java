import java.io.*;
import java.util.Arrays;
public class Main {

	public static int[] arrays;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		arrays = new int[26];
		Arrays.fill(arrays, -1);
		for(int i = 0; i < s.length(); i++){
			if(arrays[s.charAt(i) - 'a'] == -1){
				arrays[s.charAt(i) - 'a'] =i;
			}
		}
		
		for(int i = 0; i < 26; i++){
			System.out.print(arrays[i] + " ");
		}
		
	}

}
