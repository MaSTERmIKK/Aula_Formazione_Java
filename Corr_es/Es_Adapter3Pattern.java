// Interfaccia nuova applicazione
interface UserManagement {
    void createUser(String username);
    void deleteUser(String username);
    void findUser(String username);
}

// Sistema legacy
class LegacyUserSystem {
    public void addUser(String user) {
        System.out.println("[Legacy] Aggiunto utente: " + user);
    }

    public void removeUser(String user) {
        System.out.println("[Legacy] Rimosso utente: " + user);
    }

    public void searchUser(String user) {
        System.out.println("[Legacy] Ricerca utente: " + user);
    }
}

// Adapter per interfaccia moderna -> sistema legacy
class UserManagementAdapter implements UserManagement {
    private LegacyUserSystem legacySystem = new LegacyUserSystem();

    public void createUser(String username) {
        legacySystem.addUser(username);
    }

    public void deleteUser(String username) {
        legacySystem.removeUser(username);
    }

    public void findUser(String username) {
        legacySystem.searchUser(username);
    }
}

// Factory per creare UserManagement (può tornare Adapter o altri)
class UserFactory {
    public static UserManagement getUserManager(String tipo) {
        if (tipo.equalsIgnoreCase("legacy")) {
            return new UserManagementAdapter();
        } else {
            System.out.println("Tipo sistema non supportato.");
            return null;
        }
    }
}

// Facade per semplificare interazioni
class UserSystemFacade {
    private UserManagement manager;

    public UserSystemFacade(String tipoSistema) {
        manager = UserFactory.getUserManager(tipoSistema);
    }

    public void registra(String username) {
        if (manager != null) manager.createUser(username);
    }

    public void cancella(String username) {
        if (manager != null) manager.deleteUser(username);
    }

    public void cerca(String username) {
        if (manager != null) manager.findUser(username);
    }
}

// Main demo
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Seleziona tipo sistema (legacy): ");
        String tipo = input.nextLine();

        UserSystemFacade sistema = new UserSystemFacade(tipo);

        System.out.print("Inserisci nome utente da creare: ");
        String nome = input.nextLine();
        sistema.registra(nome);

        System.out.print("Vuoi cercare l'utente? (s/n): ");
        if (input.nextLine().equalsIgnoreCase("s")) {
            sistema.cerca(nome);
        }

        System.out.print("Vuoi eliminare l'utente? (s/n): ");
        if (input.nextLine().equalsIgnoreCase("s")) {
            sistema.cancella(nome);
        }

        input.close();
    }
}
