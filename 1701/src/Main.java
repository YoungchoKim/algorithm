import java.io.*;
import java.util.*;
public class Main {
	public static String S;
	public static char[] suffixArray;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		String[] array = new String[S.length()];
		
		for(int i = 0; i < S.length(); i++){
			array[i] = S.substring(i);
		}
		
	}
}
