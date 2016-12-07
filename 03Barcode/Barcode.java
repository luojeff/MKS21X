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
	String ret = _zip + checkSum() + "  |" + getCode() + '|';
	return ret;
    }

    private String getCode(){
	String ret = "";
	for(int i = 0; i < _zip.length(); i++){
	    ret += getBars(Integer.parseInt(_zip.substring(i,i+1)));
	}
	return ret;
    }

    // returns zip + checksum
    public String ZC(){
	return _zip + checkSum();
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
	case 0: ret = "||:::|";
	    break;
	}
	return ret;
    }

    public int compareTo(Barcode other){
        return Integer.parseInt(this.ZC()) - Integer.parseInt(other.ZC());
    }

    public static void main(String[] args){
	Barcode a = new Barcode("11111");
	Barcode b = new Barcode("12345");
	System.out.println(a);
	System.out.println(a.compareTo(b));
    }
}
