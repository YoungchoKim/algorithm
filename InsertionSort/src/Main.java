
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array= new int[]{5,4,3,2,1,9,8,7,6,0};
		
		for(int i = 1; i < array.length; i++){
			
			int key = array[i];
			for(int j = i-1; j >=0; j--){
				if(array[j] > key){
					array[j+1] = array[j];
					if(j == 0){
						array[j] = key;
					}
				}
				else{
					if(j == i-1){
						break;
					}
					else{
						array[j+1] = key;	//이부분에서 실수.
						break;	
					}
				}
			}
			System.out.print(i + " : ");
			for(int j = 0; j < 10; j++){
				System.out.print(array[j] + " ");
			}
			System.out.println("");
			
			
			
			
			
//			int key = array[i];
//			for(int j = i-1; j >= 0; j--){
//				if(array[j] > key){
//					array[j+1] = array[j];
//					if(j == 0){
//						array[j] = key;
//					}
//				}
//				else{
//					if(j == i-1){
//						array[j+1] = key;
//					}
//					else{
//						array[j] = key;	
//					}
//					break;
//				}
//			}
			
		}
		
		for(int i = 0; i < 10; i++){
			System.out.print(array[i] + " ");
		}
		
		
		
		
	}

}
