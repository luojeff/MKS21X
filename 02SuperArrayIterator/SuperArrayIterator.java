import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArrayIterator implements Iterator<String> {
    public int count;
    public SuperArray sa;
    
    public SuperArrayIterator(SuperArray sa){
	this.sa = sa;
    }

    public boolean hasNext(){
        return count < sa.size();
    }

    public String next(){
        if(hasNext()){
	    return sa.get(count);
	} else {
	    throw new NoSuchElementException();
	}
    }

    public void remove(){};
}
