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
    
    public static void main(String[] args){
	int[] data = {64,25,12,22,11,37,99,200,1};

	selectionSort(data);
	for(int i : data){
	    System.out.println(i);
	}
    }
}
