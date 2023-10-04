import java.lang.Math;
public class Driver {
	
	public static void main(String[] args){
		long num = 13;
		long people = 7700000000L;
		
		//I was initially using 'while' functions for these, but I thought it through and realized that these problems could be solved with algebraic equations.

		System.out.println("It will take " +  Driver.equtionForYears(num, people)+ " years for " + num + " people to convert " + people+ " people");
		System.out.println("If we are limmited to 50 years, each diciple will have to train " + Driver.equtionForTrainies(num, people) + " people every three years");
	
	}
	// uses this equation: x = (ln(7.7b/13) - (ln(7.7b/13)/10)) * 3 (you do need to round up to nearest since we want to look at full years
	static double equtionForYears(long num, long people) {
		
		double result = (Math.log(people/num));
		result -= result/10;
		result = Math.ceil(result);
		result *= 3;	
		return result;
		
	}
	
	// uses this equation: x = (7.7b/13)^(3/50) (round up to int as you can't have part of a person) 
	static double equtionForTrainies(long num,long people) {
		double d = people/num;
		float p = 3;
		p /=50;	
		d =  Math.pow(people/num, (p));
		d = Math.ceil(d);
		return d;
	}
	
}
