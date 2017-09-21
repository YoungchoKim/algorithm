import java.util.*;
public class Main1373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int size = s.length();
		
		String[] str = new String[size/30 + 1];
		String result = "";

		int i = size;
		int j = 0;
		
		while( i > 30){
			str[j++] = new String(s.substring(i - 30, i));	
			String temp = Integer.toOctalString(Integer.valueOf(str[j - 1], 2));
			while(temp.length() != 10){
				temp = "0" + temp;
			}
			result =  temp+ result;
			
			i -=30;
		}
		str[j++] = new String(s.substring(0, i));
		String temp = Integer.toOctalString(Integer.valueOf(str[j - 1], 2));
		result =  temp+ result;
		
		
		
		System.out.println(result);

		
		
	}

}
