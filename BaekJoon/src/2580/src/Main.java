
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1234567891";
		int a = 3;
		if(s.charAt(9) == '1'){

			s= s.replace((char)('0' + a), '0');
			System.out.println(s);	
		}
	
	}

}
