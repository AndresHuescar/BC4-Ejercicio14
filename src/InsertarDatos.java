import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "RIBERA";
        String password = "ribera";

        String sqlEmpresa = "INSERT INTO EMPRESA (ID, NOMBRE) VALUES (?, ?)";
        String sqlTrabajador = "INSERT INTO TRABAJADOR (ID, NOMBRE, SALARIO, EMPRESA_ID) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement psEmpresa = conn.prepareStatement(sqlEmpresa);
             PreparedStatement psTrabajador = conn.prepareStatement(sqlTrabajador)) {

            //empresa
            psEmpresa.setInt(1, 1);
            psEmpresa.setString(2, "Google");
            psEmpresa.executeUpdate();

            psEmpresa.setInt(1, 2);
            psEmpresa.setString(2, "Amazon");
            psEmpresa.executeUpdate();

            //trabajador
            psTrabajador.setInt(1, 1);
            psTrabajador.setString(2, "Juan");
            psTrabajador.setDouble(3, 1500);
            psTrabajador.setInt(4, 1);
            psTrabajador.executeUpdate();

            psTrabajador.setInt(1, 2);
            psTrabajador.setString(2, "Ana");
            psTrabajador.setDouble(3, 1800);
            psTrabajador.setInt(4, 1);
            psTrabajador.executeUpdate();

            psTrabajador.setInt(1, 3);
            psTrabajador.setString(2, "Luis");
            psTrabajador.setDouble(3, 2000);
            psTrabajador.setInt(4, 2);
            psTrabajador.executeUpdate();

            System.out.println("Datos insertados ");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}