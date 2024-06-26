public class Singleton {
    private static Singleton singleInstance = null;

    private Singleton() {
        System.out.println("Initialised Singleton object");
    }

    public static Singleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        singleton1.showMessage();
        System.out.println("Hashcode of singleton1 is " + singleton1.hashCode());
        System.out.println("Hashcode of singleton2 is " + singleton2.hashCode());
        if (singleton1 == singleton2){
            System.out.println("Both are one (same)");
        }
    }
}

