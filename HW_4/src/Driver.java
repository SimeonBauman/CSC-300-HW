import java.util.Arrays;

public class Driver {
	public static void main(String[] args){

		//creating the array of sorted numbers
		int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		
		//converts and prints the returned array
		System.out.print(Arrays.toString( Driver.matrixSearch(arr,12)));
	}
	
	//uses the modulo function to keep track the index of the current value in the 2D array to accomplish the matrix search 
	public static int[] matrixSearch(int[][] arr, int key) {
		
		int min = 0;
		int max = (arr.length) *  arr[arr.length-1].length;
		
		
		while (true) {
			int avg = (min + max )/2;
			
			if(avg == key) {
				avg--;
				int[] r = {(avg-(avg% arr[0].length))%arr.length,avg% arr[0].length};
				return r;
			}
			else if(key == max) {
				avg = max-1;
				int[] r = {(avg-(avg% arr[0].length))%arr.length,avg% arr[0].length};
				return r;
			}
			
			else if(avg > key) {
				max = avg;
			}
			else {
				min = avg;
			}
			
		}
		
		
	}
}
