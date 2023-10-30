import java.util.Arrays; 
import java.util.List; 
import java.util.ArrayList; 
public class Driver {
	public static void main(String[] args){
		
		
	
		long p = 770000000L;
		
		List<Generation> generations =  new ArrayList<Generation>();
		generations.add(new Generation(7700000000L,18,13L));
		
		int years = 0;
		while(Driver.returnPeople(generations) > Driver.returnDec(generations)) {
			
			
			if(years%3 == 0) {
				Driver.convert(generations);
			}
			
			Driver.checkAges(generations);
			
			years++;
		}
		
		System.out.println(years);
		for(int i = 0; i < generations.size(); i++) {
			System.out.println(generations.get(i).numOfD + " " + generations.get(i).peopleCount + " " + generations.get(i).age);
		}
	}
	
	
	public static long returnPeople(List<Generation> gen) {
		
		long temp =0;
		for(int i = 0; i < gen.size(); i++) {
			temp += gen.get(i).peopleCount;
		}
		return temp;
		
	}
	
	public static long returnDec(List<Generation> gen) {
		long temp =0;
		for(int i = 0; i < gen.size(); i++) {
			temp += gen.get(i).numOfD;
		}
		return temp;
	}
	
	public static void checkAges(List<Generation> gen) {
		for(int i = 0; i < gen.size(); i++) {
			int age = gen.get(i).age;
			if(age == 72) {
				gen.remove(i);
			}
			else if(age == 30) {
				Generation g = new Generation(gen.get(i).peopleCount /2,-1,0L);
				gen.add(g);
			}
			gen.get(i).age++;
		}
		
	}

	public static void convert(List<Generation> gen) {
		long l = Driver.returnDec(gen);
		long desired = l*3;
		
		
		for(int i =0; i < gen.size();i++) {
			if(gen.get(i).age >= 21) {
				gen.get(i).numOfD += desired; 
				if(gen.get(i).numOfD > gen.get(i).peopleCount) {
					desired = gen.get(i).numOfD - gen.get(i).peopleCount;
					
					gen.get(i).numOfD = gen.get(i).peopleCount;
				}
				else {
					break;
				}
			}
			else {
				break;
			}
			
		}
		
	}
}
