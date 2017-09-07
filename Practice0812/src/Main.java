import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());

		while (t-- > 0) {
			String str = sc.nextLine();

			Stack<Character> stack1 = new Stack<Character>();
			Stack<Character> stack2 = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				char operation = str.charAt(i);
				if ((operation >= 'a' && operation <= 'z') || (operation >= 'A' && operation <= 'Z')
						|| operation >= '0' && operation <= '9') {
					stack1.add(operation);

				} else if (operation == '<' || operation == '>') {
					if (operation == '<' && !stack1.isEmpty()) {
						stack2.add(stack1.pop());
						
					} else if (operation == '>' && !stack2.isEmpty()) {
						stack1.add(stack2.pop());
					}
				} else if (!stack1.empty() && operation == '-') {
					stack1.pop();
				}
			}
			while(!stack1.isEmpty()){
				stack2.add(stack1.pop());
			}
			
			while(!stack2.isEmpty()){
				System.out.print(stack2.pop());
			}System.out.println();
		}

	}
}