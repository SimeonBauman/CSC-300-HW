import java.util.Arrays;

public class Driver {

	public static void main(String[] args){
		
		int[] ar = Driver.randIntArr(100000);
		int[] ar2 = ar.clone();
		Driver.bubbleSort(ar2);
		Driver.insertionSort(ar);
		
		
		
		
	}
	//generates a random array on ints
	static int [] randIntArr(int size) {
		int[] ar = new int[size];
		for(int i = 0; i < size; i++) {
			ar[i] = (int)(Math.random() * 1000000);
		}
		return ar;
	}
	//Bubble sort function
	static void bubbleSort(int[] ar) {
		long startTime = System.currentTimeMillis();	
		for(int i =0; i < ar.length - 1; i++) {
			for(int j = i + 1; j < ar.length; j++) {
				if(ar[i] > ar[j]) {
					int k = ar[j];
					ar[j] = ar[i];
					ar[i] = k;
				}
			}
			
			
		}
		long finish = System.currentTimeMillis();
		System.out.println("it took " + (finish - startTime) +"ms to sort " + ar.length + " numbers with bubble sort");
		
		
		
	}
	
	//Selection sort function
	static void selectionSort(int[] ar) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < ar.length - 1; i++) {
			int smallest = i;
			for(int j = i + 1; j < ar.length; j++) {
				if(ar[j] < ar[smallest]) {
					smallest = j;
			    }
			}
			
			int k = ar[i];
			ar[i] = ar[smallest];
			ar[smallest] = k;
		}
		long finish = System.currentTimeMillis();
		System.out.println("it took " + (finish - startTime) +"ms to sort " + ar.length + " numbers with selection sort");
		
	}

	//Insertion sort function
	static void insertionSort(int[] ar) {
		long startTime = System.currentTimeMillis();
		for (int i = 1; i < ar.length; i++) {
	         int j = i;
	         while (j > 0 && ar[j] < ar[j - 1]) {
	            
	            int temp = ar[j];
	            ar[j] = ar[j - 1];
	            ar[j - 1] = temp;
	            j--;
	         }
	      }
		long finish = System.currentTimeMillis();
		System.out.println("it took " + (finish - startTime) +"ms to sort " + ar.length + " numbers with insertion sort");

	}
}


