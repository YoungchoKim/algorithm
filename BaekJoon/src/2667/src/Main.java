import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Cho
 *<�׸� 1>�� ���� ���簢�� ����� ������ �ִ�. 1�� ���� �ִ� ����, 0�� ���� ���� ���� ��Ÿ����. 
 *ö���� �� ������ ������ ����� ������ ������ ������ �����ϰ�, ������ ��ȣ�� ���̷� �Ѵ�. 
 *���⼭ ����Ǿ��ٴ� ���� � ���� �¿�, Ȥ�� �Ʒ����� �ٸ� ���� �ִ� ��츦 ���Ѵ�. 
 *�밢���� ���� �ִ� ���� ����� ���� �ƴϴ�. <�׸� 2>�� <�׸� 1>�� �������� ��ȣ�� ���� ���̴�. 
 *������ �Է��Ͽ� �������� ����ϰ�, �� ������ ���ϴ� ���� ���� ������������ �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù ��° �ٿ��� ������ ũ�� N(���簢���̹Ƿ� ���ο� ������ ũ��� ������ 5��N��25)�� �Էµǰ�, �� ���� N�ٿ��� ���� N���� �ڷ�(0Ȥ�� 1)�� �Էµȴ�.
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
���
ù ��° �ٿ��� �� �������� ����Ͻÿ�. �׸��� �� ������ ���� ���� ������������ �����Ͽ� �� �ٿ� �ϳ��� ����Ͻÿ�.
3
7
8
9
 */
public class Main {

	public final static int mMax = 25;	
	public static int[][] mMap;			//����
	public static int[][] mCopyMap;		//ī���� ����
	public static int mSize;			//���� ũ�� mSize X mSize
	public static ArrayList<Integer> mResult;	//���� �� ���� ���� �����ϴ� list
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		solve();
		output();
		
	}
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mSize = Integer.parseInt(br.readLine());
		mResult = new ArrayList<Integer>();
		mMap = new int[mSize][mSize];
		mCopyMap = new int[mSize][mSize];
		
		for(int i = 0; i < mSize ; i++){
			String s = br.readLine();
			for(int j = 0; j < mSize; j++){
				mMap[i][j] = s.charAt(j) - '0';
			}
		}
		
//		mMap = new int[][]{
//			{0, 1, 1, 0, 1, 0, 0},
//			{0, 1, 1, 0, 1, 0, 1},
//			{1, 1, 1, 0, 1, 0, 1},
//			{0, 0, 0, 0, 1, 1, 1},
//			{0, 1, 0, 0, 0, 0, 0},
//			{0, 1, 1, 1, 1, 1, 0},
//			{0, 1, 1, 1, 0, 0, 0}
//		};
//		mCopyMap = new int[7][7];
	}
	public static void output(){
		
		Collections.sort(mResult);
		System.out.println(mResult.size());
		for(int i = 0; i < mResult.size(); i++){
			System.out.println(mResult.get(i));
		}
		
	}

	public static void solve(){
		copyMap();
		for(int i = 0; i < mSize; i++){
			for(int j = 0; j < mSize ; j++){
				if(mCopyMap[i][j] == 1){
					bfs(i , j);	
				}
			}
		}
	}
	
	
	public static void copyMap(){
		if(mSize <=0){
			return;
		}
		
		for(int i = 0; i < mSize; i++){
			for(int j = 0; j < mSize ; j++){
				mCopyMap[i][j] = mMap[i][j];
			}
		}
	}
	
	public static void bfs(int i, int j){
		int count = 0;	//������ ���Ǽ��� count�ϴ� ����
		Queue queue;
		queue = new LinkedList<Dot>();
		queue.add(new Dot(i, j));
		mCopyMap[i][j] = 3;
		count++;
		while(!queue.isEmpty()){
			Dot tempDot = (Dot)queue.poll();
			if(inspectRange(tempDot.i + 1, tempDot.j)){
				queue.add(new Dot(tempDot.i + 1, tempDot.j));
				mCopyMap[tempDot.i + 1][tempDot.j] = 3;
				count++;
			}
			if(inspectRange(tempDot.i - 1, tempDot.j)){
				queue.add(new Dot(tempDot.i - 1, tempDot.j));
				mCopyMap[tempDot.i - 1][tempDot.j] = 3;
				count++;
			}
			if(inspectRange(tempDot.i, tempDot.j + 1)){
				queue.add(new Dot(tempDot.i, tempDot.j + 1));
				mCopyMap[tempDot.i][tempDot.j + 1] = 3;
				count++;
			}
			if(inspectRange(tempDot.i, tempDot.j - 1)){
				queue.add(new Dot(tempDot.i, tempDot.j - 1));
				mCopyMap[tempDot.i][tempDot.j - 1] = 3;
				count++;
			}
		}
		if(count > 0){
			mResult.add(count);
		}
		
	}
	
	public static boolean inspectRange(int i, int j){
		if(i >=0 && i < mSize && j >=0 && j < mSize){
			if(mCopyMap[i][j] == 1){
				return true;
			}
		}
		return false;
	}
	
	public static class Dot{
		public int i;
		public int j;
		
		public Dot(int i, int j){
			this.i = i;
			this.j = j;
		}
	}

}
