
import java.util.*;
import java.io.*;
class Student{
	int nextIndex;		// ���� �ε���
	boolean isLoop;		// ��������
	boolean isCheck;	// �˻� �ߴ���
	
	public Student(int nextIndex, boolean isLoop){
		this.nextIndex = nextIndex;
		this.isLoop = isLoop;
		this.isCheck = false;
	}
}
public class Main {
	public static Student[] mStudent;
	public static boolean[] mVisited;
	//public static boolean[] mRootCheck;
	public static int mTotalStudent;
	public static int T;
	public static int mSum;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T ; t++){
			mTotalStudent = Integer.parseInt(br.readLine());
			
			mStudent = new Student[mTotalStudent + 1];
			mVisited = new boolean[mTotalStudent + 1];
			//mRootCheck = new boolean[mTotalStudent + 1];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i = 1; i < mTotalStudent + 1; i++){
				mStudent[i] = new Student(Integer.parseInt(st.nextToken()), false);
				//mRootCheck[i] = true;
			}
			
			for(int i = 1; i < mTotalStudent + 1; i++){
				//if(mRootCheck[i]){
					dfs(i);	
				//}
			}
			
			
			System.out.println(mTotalStudent - mSum);
			mSum = 0;
		}
	}
	public static void dfs(int index){
		if(mStudent[index].isLoop || mStudent[index].isCheck){	// �����̰ų� �˻�������
			return;
		}
		if(mVisited[index]){
			mSum++;
			mStudent[index].isLoop = true;
			dfs(mStudent[index].nextIndex);
			return;
		}
		else{	// �湮 ���� �������
			mVisited[index] = true;	//�湮
			dfs(mStudent[index].nextIndex);
			mStudent[index].isCheck = true;	// �˻� �� üŷ
		}
		
	}
}
