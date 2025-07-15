// INTERFACCIA STRATEGY PER COLORE
interface ColorStrategy {
    void applyColor();
}

class RedColor implements ColorStrategy {
    public void applyColor() {
        System.out.println("Colore applicato: Rosso");
    }
}

class BlueColor implements ColorStrategy {
    public void applyColor() {
        System.out.println("Colore applicato: Blu");
    }
}

// INTERFACCIA SHAPE
interface IShape {
    void draw();
    void setColorStrategy(ColorStrategy cs);
}

// CLASSI CONCRETE
class Circle implements IShape {
    private ColorStrategy colorStrategy;

    public void draw() {
        System.out.println("Disegno: Cerchio");
        if (colorStrategy != null) colorStrategy.applyColor();
    }

    public void setColorStrategy(ColorStrategy cs) {
        this.colorStrategy = cs;
    }
}

class Square implements IShape {
    private ColorStrategy colorStrategy;

    public void draw() {
        System.out.println("Disegno: Quadrato");
        if (colorStrategy != null) colorStrategy.applyColor();
    }

    public void setColorStrategy(ColorStrategy cs) {
        this.colorStrategy = cs;
    }
}

// FACTORY METHOD: CREATORE ASTRATTO
abstract class ShapeCreator {
    public abstract IShape createShape(String type);
}

// CREATORE CONCRETO
class ConcreteShapeCreator extends ShapeCreator {
    public IShape createShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("square")) {
            return new Square();
        } else {
            System.out.println("Tipo non riconosciuto.");
            return null;
        }
    }
}

// FACADE
class DrawingFacade {
    private ShapeCreator creator = new ConcreteShapeCreator();

    public void disegnaForma(String tipoForma, String colore) {
        IShape shape = creator.createShape(tipoForma);
        if (shape == null) return;

        // Strategy: applicazione colore
        if (colore.equalsIgnoreCase("rosso")) {
            shape.setColorStrategy(new RedColor());
        } else if (colore.equalsIgnoreCase("blu")) {
            shape.setColorStrategy(new BlueColor());
        } else {
            System.out.println("Colore non riconosciuto. Nessun colore applicato.");
        }

        shape.draw();
    }
}

// MAIN
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DrawingFacade facade = new DrawingFacade();

        System.out.print("Inserisci la forma (circle / square): ");
        String forma = input.nextLine();

        System.out.print("Inserisci il colore (rosso / blu): ");
        String colore = input.nextLine();

        facade.disegnaForma(forma, colore);
        input.close();
    }
}
