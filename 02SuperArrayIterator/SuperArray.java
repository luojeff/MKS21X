import java.util.Iterator;

public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size = 0;

    public SuperArray() {
	data = new String[10];
    }

    public SuperArray(int initialCapacity){
	if(initialCapacity < 0){
	    System.out.println("Exception caught! Capacity is negative: " + initialCapacity);
	    throw new IllegalArgumentException();
	}
	
	data = new String[initialCapacity];
    }

    public int size() {
	return size;
    }

    public String get(int index){
	if(index < 0 || index >= size()){
	    System.out.println("Exception caught! Index is out of bounds: " + index);
	    throw new IndexOutOfBoundsException();
	}
	
	return data[index];
    }

    public void clear(){
	size = 0;
    }

    public boolean isEmpty(){
	return (size() == 0);
    }

    // returns old value
    public String set(int index, String element){
	if(index < 0 || index >= size()){
	    System.out.println("Exception caught! Index is out of bounds: " + index);
	    throw new IndexOutOfBoundsException();
	}
	
	String old_val = get(index);
	data[index] = element;
	return old_val;
    }

    public void trimToSize(){
	data = toArray();
    }
    
    public String[] toArray(){
	String[] ret_data = new String[size()];
	for(int i=0;i<size();i++){
	    ret_data[i] = get(i);
	}

	return ret_data;
    }

    public int indexOf(String element){
	for(int j=0;j<size();j++){
	    if(get(j).equals(element)){
		return j;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String element){
	for(int k=size();k>=0;k--){
	    if(get(k).equals(element)){
		return k;
	    }
	}
	return -1;
    }

    // Constant time, adds directly to the end, unless 
    public boolean add(String n){
	if (size < data.length) {
	    data[size] = n;
	} else {
	    grow();
	    data[size] = n;
	}
	size++;
	return true;
    }

    public void add(int index, String element){
	String[] new_array;
	
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}

        if(size() == data.length){
	    new_array = new String[data.length + 1];
	    size++;
	} else {
	    new_array = new String[data.length];
	    size++;
	}					 

	for(int i=0;i<index;i++){
	    new_array[i] = get(i);
	}
	
	new_array[index] = element;

	for(int i=index;i<size()-1;i++){
	    new_array[i+1] = get(i);
	}

	data = new_array;	
    }

    public void remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	
	String[] new_array;
	
	if(data.length > 10){
	    new_array = new String[data.length - 1];
	} else {
	    new_array = new String[10];
	}
	
	size--;

	for(int i=0; i<index; i++){
	    new_array[i] = get(i);
	}

	if(index != data.length - 1){
	    for(int j=index+1;j<data.length;j++){
		new_array[j-1] = data[j];
	    }
	}
	
	data = new_array;
    }
    
    private void grow() {
	grow(1);
    }

    private void grow(int amount) {
	String[] new_data = new String[data.length + amount];

	for (int i=0;i<size();i++) {
	    new_data[i] = get(i);
	}

	data = new_data;
    }

    public String toString() {
	String ret_string = "[ ";

	for (int i=0;i<size;i++) {
	    if(i < size-1){
		ret_string += get(i) + ", ";
	    } else if (i < size){
		ret_string += get(i);
	    }
	}

	return ret_string + "]";
    }

    public String toStringDebug() {
	String ret_string = "[ ";

	for (int i=0;i<data.length;i++) {
	    if(i<size-1){
		ret_string += get(i) + ", ";
	    } else if (i < size){
		ret_string += get(i);
	    } else {
		ret_string += ", _";
	    }
	}

	return ret_string + "]";
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
}
