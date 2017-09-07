/**
 * ������ ��Ȯ�� �ľ����� ����
 * 1. ������ġ�� �׻� 0�� ó���� ���� ����.
 * 2. ĭ�� �ֻ����� ����Ǹ� ĭ���ִ� ���ڴ� 0�̵Ǵ� ó���� ���� ����.
 */

import java.io.*;
import java.util.*;
public class Main {
	public static int[][] mMap;
	public static int R, C;
	public static int mDiceR, mDiceC;
	public static int mActionCount;
	public static int[] mAction;
	public static int[] mDice = new int[7];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mDiceR = Integer.parseInt(st.nextToken());
		mDiceC = Integer.parseInt(st.nextToken());
		int startR = mDiceR;
		int startC = mDiceC;
		mActionCount = Integer.parseInt(st.nextToken());
		
		mMap = new int[R][C];
		mAction = new int[mActionCount];
		
		for(int r = 0; r < R; r++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0 ; c < C; c++){
				mMap[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < mActionCount; i++){
			mAction[i] = Integer.parseInt(st.nextToken());
			if(changeDice(mAction[i])){
				System.out.println(mDice[1]);
				
				if(mMap[mDiceR][mDiceC] == 0){
					//if(!(mDiceR==startR && mDiceC == startC)){
						mMap[mDiceR][mDiceC] = mDice[6];	
					//}
				}
				else{
					mDice[6] = mMap[mDiceR][mDiceC];
					mMap[mDiceR][mDiceC] =0;
				}
			}
		
		}
	
		
	}
	// ������ 1, ������ 2, ������ 3, ������ 4�� �־�����.
	public static boolean changeDice(int action){
		int temp = 0;
		switch(action){
		case 1:		//�� 
			if(mDiceC + 1 >= C){
				return false;
			}
			mDiceC++;
			temp = mDice[1];
			mDice[1] = mDice[4];
			mDice[4] = mDice[6];
			mDice[6] = mDice[3];
			mDice[3] = temp;
			
			break;
		case 2:		//�� 
			if(mDiceC - 1 < 0){
				return false;
			}
			mDiceC--;
			temp = mDice[1];
			mDice[1] = mDice[3];
			mDice[3] = mDice[6];
			mDice[6] = mDice[4];
			mDice[4] = temp;
			
			break;
		case 3:		//�� 
			if(mDiceR - 1 < 0){
				return false;
			}
			mDiceR--;
			temp = mDice[1];
			mDice[1] = mDice[5];
			mDice[5] = mDice[6];
			mDice[6] = mDice[2];
			mDice[2] = temp;
			break;
		case 4:	//�� 
			if(mDiceR + 1 >= R){
				return false;
			}
			mDiceR++;
			
			temp = mDice[1];
			mDice[1] = mDice[2];
			mDice[2] = mDice[6];
			mDice[6] = mDice[5];
			mDice[5] = temp;
			
			break;
			
		}
		return true;
	}

}
