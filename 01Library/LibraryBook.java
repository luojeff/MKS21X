public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String call_number;

    public LibraryBook(String author, String title, String ISBN, String call_n){
	super(author,title,ISBN);
        setCallNumber(call_n);
    }
    
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();

    public int compareTo(LibraryBook lb){
	return call_number.compareTo(lb.call_number);
    }

    public String toString(){
	String ret = "";
	ret += super.toString();
	ret += circulationStatus() + '\n';
	return ret;
    }

    public void setCallNumber(String call_number){
	this.call_number = call_number;
    }

    public String getCallNumber(){
	return call_number;
    }
}
