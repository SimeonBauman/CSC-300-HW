import java.util.*; 
public class Driver {
	public static void main(String[] args){
	
		HugeInt n = new HugeInt("14235620");
		HugeInt n2 = new HugeInt("724692547924572");
		HugeInt n3 = HugeInt.addNums(n, n2);
		HugeInt n4 = HugeInt.multNums(n, n);
		;
		List<HugeInt> nums = new ArrayList<HugeInt>();
		
		nums.add(n2);
		nums.add(n);
		nums.add(n3);
		nums.add(n4);
		
		
		HugeInt.sortNums(nums);
		
		
		for(int i =0; i < nums.size(); i++) {
			nums.get(i).ToString();
			System.out.println();
		}
	
		
	}
}
