import java.util.Iterator;

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
	return sa.get(count++);
    }

    public void remove(){};
}
