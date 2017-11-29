/**
 * 문제를 정확히 파악하지 못함
 * 1. 시작위치는 항상 0인 처리를 하지 않음.
 * 2. 칸이 주사위에 복사되면 칸에있는 숫자는 0이되는 처리를 하지 않음.
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
	// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.
	public static boolean changeDice(int action){
		int temp = 0;
		switch(action){
		case 1:		//동 
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
		case 2:		//서 
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
		case 3:		//북 
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
		case 4:	//남 
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
