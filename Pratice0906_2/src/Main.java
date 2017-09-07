import java.util.*;
/**
 *	���ڿ��� ������ ������������ �˻縦 �Ѵ�. ���ڿ� ��ü�� ���������̶�� �ٲ� ���� �����Ƿ� no answer�� ����Ѵ�.
 * ���������� �˻��ϸ� ť�� char�� ���� �ִ´�. ���������� �ƴѰ�찡 ���� ��� �� index�� �����Ѵ�.
 * ����� index�� ����Ű�� ������ ū���� ������ �� ���Ŀ� ������������ ���ڿ��� ���ġ �ؾ��Ѵ�.
 * (���ڿ� ������ ���������� �˻��ϸ� ť�� ��ұ� ������ ť���� �� ���� �������� ������ �Ǿ��ִ�.)
 * ť���� char�� �ϳ��� ���� ���ڿ��� ����ٰ� ó�� index�� ����Ű�� ������ ū���� ������ �Ǹ� �� ���� ���ڿ��� ��ó���� �ְ�,
 * index�� �����״� ���� �� ���ķ� �߰��Ѵ�.
 * ť���ִ� ������ char�� ���ʴ�� ������ ���ڿ��� �ϼ��Ѵ�.
 * index ������ ���� ���ڿ��� ���� ���� ���ڿ��� ��ģ ���� ������ �ȴ�.
 *
 */

public class Main {
	public static final String[] output = {"zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgwm",
			"no answer",
			"ocsmerkgidvddsazqxjbqlrrxcotrnfvtnlutlfcafdlwiismslaytqdbvlmcpapfbmzxmftrkkqvkpflxpezzapllerxyzlfc",
			"biehzcmjckznhwrfgglverxsjepquxz",
			"rebjvsszebhehuojrkkhszxltyqfdvayusylgmgkdivzlpmmtvbsavxvydldmyms",
			"unpzhmbgrsr",
			"jprfovzkdlmdcesdcpdchcwoedjchcovklhrhlzfeeptoewcqxgp",
			"ywsfmynmiylcjgrfrrmtyeeykffzkuphpajndwxjtjabey",
			"dkuashjzsqd",
			"gwakhcpkolybihkmxyecrdhsvycjrljajlmlqgpcnmvvkjlkvdowzdfkhi",
			"nebsajjbbuifimjpdcqfygeitife",
			"qetpicxagjkydehfnvfxrtigljlheulcsfidjjozbsnomygqbcmpffwswptbgkzrbgqwnczrcfynjmhebfbgseuhckbtuynvob",
			"xuqfobndhsnsztifmqpnencxkllnpmbfqihtgdgxjhsvitlgtodhcyfbd",
			"xqdwkjpkmrvkfnztozzlqtuxzxyxwwfo",
			"yewluyxiwiprnajrtkeilolkmqidazhira"
			, "abcfabcdefg"};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int size = str.length() -1;
		String result = null;
		Queue<Character> q = new LinkedList<Character>();
		
		int index = size;	
		for(int i =  size; i > 0 ; i--){
			q.add(str.charAt(i));
			if(str.charAt(i) > str.charAt(i-1)){		
				index = i - 1;
				break;
			}
		}

		
		String str2 = "";
		
		if(index == size){
			result = "no answer";
		}
		else{
			char compareChar = str.charAt(index);
			while(!q.isEmpty()){
				char temp = (char)q.poll();
				if(compareChar >= temp){
					str2 = str2 + temp;
				}
				else {
					str2 = temp + "" + str2 + compareChar;
					compareChar = 'z' + 1;
				}
			}
			result = str.substring(0, index) + str2;
		}
		
		
		for(int i = 0; i < 16 ; i++){
			if(output[i].equals(result)){
				System.out.println("true");
			}
		}
	}
}
