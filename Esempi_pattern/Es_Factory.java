// 1. Product: definisce l'interfaccia del prodotto
public interface Product {
    void operation();
}

// 2. ConcreteProductA: implementa Product
public class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("Esecuzione di ConcreteProductA.operation()");
    }
}

// 3. ConcreteProductB: un altro prodotto concreto
public class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("Esecuzione di ConcreteProductB.operation()");
    }
}

// 4. Creator: dichiara il Factory Method
public abstract class Creator {
    // Factory Method: restituisce un Product
    public abstract Product factoryMethod();

    // Un metodo del creator che utilizza il prodotto
    public void anOperation() {
        Product product = factoryMethod();  // creazione del prodotto
        product.operation();                // uso del prodotto
    }
}

// 5. ConcreteCreatorA: implementa factoryMethod per ConcreteProductA
public class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

// 6. ConcreteCreatorB: implementa factoryMethod per ConcreteProductB
public class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// 7. Client / esempio di utilizzo
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        creatorA.anOperation();  // Usa ConcreteProductA

        Creator creatorB = new ConcreteCreatorB();
        creatorB.anOperation();  // Usa ConcreteProductB
    }
}
