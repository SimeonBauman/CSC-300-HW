import java.util.*; 
public class HugeInt {

	public List<Integer> num = new ArrayList<Integer>();
	
	HugeInt(String num){
		this.convertStringtoNum(num);
	}
	
	void convertStringtoNum(String s) {
		for(int i =0 ; i < s.length(); i++) {
			
		
			num.add(Character.getNumericValue(s.charAt(i)));
		}
	}
	
	public static int compare(HugeInt l1, HugeInt l2) {
		
		int returnVal = 0;
		
		if(l1.num.size() == l2.num.size()) {
			for(int i =0; i < l1.num.size();i++) {
				if(l1.num.get(i)!= l2.num.get(i)) {
					
					if(l1.num.get(i) > l2.num.get(i)) {
						return 1;
					}
					else if(l1.num.get(i) < l2.num.get(i)) {
						return -1;
					}
				}
				
			}
		}
		if(l1.num.size() > l2.num.size()) {
			return 1;
		}
		else if(l1.num.size() < l2.num.size()) {
			return -1;
		}
		
		return returnVal;
		
		
	}
	
	public void ToString() {
		
		for(int i = 0; i < num.size(); i++) {
			System.out.print(num.get(i));
		}
	}

	public static HugeInt addNums(HugeInt i1,HugeInt i2){
		HugeInt n = new HugeInt("");
		int max;
		int min;
		
		HugeInt larger ;
		
		if(i1.num.size() > i2.num.size()) {
			larger = i1;
			max = i1.num.size();
			min = i2.num.size();
		}
		else {
			larger = i2;
			max = i2.num.size();
			min = i1.num.size();
		}
		
		
		int carry = 0;
		
		for(int i = 0; i <max; i++ ) {
			if(i <min) {
				int num = i1.num.get(i1.num.size()-1-i) + i2.num.get(i2.num.size()-1-i) + carry;
				if(num > 9) {
					
					carry = (num - (num % 10))/10;
					num %= 10;
				}
				else {
					carry =0;
				}
				n.num.add(0,num);
			}
			else {
				int num = larger.num.get(larger.num.size()-1-i) + carry;
				if(num > 9) {
					
					carry = (num - (num % 10))/10;
					num %= 10;
				}
				else {
					carry = 0;
				}
				n.num.add(0,num);
			}
			
		}
		if(carry > 0 && carry < 10) {
			n.num.add(0,carry);
		}
		
		
		return n;
		
		
		
		
	}
	
	public static HugeInt multNums(HugeInt i1,HugeInt i2){
	
	
		
	
		HugeInt returnVal = new HugeInt("0");
		
		//returnVal.num = HugeInt.addNums(i1, i2);
		
		HugeInt index = new HugeInt("");
		
		HugeInt one = new HugeInt("1");
		
		
		while(HugeInt.compare(index, i2) != 0) {
			returnVal = HugeInt.addNums(returnVal,i1);
			index = HugeInt.addNums(one, index);
			
		}
		
		
		return returnVal;
		
	}
	
	
	public static void sortNums(List<HugeInt> nums) {
		
		for(int i = 0;i<nums.size();i++) {
			int smallest = i;
			for(int j = i+1; j < nums.size(); j++) {
				if(HugeInt.compare(nums.get(i), nums.get(j)) == 1) {
					smallest = j;
				}
			}
			HugeInt temp = nums.get(i);
			nums.set(i, nums.get(smallest));
			nums.set(smallest, temp);
			
		}
	}
}
