public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private int _checkDigit;

    public Barcode(String zip){
	if(zip.length() == 5){
	    _zip = zip;
	    // add check for nondigit arguments
	} else {
	    throw new IllegalArgumentException();
	}
    }

    public Barcode clone(){
	return new Barcode(_zip);
    }

    private int checkSum(){
	int sum = 0;
	for(int i = 0; i < _zip.length(); i++){
	    sum += Character.getNumericValue(_zip.charAt(i));
	}
	return sum % 10;
    }

    public String toString(){
	String ret = _zip + checkSum() + ':' + getCode();
    }

    public String getCode(

    public String getBars(int input){
	switch(input) {
	case 1: return ":::||";
	case 2: return "::|:|"; 
	}
    }

    public int compareTo(Barcode other){
	return -1;
    }
}
