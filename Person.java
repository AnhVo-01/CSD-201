public class Person {
    String name;
    int age;

    public Person() {
    }
    
    public Person(String xName, int xAge) {
        name = xName;
        age = xAge;
    }

    @Override
    public String toString() {
        return ("("+name+", "+age+") "); //(B,20)
    }
    
}
