// Interfaccia Component
public interface Component {
    void operation();
}

// Componente Concreto
public class ConcreteComponent implements Component {
    public void operation() {
        System.out.println("Operazione base");
    }
}

// Decorator astratto
public abstract class Decorator implements Component {
    protected Component component;
    
    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

// Decoratore Concreto
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}

