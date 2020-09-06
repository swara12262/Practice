class GenericMethod{

    static <T> void myMethod(T val){
        System.out.println(val.getClass().getName()+val);
    }
    public static void main(String[] args){
        myMethod(123);
        myMethod("Swara");
        myMethod(12.34);
    }
}