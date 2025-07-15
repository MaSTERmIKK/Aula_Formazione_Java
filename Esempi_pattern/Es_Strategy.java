// Interfaccia Strategy
public interface Strategy {
    void execute();
}

// Strategie Concrete
public class ConcreteStrategyA implements Strategy {
    public void execute() {
        System.out.println("Strategia A eseguita.");
    }
}

public class ConcreteStrategyB implements Strategy {
    public void execute() {
        System.out.println("Strategia B eseguita.");
    }
}

// Context
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performTask() {
        strategy.execute();
    }
}

// Uso da parte del Client
Context context = new Context();
context.setStrategy(new ConcreteStrategyA());
context.performTask(); // Output: Strategia A eseguita.
context.setStrategy(new ConcreteStrategyB());
context.performTask(); // Output: Strategia B eseguita.
