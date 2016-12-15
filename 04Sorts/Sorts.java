public class Sorts {
    public static String name(){
	return "06.Luo.Jeffrey";
    }

    /**Selection sort of an int array. 
    *Upon completion, the elements of the array will be in increasing order.
    *@param data  the elements to be sorted.
    */
    public static void selectionSort(int[] data){

	for(int i = 0; i < data.length; i++){
	    int min = data[i];
	    int indexToReplace = i;

	    for(int k = i; k < data.length; k++){
		if(data[k] < min){
		    indexToReplace = k;
		    min = data[k];
		}
	    }

	    int old = data[i];
	    data[i] = min;
	    data[indexToReplace] = old;
	}
    }

    public static void insertionSort(int[] data){
	for(int i = 1; i < data.length; i++){
	    int indexToSet = 0;
	    int prev = data[i];
	    
	    for(int j = i-1; j >= 0; j--){
		if(data[i] > data[j]){
		    indexToSet = j+1;
		    j = -1;
		}
	    }
	    
	    for(int k = i-1; k >= indexToSet; k--){
		data[k+1] = data[k];
	    }

	    data[indexToSet] = prev;
	}
	
    }
    
    public static void main(String[] args){
	int[] data = {100,25,96,-5,13,45,101,5,0};

	insertionSort(data);
	for(int i : data){
	    System.out.println(i);
	}
    }
}
