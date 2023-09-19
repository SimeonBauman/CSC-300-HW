
public class Driver {
	public static void main(String[] args){

		System.out.println(Driver.IsAllUnique("not dabls"));
	}
	
	public static boolean IsAllUnique(String str){
	    boolean[] letters = new boolean[127];
	    str = str.toLowerCase();
	    for(int i = 0; i < str.length(); i++) {
	    	if(letters[str.charAt(i)] == true) {
	    		return false;
	    	}
	    	letters[str.charAt(i)] = true;
	    }
	    
	    return true;
	}
}
