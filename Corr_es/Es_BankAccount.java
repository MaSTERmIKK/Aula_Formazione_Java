import java.util.Random;

public class BankAccount {
    // Variabili di istanza
    private String accountHolderName;
    private double balance;

    // Costruttore
    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        // Saldo iniziale random tra 0 e 1000
        this.balance = new Random().nextDouble() * 1000;
    }

    // Metodo per effettuare un deposito
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposito di " + amount + " effettuato.");
        } else {
            System.out.println("Importo non valido per il deposito.");
        }
    }

    // Metodo per effettuare un prelievo
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Prelievo di " + amount + " effettuato.");
        } else {
            System.out.println("Prelievo non possibile. Fondi insufficienti o importo non valido.");
        }
    }

    // Metodo per visualizzare il saldo
    public void displayBalance() {
        System.out.println("Saldo attuale: " + balance);
    }

    // Main di esempio
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Mario Rossi");
        account.displayBalance();
        account.deposit(250.0);
        account.withdraw(100.0);
        account.displayBalance();
    }
}
