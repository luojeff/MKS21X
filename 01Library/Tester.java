public class Tester {
    public static void main(String[] args){
	ReferenceBook a = new ReferenceBook("aut","title","isbn","calln","coll");
	CirculatingBook b = new CirculatingBook("aut2","title2","isbn2","calln2");
	System.out.println(a.toString());
	b.setCurrentHolder("jeff");
	b.setDueDate("11/30/16");
	System.out.println(b.toString());
    }
}
