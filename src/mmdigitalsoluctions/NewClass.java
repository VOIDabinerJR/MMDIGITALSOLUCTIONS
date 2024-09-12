import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MMDIGITALSOLUCTIONS {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sua_base_de_dados";
    private static final String USER = "root";
    private static final String PASS = "sua_senha";

    public static void main(String[] args) {
        // Criando os objetos
        Computador inspiror = new Computador("PC Gamer", "Dell", 2000.0, true, true);
        Smartphone galaxy = new Smartphone("Smartphone Pro", "Samsung", 1500.0, 8192, 128);

        // Gravando os objetos na base de dados
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Inserindo o Computador
            gravarObjeto(conn, inspiror);
            
            // Inserindo o Smartphone
            gravarObjeto(conn, galaxy);

            System.out.println("Objetos gravados na base de dados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para gravar o objeto na base de dados
    private static void gravarObjeto(Connection conn, Electronico electronico) throws SQLException {
        String sql = "INSERT INTO Electronico (nome, marca, preco, tipo, atributos_especificos) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, electronico.getNome());
            pstmt.setString(2, electronico.getMarca());
            pstmt.setDouble(3, electronico.getPreco());

            // Identificar o tipo de objeto (Computador ou Smartphone) e setar os atributos específicos
            if (electronico instanceof Computador) {
                Computador comp = (Computador) electronico;
                pstmt.setString(4, "Computador");
                pstmt.setString(5, "Gamer: " + comp.isGamer() + ", Status: " + comp.isStatus());
            } else if (electronico instanceof Smartphone) {
                Smartphone phone = (Smartphone) electronico;
                pstmt.setString(4, "Smartphone");
                pstmt.setString(5, "Memoria RAM: " + phone.getMemoriaRAM() + "MB, Armazenamento: " + phone.getArmazenamento() + "GB");
            }

            // Executa a inserção no banco de dados
            pstmt.executeUpdate();
        }
    }
}
