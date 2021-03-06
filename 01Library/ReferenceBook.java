public class ReferenceBook extends LibraryBook {
    private String collection;

    public ReferenceBook(String author, String title, String ISBN, String call_number, String collect){
	super(author,title,ISBN,call_number);
	setCollection(collect);
    }

    public void setCollection(String collection){
	this.collection = collection;
    }

    public String getCollection(){
	return collection;
    }

    public void checkout(String patron, String due){
	System.out.println(patron + " cannot check out a reference book");
    }

    public void returned(){
	System.out.println("Reference book cannot be checked out");
	throw new UnsupportedOperationException();
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }
    
    public String toString(){
	String ret = "";
	ret += '\n' + super.toString();
	ret += "Collection: " + getCollection() + '\n';
	return ret;
    }
}
