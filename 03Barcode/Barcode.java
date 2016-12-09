public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private int _checkDigit;

    public Barcode(String zip){
	if(zip.length() != 5 || containsDigits(zip) == false){
	    throw new IllegalArgumentException();
	}

	_zip = zip;
	_checkDigit = checkSum();
    }

    // used for constructor
    private boolean containsDigits(String s){
	for(int i = 0; i < s.length(); i++){
	    if(!(Character.isDigit(s.charAt(i)))){
		return false;
	    }
	}
	return true;
    }
    
    // returns integer sum of digits of string
    private int checkSum(){
	int sum = 0;
	for(int i = 0; i < _zip.length(); i++){
	    sum += Character.getNumericValue(_zip.charAt(i));
	}
	return sum % 10;
    }

    public String toString(){
	String ret = _zip + _checkDigit + "  |" + getCode() + '|';
	return ret;
    }

    // returns string containing bar representation
    private String getCode(){
	String ret = "";
	for(int i = 0; i < _zip.length(); i++){
	    ret += getBars(Integer.parseInt(_zip.substring(i,i+1)));
	}
	ret += getBars(checkSum());
	return ret;
    }

    // returns zip + checkdigit
    public String ZC(){
	return _zip + _checkDigit;
    }

    private String getBars(int input){
	String ret = "";
	switch(input) {
	case 1: ret = ":::||";
	    break;
	case 2: ret = "::|:|";
	    break;
	case 3: ret = "::||:";
	    break;
	case 4: ret = ":|::|";
	    break;
	case 5: ret = ":|:|:";
	    break;
	case 6: ret = ":||::";
	    break;
	case 7: ret = "|:::|";
	    break;
	case 8: ret = "|::|:";
	    break;
	case 9: ret = "|:|::";
	    break;
	case 0: ret = "||:::";
	    break;
	}
	return ret;
    }

    public int compareTo(Barcode other){
        return (this.ZC()).compareTo(other.ZC());
    }

    // test cases
    public static void main(String[] args){
	Barcode a = new Barcode("19283");
	Barcode b = new Barcode("33333");
	
	// Both return errors
	// Barcode d = new Barcode("8392a"); invalid characters
	// Barcode e = new Barcode("12345678"); too long
	// Barcode f = new Barcode("123"); too short
	
	System.out.println(a);
	System.out.println(a.compareTo(b));
	System.out.println(b.compareTo(b));	
    }
}
