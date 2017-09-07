import java.util.*;
/**
 *	문자열의 끝부터 오름차순인지 검사를 한다. 문자열 전체가 오름차순이라면 바꿀 것이 없으므로 no answer를 출력한다.
 * 오름차순을 검사하며 큐에 char를 집어 넣는다. 오름차순이 아닌경우가 나올 경우 그 index를 저장한다.
 * 저장된 index가 가리키는 값보다 큰값이 들어오고 그 이후에 오름차순으로 문자열을 재배치 해야한다.
 * (문자열 끝부터 오름차순을 검사하며 큐에 담았기 때문에 큐에서 뺀 값은 오름차순 정렬이 되어있다.)
 * 큐에서 char를 하나씩 빼며 문자열을 만들다가 처음 index가 가리키는 값보다 큰값이 나오게 되면 그 값을 문자열의 맨처음에 넣고,
 * index가 가리켰던 값을 그 이후로 추가한다.
 * 큐에있는 나머지 char를 차례대로 빼가며 문자열을 완성한다.
 * index 이전의 기존 문자열과 새로 만든 문자열을 합친 것이 정답이 된다.
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
