package LMS;

public class Reader {
    String rcode;
    String name;
    int byear;

    public Reader() {
    }

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        if(byear>1900 && byear<2010){
            this.byear = byear;
        } 
    }

    public String getRcode() {
        return rcode;
    }

    public String getName() {
        return name;
    }

    public int getByear() {
        return byear;
    }
    
    @Override
    public String toString() {
        return this.rcode+" |  "+this.name+"\t"+"|  "+this.byear;
    }
    
}
