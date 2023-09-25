import java.lang.Math;
public class Driver {
	public static int times = 0;
	public static void main(String[] args){
		
		
			times = 0;
			long n = Driver.calcFib(10);
			System.out.println("Number: " + 10 + " Times through: " + times + " Result: " + n);
			
		
	}
	
	//calcualtes the number by recursively calling this function and counts the times called
	public static long calcFib(int num) {
		times++;
		if(num > 1) {
			
			long returnNum = Driver.calcFib(num-1) + Driver.calcFib(num-2);
			return returnNum;
		}
		
		return num;
	}
	

}
