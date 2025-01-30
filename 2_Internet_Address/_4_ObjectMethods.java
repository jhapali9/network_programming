public class _4_ObjectMethods {
    String name;
    int id;
    _4_ObjectMethods(String name,int id){
        this.name = name;
        this.id = id;
    }
    @Override
    public boolean equals(Object obj){
        _4_ObjectMethods o = (_4_ObjectMethods)obj;
        return id == o.id && name == o.name;
    }

    @Override
    public String toString(){
        return "Name = " + this.name + "\nId = " + this.id;
    }
    
    public static void main(String[] args) {
        _4_ObjectMethods one = new _4_ObjectMethods("Object One",123);
        _4_ObjectMethods two = new _4_ObjectMethods("Object One",123);
        System.out.println(one.equals(two));
        System.out.println(one.hashCode());
        System.out.println(one.toString());
    }
}
