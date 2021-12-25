package LMS;

public class Lending {
    String bcode;
    String rcode;
    int state;

    public Lending() {
    }

    public Lending(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        if (state>=0 && state<=2){
            this.state = state;
        }     
    }

    public String getBcode() {
        return bcode;
    }

    public String getRcode() {
        return rcode;
    }

    public int getState() {
        return state;
    }

    @Override
    public String toString() {
        return this.bcode+" |  "+this.rcode+" |  "+this.state;
    }
    
}
