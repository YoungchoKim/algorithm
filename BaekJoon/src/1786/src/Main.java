import java.util.*;
import java.io.*;


public class Main {
	public static String T, P;
	public static int Pi[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		Pi = new int[P.length()];
		
		Queue<Integer> q = new LinkedList<Integer>();
		int j = 0;
		Pi[j] = 0;
		for(int i = 1 ; i< P.length(); i++){
			while(j > 0 && P.charAt(i) != P.charAt(j)){
				j = Pi[j-1];
			}
			if(P.charAt(i) == P.charAt(j)){
				Pi[i] = ++j;
			}
		}
		
		j = 0;
		for(int i = 0; i < T.length(); i++){
			while(j > 0 && T.charAt(i) != P.charAt(j)){
				j = Pi[j -1];
			}
			if(T.charAt(i) == P.charAt(j)){
				if(j == P.length()-1){
					q.add(i - j + 1);
					j =Pi[j];
				}
				else{
					j++;
				}
			}
		}
		System.out.println(q.size());
		while(!q.isEmpty()){
			System.out.print(q.poll() + " ");
		}

	}

}
