
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 3, 2};
		Solution s = new Solution();
		System.out.println(s.solution(arr));
	}

}

class Solution {
    public boolean solution(int[] arr) {
       boolean[] visited;
       
       visited = new boolean[100001];
    
    	for(int i = 0; i < arr.length; i++){
    		if(arr[i] > arr.length){
    			return false;
    		}
    		else if(!visited[arr[i] - 1]){
    			visited[arr[i] - 1] = true;
    		}
    		else if(visited[arr[i] - 1]){
    			return false;
    		}
    	}
        
        return true;
    }
}
