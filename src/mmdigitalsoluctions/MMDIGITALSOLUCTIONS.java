package mmdigitalsoluctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MMDIGITALSOLUCTIONS {
    public static void main(String[] args) {
       
     
       // Eletronico inspiror = new Computador("PC Gamer", "Dell", 2000.0, true, true);
       // Eletronico thinkpad = new Computador("PC Gamer", "Lenovo", 2000.0, true, true);
        Smartphone galaxy = new Smartphone("Smartphone Pro", "Samsung", 1500.0, 8192, 128);
        Smartphone redmi = new Smartphone("Smartphone Pro", "Xiaomi", 1500.0, 8192, 128);

   
        List<Electronico> electronicos = new ArrayList<>();

        
        //electronicos.add(inspiror);
       // electronicos.add(thinkpad);
        electronicos.add(galaxy);
        electronicos.add(redmi);
        
        

        
        for (Electronico e : electronicos) {
            e.calcularPrecoFinal();
        }

       
        for (Electronico e : electronicos) {
            e.imprimirDados();
        }
    }
    
    
    private static void gravarObjeto(Connection conn, Electronico electronico) throws SQLException {
        String sql = "INSERT INTO Electronico (nome, marca, preco, tipo, atributos_especificos) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, electronico.getNome());
            pstmt.setString(2, electronico.getMarca());
            pstmt.setDouble(3, electronico.getPreco());

           
           

      
            pstmt.executeUpdate();
        }
    }
}
