import java.util.Arrays;
public class Driver {

	
	public static void main(String[] args){
		
		
		int[] ar = Driver.randIntArr(10000000);
		long startTime = System.currentTimeMillis();
		Driver.mergeSort(ar, 0, ar.length-1);
		long finish = System.currentTimeMillis();
		System.out.println("it took " + (finish - startTime) +"ms to sort " + ar.length + " numbers with merge sort");
		
	}
	
	public static int [] randIntArr(int size) {
		
		int[] ar = new int[size];
		for(int i = 0; i < size; i++) {
			ar[i] = (int)(Math.random() * 1000000);
		}
		return ar;
	}
	public static void mergeSort(int[] nums, int i, int k) {
	      int j = 0;
	      
	      if (i < k) {
	         j = (i + k) / 2;  
	         
	         mergeSort(nums, i, j);
	         mergeSort(nums, j + 1, k);
	            
	         merge(nums, i, j, k);
	      }
	}
	
	private static void merge(int[] numbers, int low, int mid, int high) {
		int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (numbers[i] <= numbers[j]) {
                i++;
            } else {
                int value = numbers[j];
                int index = j;

                while (index != i) {
                    numbers[index] = numbers[index - 1];
                    index--;
                }

                numbers[i] = value;

                i++;
                mid++;
                j++;
            }
        }
	   }
	
}
