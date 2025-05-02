package DesignPatterns;

public class SingletonPattern {

    private static SingletonPattern obj;

    private static SingletonPattern obj1 = new SingletonPattern();

    private volatile static SingletonPattern obj2;

    // private constructor to force use of
    // getInstance() to create Singleton object
    private SingletonPattern() {
    }

    // the method is that it is not thread safe if we use 2 thread
    //This is called lazy instantiation.
    public static SingletonPattern getInstance() {
        if (obj == null)
            obj = new SingletonPattern();
        return obj;
    }

    //using synchronized makes sure that only one thread at a time can execute getInstance()
    //expensive and may decrease the performance of your program when using synchronized every time while creating the singleton objec
    public static synchronized SingletonPattern getInstance1() {
        if (obj == null)
            obj = new SingletonPattern();
        return obj;
    }

    //Eager Instantiation
    //Use this method only when your singleton class is light and is used throughout the execution of your program.
    public static SingletonPattern getInstance2() {
        return obj1;
    }

    //Use “Double Checked Locking”
    public static SingletonPattern getInstance3() {
        if (obj2 == null) {
            // To make thread safe
            synchronized (SingletonPattern.class) {
                // check again as multiple threads
                // can reach above step
                if (obj == null)
                    obj = new SingletonPattern();
            }
        }
        return obj;
    }

    // Inner class to provide instance of class
    private static class BillPughSingleton {
        private static final SingletonPattern instance = new SingletonPattern();
    }

    public static SingletonPattern getInstance4() {
        return BillPughSingleton.instance;
    }

}
