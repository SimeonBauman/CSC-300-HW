
public class HashTable_Linear extends HashTable {
public Node[] Table;
	
	public int Size;
	
	public HashTable_Linear(int Size) {
		this.Size = Size;
		this.Table = new Node[this.Size];
		
	}
	
	
	//hashing is the process to translate a key into a value for indexing/searching
	private int Hashing(int key) {
		//use modulo for the hashing
		int result = key % this.Size;
		return result;
	}

	@Override
	public void HashInsert( int key, int value) {
		   // Hash function determines initial bucket
		   int bucket = Hashing(key);
		   int bucketsProbed = 0;
		   int N = this.Size;
		   
		   while (bucketsProbed < N) {
		      // Insert item in next empty bucket
		      if (Table[bucket] == null) {
		    	  Table[bucket] = new Node(key,value);
		    	  
		    	  break;
		      }

		      // Increment bucket index
		      bucket = (bucket + 1) % N;

		      // Increment number of buckets probed
		      bucketsProbed++;
		   }

		   
		}

	@Override
	public boolean HashSearch(int key) {
		//1 look for the index based on the key
		int index = Hashing(key);
		for(int i =0; i<this.Size; i++) {
			if(Table[(index+i)%this.Size].Key == key) {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public void HashDelete(int key) {
		//1 using hashing function get the index of the key
		int index = Hashing(key);
		for(int i =0; i<this.Size; i++) {
			if(Table[(index+i)%this.Size].Key == key) {
				Table[(index+i)%this.Size] = null;
			}
		}
		
	}
	
	@Override
	public String toString() {
		String output = "";
		for(int i = 0; i < this.Size; i++) {
			if(this.Table[i] !=null) {
				output += "[" + i + "]: " + this.Table[i].toString() + "\n";
			}
			else {
				output += "[" + i + "]: " + "\n";
			}
		}
		return output;
	}
}
