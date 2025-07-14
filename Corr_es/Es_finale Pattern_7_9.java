// INTERFACCIA BASE TESTO
interface Testo {
    String stampa();
}

// TESTO SEMPLICE
class TestoBase implements Testo {
    private String testo;

    public TestoBase(String testo) {
        this.testo = testo;
    }

    @Override
    public String stampa() {
        return testo;
    }
}

// DECORATOR ASTRATTO
abstract class TestoDecorator implements Testo {
    protected Testo testo;

    public TestoDecorator(Testo testo) {
        this.testo = testo;
    }

    public abstract String stampa();
}

// DECORATOR CONCRETI
class GrassettoDecorator extends TestoDecorator {
    public GrassettoDecorator(Testo testo) {
        super(testo);
    }

    @Override
    public String stampa() {
        return "<b>" + testo.stampa() + "</b>";
    }
}

class CorsivoDecorator extends TestoDecorator {
    public CorsivoDecorator(Testo testo) {
        super(testo);
    }

    @Override
    public String stampa() {
        return "<i>" + testo.stampa() + "</i>";
    }
}

// STRATEGY INTERFACCIA
interface Salvataggio {
    void salva(String testo);
}

// STRATEGY CONCRETE
class LocaleSalvataggio implements Salvataggio {
    @Override
    public void salva(String testo) {
        System.out.println("Salvataggio locale: " + testo);
    }
}

class CloudSalvataggio implements Salvataggio {
    @Override
    public void salva(String testo) {
        System.out.println("Salvataggio cloud: " + testo);
    }
}

// MAIN
public class Esercizio7 {
    public static void main(String[] args) {
        Testo testo = new TestoBase("Ciao Mondo");
        testo = new GrassettoDecorator(testo);
        testo = new CorsivoDecorator(testo);

        System.out.println(testo.stampa());

        Salvataggio salva = new CloudSalvataggio();
        salva.salva(testo.stampa());
    }
}


//-------------------------------------------------


// INTERFACCIA BASE ABBONAMENTO
interface Abbonamento {
    String descrizione();
}

// ABBONAMENTO BASE
class AbbonamentoBase implements Abbonamento {
    @Override
    public String descrizione() {
        return "Abbonamento Base";
    }
}

// DECORATOR ASTRATTO
abstract class AbbonamentoDecorator implements Abbonamento {
    protected Abbonamento abbonamento;

    public AbbonamentoDecorator(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public abstract String descrizione();
}

// DECORATOR CONCRETI
class Qualita4KDecorator extends AbbonamentoDecorator {
    public Qualita4KDecorator(Abbonamento abbonamento) {
        super(abbonamento);
    }

    @Override
    public String descrizione() {
        return abbonamento.descrizione() + ", Qualità 4K";
    }
}

class NoPubblicitaDecorator extends AbbonamentoDecorator {
    public NoPubblicitaDecorator(Abbonamento abbonamento) {
        super(abbonamento);
    }

    @Override
    public String descrizione() {
        return abbonamento.descrizione() + ", Senza Pubblicità";
    }
}

// SINGLETON (Gestione stato globale)
class PianoAttivo {
    private static PianoAttivo istanza;
    private Abbonamento abbonamento;

    private PianoAttivo() {
        abbonamento = new AbbonamentoBase();
    }

    public static PianoAttivo getInstance() {
        if (istanza == null) {
            istanza = new PianoAttivo();
        }
        return istanza;
    }

    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public void stampaPiano() {
        System.out.println("Piano attivo: " + abbonamento.descrizione());
    }
}

// MAIN
public class Esercizio9 {
    public static void main(String[] args) {
        PianoAttivo piano = PianoAttivo.getInstance();

        // base
        piano.stampaPiano();

        // aggiunta decoratori
        Abbonamento nuovoPiano = new Qualita4KDecorator(piano.abbonamento);
        nuovoPiano = new NoPubblicitaDecorator(nuovoPiano);

        piano.setAbbonamento(nuovoPiano);
        piano.stampaPiano();
    }
}


