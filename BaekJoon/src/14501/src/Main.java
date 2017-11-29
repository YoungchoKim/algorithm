import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author Cho
 * 
 *  �������� ���ϰ� �ִ� �����̴� ��縦 �Ϸ��� �Ѵ�.
	���ú��� N+1��° �Ǵ³� ��縦 �ϱ� ���ؼ�, ���� N�� ���� �ִ��� ���� ����� �Ϸ��� �Ѵ�.
	�����̴� �񼭿��� �ִ��� ���� ����� ������� ��Ź�� �߰�, �񼭴� �Ϸ翡 �ϳ��� ���� �ٸ� ����� ����� ��Ƴ��Ҵ�.
	������ ����� ����� �Ϸ��ϴµ� �ɸ��� �Ⱓ Ti�� ����� ���� �� ���� �� �ִ� �ݾ� Pi�� �̷���� �ִ�.
	N = 7�� ��쿡 ������ ���� ��� ����ǥ�� ����.
	 	1��	2��	3��	4��	5��	6��	7��
	Ti	3	5	1	1	2	4	2
	Pi	10	20	10	20	15	40	200
	1�Ͽ� �����ִ� ����� �� 3���� �ɸ���, ������� �� ���� �� �ִ� �ݾ��� 10�̴�. 5�Ͽ� �����ִ� ����� �� 2���� �ɸ���, ���� �� �ִ� �ݾ��� 15�̴�.
	����� �ϴµ� �ʿ��� �Ⱓ�� 1�Ϻ��� Ŭ �� �ֱ� ������, ��� ����� �� ���� ����. ���� �� 1�Ͽ� ����� �ϰ� �Ǹ�, 2��, 3�Ͽ� �ִ� ����� �� �� ���� �ȴ�. 2�Ͽ� �ִ� ����� �ϰ� �Ǹ�, 3, 4, 5, 6�Ͽ� �����ִ� ����� �� �� ����.
	����, N+1�� °���� ȸ�翡 ���� ������, 6, 7�Ͽ� �ִ� ����� �� �� ����.
	��� ���� �� �� �ִ� ����� �ִ� ������ 1��, 4��, 5�Ͽ� �ִ� ����� �ϴ� ���̸�, �� ���� ������ 10+20+15=45�̴�.
	����� ������ ���� ��, �����̰� ���� �� �ִ� �ִ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�:
	ù° �ٿ� N (1 �� N �� 15)�� �־�����.
	��° �ٺ��� N���� �ٿ� Ti�� Pi�� �������� ���еǾ �־�����, 1�Ϻ��� N�ϱ��� ������� �־�����. (1 �� Ti �� 5, 1 �� Pi �� 100)
	
	1)
		7
		3 10
		5 20
		1 10
		1 20
		2 15
		4 40
		2 200
		
	2)
		10
		1 1
		1 2
		1 3
		1 4
		1 5
		1 6
		1 7
		1 8
		1 9
		1 10
		
	3)
		10
		5 10
		5 9
		5 8
		5 7
		5 6
		5 10
		5 9
		5 8
		5 7
		5 6
		
	4)
		10
		5 50
		4 40
		3 30
		2 20
		1 10
		1 10
		2 20
		3 30
		4 40
		5 50
	���:
	ù° �ٿ� �����̰� ���� �� �ִ� �ִ� ������ ����Ѵ�.
	1)45 2)55 3)20 4)90
 */



public class Main {
	
	public static int mSizeOfDay;		// �Է¹��� day�� size
	public static TalkingAbout[] mTalkingAbout;	// period �� cost�� ���� model
	public static int mMaxCost;			// �ִ�cost ������ ����
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
		solve();
		output();
	}
	
	/**
	 * �Է� �޼ҵ�
	 */
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mSizeOfDay = Integer.parseInt(br.readLine());
		mTalkingAbout = new TalkingAbout[mSizeOfDay];
		
		for(int i = 0; i < mSizeOfDay; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			mTalkingAbout[i] = new TalkingAbout();
			mTalkingAbout[i].period = Integer.parseInt(st.nextToken());
			mTalkingAbout[i].cost = Integer.parseInt(st.nextToken());
		}
		
//		mSizeOfDay = 10;
//		mTalkingAbout = new TalkingAbout[10];
//		
//		mTalkingAbout[0] = new TalkingAbout(5, 50);
//		mTalkingAbout[1] = new TalkingAbout(4, 40);
//		mTalkingAbout[2] = new TalkingAbout(3, 30);
//		mTalkingAbout[3] = new TalkingAbout(2, 20);
//		mTalkingAbout[4] = new TalkingAbout(1, 10);
//		mTalkingAbout[5] = new TalkingAbout(1, 10);
//		mTalkingAbout[6] = new TalkingAbout(2, 20);
//		mTalkingAbout[7] = new TalkingAbout(3, 30);
//		mTalkingAbout[8] = new TalkingAbout(4, 40);
//		mTalkingAbout[9] = new TalkingAbout(5, 50);
	}
	
	/**
	 * ��� �޼ҵ�
	 */
	public static void output(){
		System.out.println(mMaxCost);
	}
	
	/**
	 * ���� �ذ� �޼ҵ�
	 */
	public static void solve(){
		dfs(0, 0);
	}
	
	/**
	 * dfs�� ��� ����� ���� ���� �˻� ����
	 * @param currentDay ���� day
	 * @param sumCost	��������� ����
	 */
	public static void dfs(int currentDay, int sumCost){
		if(currentDay >= mSizeOfDay){	// ��������
			if(mMaxCost < sumCost){
				mMaxCost = sumCost;
			}
			return;	
		}
		
		if(currentDay + mTalkingAbout[currentDay].period > mSizeOfDay){ //��� ���� �Ұ���
			dfs(currentDay +1, sumCost);
		}
		else{	// ��� ���� ����
			dfs(currentDay + mTalkingAbout[currentDay].period, 
					sumCost + mTalkingAbout[currentDay].cost); // ����� �ϴ� ���
			
			dfs(currentDay + 1, sumCost);	//����� ���������� ���� �ʴ� ���
		}
	}
	

}
/**
 * ���Ⱓ�� ����� ��������� ������ ��� Ŭ����(��)
 * @author Cho
 */
class TalkingAbout{
	public int period =0;
	public int cost =0;
	
	public TalkingAbout(){
	}
	/**
	 * ������
	 * @param period	�Ⱓ
	 * @param cost		���
	 */
	public TalkingAbout(int period, int cost){
		this.period = period;
		this.cost = cost;
	}
}
