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
				int[] gapValues = getGap(ar2.length);
				
				long startTime = System.currentTimeMillis();
				
				Driver.shellSort(ar2,gapValues);
				long finish = System.currentTimeMillis();
				System.out.println("it took " + (finish - startTime) +"ms to sort " + ar.length + " numbers with shell sort");
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
	
	public static int insertionSortInterleaved(int[] numbers, int startIndex, int gap) {
	      int swaps = 0;
	      for (int i = startIndex + gap; i < numbers.length; i += gap) {
	         int j = i;
	         while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) {
	            swaps++;
	            // Swap numbers[j] and numbers [j - 1]
	            int temp = numbers[j];
	            numbers[j] = numbers[j - gap];
	            numbers[j - gap] = temp;
	            j -= gap;
	         }
	      }
	      return swaps;
	   }
	   
	public static int[] getGap(int num) {
		int[] gaps = new int[(num)-1];
		int current;
		if(num%2!=0) current = num-1;
		else current = num;
		current/=2;
		int index = 0;
		while(current > 1) {
			gaps[index] = current;
			current/=2;
			index++;
		}
		gaps[index] = 1;
		return gaps;
	}
	
	public static int shellSort(int[] numbers, int[] gapValues) {
		      int totalSwaps = 0;
		      for (int g = 0; g < gapValues.length; g++) {
		         int swapsForGap = 0;
		         for (int i = 0; i < gapValues[g]; i++) {
		            swapsForGap += insertionSortInterleaved(numbers, i, gapValues[g]);
		         }
		        
		         totalSwaps += swapsForGap;
		      }
		      return totalSwaps;
		   }

	
}
