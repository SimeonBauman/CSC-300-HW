
public class Driver {

	public static void main(String[] args) {
		HashTable_Chaining hash = new HashTable_Chaining(10);
		
		hash.HashInsert(10, 10);
		hash.HashInsert(20, 20);
		hash.HashInsert(11, 11);
		hash.HashInsert(22, 22);
		hash.HashInsert(27, 27);
		System.out.println(hash);
		
		HashTable_Linear hashLinear = new HashTable_Linear(10);
		
		hashLinear.HashInsert(10, 10);
		hashLinear.HashInsert(20, 20);
		hashLinear.HashInsert(11, 11);
		hashLinear.HashInsert(22, 22);
		hashLinear.HashInsert(27, 27);
		System.out.println(hashLinear);

	}

}