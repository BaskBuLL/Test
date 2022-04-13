package top.baskbull;

public interface Base {

    public void print();

    public void print2();

    default void print3(){
        System.out.println("interface");
    }
}
