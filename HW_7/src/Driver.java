import java.util.Arrays;
public class Driver {

	public static void main(String[] args){
		
		
		int[] ar = Driver.randIntArr(100000000);
		for(int i = 0; i<6; i++) {
			int[] ar2 = ar.clone();
			if(i<3) {
				long startTime = System.currentTimeMillis();
				Driver.quickSort(ar2, 0, ar.length-1);
				long finish = System.currentTimeMillis();
				System.out.println("it took " + (finish - startTime) +"ms to sort " + ar.length + " numbers with quick sort");
			}
			else {
				long startTime = System.currentTimeMillis();
				Driver.mergeSort(ar2, 0, ar.length-1);
				long finish = System.currentTimeMillis();
				System.out.println("it took " + (finish - startTime) +"ms to sort " + ar.length + " numbers with merge sort");
			}
		}
		
		
	}
	
	//generates a random array on ints
	public static int [] randIntArr(int size) {
		
			int[] ar = new int[size];
			for(int i = 0; i < size; i++) {
				ar[i] = (int)(Math.random() * 1000000);
			}
			return ar;
		}
		
	public static void quickSort(int[] nums, int start, int end) {
			
		   if (end <= start) {
		      return;
		   }
		         
		   int n = Driver.partition(nums, start, end);
		   quickSort(nums, start, n);		   
		   quickSort(nums, n + 1, end);
		   
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
	
	private static void merge(int[] numbers, int i, int j, int k) {
	      int mergedSize = k - i + 1;                
	      int[] mergedNumbers = new int[mergedSize]; 
	                                                 
	      int mergePos = 0;                          
	      int leftPos = i;                           
	      int rightPos = j + 1;                      
	      
	     
	      while (leftPos <= j && rightPos <= k) {
	         if (numbers[leftPos] <= numbers[rightPos]) {
	            mergedNumbers[mergePos] = numbers[leftPos];
	            leftPos++;
	         }
	         else {
	            mergedNumbers[mergePos] = numbers[rightPos];
	            rightPos++;
	         }
	         mergePos++;
	      }
	      
	      while (leftPos <= j) {
	         mergedNumbers[mergePos] = numbers[leftPos];
	         leftPos++;
	         mergePos++;
	      }
	   
	      while (rightPos <= k) {
	         mergedNumbers[mergePos] = numbers[rightPos];
	         rightPos++;
	         mergePos++;
	      }
	   
	      for (mergePos = 0; mergePos < mergedSize; mergePos++) {
	         numbers[i + mergePos] = mergedNumbers[mergePos];
	      }
	   }
	
	public static int partition(int[] nums, int start, int end) {
		   int mid = start + (end - start) / 2;
		   int pivot = nums[mid];
		   int low = start;
		   int high = end;
		   boolean doing = true;
		   
		   while (doing) {
		      while (nums[low] < pivot) {
		         low = low + 1;
		      }
		      while (pivot < nums[high]) {
		         high = high - 1;
		      }
		      if (low >= high) {
		         doing = false;
		      }
		      else {
		         int temp = nums[low];
		         nums[low] = nums[high];
		         nums[high] = temp;
		         low++;
		         high--;
		      }
		   }

		   return high;
		}
	
}
