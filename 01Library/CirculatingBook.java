public class CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;
    
    public CirculatingBook(String author, String title, String ISBN, String call_number){
	super(author,title,ISBN,call_number);
    }

    public void setCurrentHolder(String currentHolder){
	this.currentHolder = currentHolder;
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public void setDueDate(String dueDate){
	this.dueDate = dueDate;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void checkout(String patron, String due){
	setCurrentHolder(patron);
	setDueDate(due);
    }

    public void returned(){
	setCurrentHolder(null);
	setDueDate(null);
    }
}
