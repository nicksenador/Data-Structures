//Nicholas Senador

/*SOLUTION to implement problems 1-10 listed in the assignment
 *0. ArrayList object - I will use java's array to build my ArrayList upon and declare size as an attribute to it
 *   The array will be of type object and will check consistency of object type in the add methods
 *1. ArrayList() - default constructor - set int size to 10
 *2. ArrayList(int n) - constructor - takes int as parameter and sets size to n
 *3. ArrayList.add(object x) - for loop through array looking for next available null, then check for same type of objects as x, then this.array[index] = x. if all indexes in array are null, add x at [0]
 *if object exists in last index, size *=2, create new array of new size and recursively add objects
 *if object already exists at index, call private method to make a new array with x inserted
 *4. ArrayList.add(int index, object x) - if index > this.size - 1, this.size = index-1 and new array of new size recursively adding objects, this.array[index] = x. else, for loop to see if any objects in this.array, if so, check same objects consistency and this.array[index]=x, if not this.array[index] = x.
 *if object exists in last index, size*=2, create new array of new size and recursively add objects
 *5. public Object get(int index) - return this.array[index]
 *6. public int size() - go from the back of this.array to find first non-null index, return that index plus 1
 *7. public boolean isEmpty() - for loop going through this.array, if this.array[index] does not = null return false. return true outside for loop. 
 *8. public boolean isIn(Object b) - for loop going through this.array, if this.array[index] = b return true. return false outside for loop.
 *9. public int find(Object b) - for loop through this.array, if this.array[index] = b, return index. return -1 outside for loop.
 *10. public void remove(Object n) - call find function, if returned value != -1, new array, for loop to add back objects except index of returned value from find method
 *
 *DATA STRUCTERS
 *	Object array and int for size
 *
 *HOW TO USE
 *	All of the public methods may be used to create and manipulate arraylist objects. call them with arrayListName.methodName(paramaters if any);
 *
 *PURPOSE OF THIS CLASS
 * The purpose of this class is to make it so the user can make arraylist objects. It is also to define methods to create and manipulate methods of the arraylist class.
 */

public class ArrayList {
	//data types we need for ArrayList class
	//these are private because the user doesn't need to know about these
	private Object[] a;
	private int size;
	
	//default constructor
	//public because the user can use this method
	public ArrayList() {
		size = 10;
		a = new Object[size];
	}
	
	//constructor with specified size passed
	//public because the user may use this method
	public ArrayList(int n) {
		size = n;
		a = new Object[size];
	}
	
	//add object, x, to an arraylist method
	//public because the user may use this method
	// @param x is an object
	public void add(Object x) {
		//if empty, add x at a[0]
		if (this.isEmpty()) {
			a[0] = x;
		
		//if not empty, check to see if the object types are the same, then add at next null
			// there is no need to check all objects since there can't be different objects if this is checked every time
		} else {
			
			//looking for first object
			there:
			for (int i = 0; i < size; i ++) {
				
				if (this.a[i] != null) {
					
					//same class check
					if (this.a[i].getClass().equals(x.getClass())) {
						
						//find first null, and add x, and then break to get out of for loop
						for (int j = 0; j < size; j ++) {
							if (this.a[j] == null) {
								this.a[j] = x;
								break there;
							}
						}
					}
				}
			}
		}
		
		//if there is an element in the last index of a, multiply size by two, and make a new array of that size calling makeArray method
		if (a[size - 1] != null) {
			size = size * 2;
			newArray(a, size);
		}
		
	}
	
	//add object x at a[index]
	//public because the user may use this method
	//@param index >= 0
	//@param x is an object
	public void add(int index, Object x) {
		//if the index specified is bigger than the current array
		if (index > size - 1 ) {
			size = size * 2;
			newArray(a, size);
		}
		
		//if array is empty, no need to check object types
		if (this.isEmpty()) {
			a[index] = x;
		}
		
		//if not empty, find first object to see if x is of the same type
		there:
		for (int i = 0; i < size; i ++) {
			if (a[i] != null) {
				//type check, then add object at index and break out of loop
				if (a[i].getClass().equals(x.getClass())) {
					this.a[index] = x;
					break there;
				}
			}
		}
		
		//if there is an element in the last index of a, multiply size by two, and make a new array of that size calling makeArray method
		if (a[size - 1] != null) {
			size = size * 2;
			newArray(a, size);
		}
	}
	
	//get object at index x of arraylist from this.array
	//public because the user may use this method
	//@param index >= 0
	//@return a[index] is an object
	public Object get(int index) {
		return a[index];
	}
	
	//this returns the amount of objects in the arraylist, not in the size of the array
	//public because the user may use this method
	//@return int >=0
	public int size() {
		for (int i = size - 1; i > 0; i --) {
			if (a[i] != null) {
				return i + 1;
			}
		}
		return 0;
	}
	
	//public because the user may use this method
	//@return boolean will be either true or false
	public boolean isEmpty() {
		for (int i = 0; i < size; i ++) {
			if (this.a[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	//public because the user may use this method
	//@param ob is an object
	//@return boolean will be true or false
	public boolean isIn(Object ob) {
		for (int i = 0; i < size; i ++) {
			if (a[i].equals(ob)) {
				return true;
			}
		}
		return false;
	}
	
	//public because the user may use this method
	//@param n
	//@return int = -1 or >= 0
	public int find(Object n) {
		for (int i = 0; i < size; i ++) {
			if (a[i].equals(n)) {
				return i;
			}
		}
		return -1;
	}
	
	//public because the user may use this method
	//@param n is an object
	public void remove(Object n) {
		int x = find(n);
		if (x != -1) {
			Object[] newArray = new Object[size];
			for (int i = 0; i < size; i ++) {
				//this if else statement skips adding x to newArray and adds the rest of a to newArray - 1 index since we skipped x
				if (i < x) {
					newArray[i] = a[i];
				} else if (i > x) {
					newArray[i-1] = a[i];
				}
			}
			a = newArray;
		}
	}
	
	//private method (because it is not available to the user outside this class) to create new array
	//@param a is an array
	//@param size > 0
	private void newArray(Object[] a, int size) {
		Object[] newArray = new Object[size];
		for (int i = 0; i < a.length; i ++) {
			newArray[i] = a[i];
		}
		this.a = newArray;
	}
	
}
