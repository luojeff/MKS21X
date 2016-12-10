public class Barcode implements Comparable<Barcode> {
    private String _zip;
    private int _checkDigit;

    public Barcode(String zip){
	if(zip.length() != 5 || onlyDigits(zip) == false){
	    throw new IllegalArgumentException();
	}

	_zip = zip;
	_checkDigit = checkSum(_zip);
    }

    // Used for constructor
    private static boolean onlyDigits(String s){
	for(int i = 0; i < s.length(); i++){
	    if(!(Character.isDigit(s.charAt(i)))){
		return false;
	    }
	}
	return true;
    }
    
    // Returns integer sum of digits of string modulo 10
    private static int checkSum(String s){
	int sum = 0;
	for(int i = 0; i < s.length(); i++){
	    sum += Character.getNumericValue(s.charAt(i));
	}
	return sum % 10;
    }

    public static String toZip(String barCode){
	String retZip = "";
	String[] ary = {
	    ":::||","::|:|","::||:",
	    ":|::|",":|:|:",":||::","|:::|",
	    "|::|:","|:|::","||:::"
	};
	
	if(barCode.length() != 32){
	    throw new IllegalArgumentException("Barcode length invalid!");
	} else if (barCode.charAt(0) != '|' || barCode.charAt(barCode.length()-1) != '|'){
	    throw new IllegalArgumentException("Barcode must begin and end with a bar!");
	}

	for(int i = 1; i+5 < barCode.length(); i += 5){
	    retZip += (getIndex(ary, barCode.substring(i,i+5)) + 1) % 10;
	}

	if(retZip.substring(0,5).indexOf('0') != -1){
	    throw new IllegalArgumentException("Invalid sequence. Corresponding numbers not found!");
	} else if (checkSum(retZip.substring(0,5)) != Character.getNumericValue(retZip.charAt(5))){
	    throw new IllegalArgumentException("Checksum doesn't match!");
	}
	
	return retZip.substring(0,5);
    }

    private static int getIndex(String[] ary, String element){
	for(int i = 0; i < ary.length; i++){
	    if(ary[i].equals(element)){
		return i;
	    }
	}
	return -1;
    }

    public String toString(){
	return  _zip + _checkDigit + "  " + getCode();
    }

    public static String toCode(String zip){
	String ret = "";
	int _checkDigit = checkSum(zip);
	String _zip = zip + _checkDigit;

	if(zip.length() != 5 || onlyDigits(zip) == false){
	    throw new IllegalArgumentException("Zip must be five digits and contain only digits");
	}
	
	for(int i = 0; i < _zip.length(); i++){
	    ret += getBars(Integer.parseInt(_zip.substring(i,i+1)));
	}
	return '|' + ret + '|';
    }

    // Returns string containing bar representation
    private String getCode(){
	String ret = "";
	for(int i = 0; i < zipAndCheck().length(); i++){
	    ret += getBars(Integer.parseInt(zipAndCheck().substring(i,i+1)));
	}
	ret += getBars(checkSum(_zip));
	return '|' + ret + '|';
    }

    // Returns zip + checkdigit
    public String zipAndCheck(){
	return _zip + _checkDigit;
    }

    private static String getBars(int input){
	String ret = "";
	switch(input) {
	case 1: ret = ":::||"; break;
	case 2: ret = "::|:|"; break;
	case 3: ret = "::||:"; break;
	case 4: ret = ":|::|"; break;
	case 5: ret = ":|:|:"; break;
	case 6: ret = ":||::"; break;
	case 7: ret = "|:::|"; break;
	case 8: ret = "|::|:"; break;
	case 9: ret = "|:|::"; break;
	case 0: ret = "||:::"; break;
	}
	return ret;
    }

    public int compareTo(Barcode other){
        return (this.zipAndCheck()).compareTo(other.zipAndCheck());
    }

    // test cases
    public static void main(String[] args){
	Barcode a = new Barcode("11111");
	Barcode b = new Barcode("13579");
	Barcode c = new Barcode("38265");
	Barcode d = new Barcode("00230");
	
	// Barcode d = new Barcode("8392a"); invalid characters
	// Barcode e = new Barcode("12345678"); too long
	// Barcode f = new Barcode("123"); too short
	
	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
	System.out.println(d);
	
	System.out.println(a.compareTo(b));
	System.out.println(d.compareTo(c));
	System.out.println(c.compareTo(d));

	System.out.println('\n');
	System.out.println(Barcode.toCode("11111")); // same as b	
	System.out.println(Barcode.toCode("13579"));
	// System.out.println(Barcode.toCode("123a4"));
	
	System.out.println(Barcode.toZip("|:::||:::||:::||:::||:::||:|:|:|"));
	System.out.println(Barcode.toZip("|:::||::|:|::||::|::|:|:|::|:|:|"));
	System.out.println(Barcode.toZip("|:::||::||::|:|:|:::||:|:::|:|:|"));
	// System.out.println(Barcode.toZip("|:::||:::||:::||:::||:::||:::|||")); checksum error
    }
}
