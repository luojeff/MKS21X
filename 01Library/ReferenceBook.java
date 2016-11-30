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
    }
}
