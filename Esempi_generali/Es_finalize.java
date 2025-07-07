public class MyClass {
    private String data;

    public MyClass(String data) {
        this.data = data;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Oggetto " + this + " in fase di garbage collection.");
        super.finalize();
    }

    public static void main(String[] args) {
        MyClass obj1 = new MyClass("Oggetto 1");
        MyClass obj2 = new MyClass("Oggetto 2");

        // Rimuoviamo i riferimenti
        obj1 = null;
        obj2 = null;

        // Chiamiamo il garbage collector (non garantito che venga chiamato immediatamente)
        System.gc(); // Suggerisce al garbage collector di eseguire la pulizia
    }
}
