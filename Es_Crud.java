import java.sql.*;

public class JdbcCrudBase {
    static final String URL = "jdbc:mysql://localhost:3306/miodatabase";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        // CREATE
        insertUtente("Mario Rossi", "mario@example.com");

        // READ
        readUtenti();

        // UPDATE
        updateUtente(1, "Mario Bianchi");

        // DELETE
        deleteUtente(1);
    }

    // CREATE
    public static void insertUtente(String nome, String email) {
        String sql = "INSERT INTO utenti (nome, email) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Utente inserito.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void readUtenti() {
        String sql = "SELECT * FROM utenti";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Nome: " + rs.getString("nome") +
                                   ", Email: " + rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateUtente(int id, String nuovoNome) {
        String sql = "UPDATE utenti SET nome = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuovoNome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Utente aggiornato.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteUtente(int id) {
        String sql = "DELETE FROM utenti WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Utente eliminato.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
