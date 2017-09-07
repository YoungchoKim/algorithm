import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char temp;
		int sum = 0;
		for(int i = 0; i < s.length(); i++){
			temp = s.charAt(i);
			if(temp > 'P'){
				temp--;
			}
			if(temp > 'W'){
				temp --;
			}
			sum += ((temp - 'A')/3 + 2 + 1);
		}
		System.out.println(sum);
	}
}
