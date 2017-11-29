import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author Cho
 * 
 *  상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
	오늘부터 N+1일째 되는날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
	백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
	각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
	N = 7인 경우에 다음과 같은 상담 일정표를 보자.
	 	1일	2일	3일	4일	5일	6일	7일
	Ti	3	5	1	1	2	4	2
	Pi	10	20	10	20	15	40	200
	1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.
	상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.
	또한, N+1일 째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.
	퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이 때의 이익은 10+20+15=45이다.
	상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
	
	입력:
	첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
	둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 100)
	
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
	출력:
	첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
	1)45 2)55 3)20 4)90
 */



public class Main {
	
	public static int mSizeOfDay;		// 입력받을 day의 size
	public static TalkingAbout[] mTalkingAbout;	// period 와 cost를 갖는 model
	public static int mMaxCost;			// 최대cost 저장할 변수
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
		solve();
		output();
	}
	
	/**
	 * 입력 메소드
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
	 * 출력 메소드
	 */
	public static void output(){
		System.out.println(mMaxCost);
	}
	
	/**
	 * 문제 해결 메소드
	 */
	public static void solve(){
		dfs(0, 0);
	}
	
	/**
	 * dfs로 모든 경우의 수에 대한 검사 진행
	 * @param currentDay 현재 day
	 * @param sumCost	현재까지의 이익
	 */
	public static void dfs(int currentDay, int sumCost){
		if(currentDay >= mSizeOfDay){	// 종료조건
			if(mMaxCost < sumCost){
				mMaxCost = sumCost;
			}
			return;	
		}
		
		if(currentDay + mTalkingAbout[currentDay].period > mSizeOfDay){ //상담 진행 불가능
			dfs(currentDay +1, sumCost);
		}
		else{	// 상담 진행 가능
			dfs(currentDay + mTalkingAbout[currentDay].period, 
					sumCost + mTalkingAbout[currentDay].cost); // 상담을 하는 경우
			
			dfs(currentDay + 1, sumCost);	//상담이 가능하지만 하지 않는 경우
		}
	}
	

}
/**
 * 상담기간과 비용의 멤버변수를 가지는 상담 클래스(모델)
 * @author Cho
 */
class TalkingAbout{
	public int period =0;
	public int cost =0;
	
	public TalkingAbout(){
	}
	/**
	 * 생성자
	 * @param period	기간
	 * @param cost		비용
	 */
	public TalkingAbout(int period, int cost){
		this.period = period;
		this.cost = cost;
	}
}
