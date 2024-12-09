package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {

    private static final String URL = "jdbc:oracle:thin:@//localhost:1522/ooc";  // Cambia la URL si es necesario
    private static final String USUARIO = "EVAL_IDIOMAS";  // Tu usuario
    private static final String CONTRASENA = "EI2024";  // Tu contraseña
    private static Connection con;

    /**
     * Establece la conexión a la base de datos.
     * @return Connection: la conexión a la base de datos.
     * @throws SQLException si ocurre un error al conectar.
     */
    public static Connection conectar() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a Oracle");

        }
        return con;
    }
    
    /**
     * Realiza un commit de la transacción actual.
     * Esto es útil si no tienes autocommit habilitado y deseas confirmar tus cambios manualmente.
     */
    public static void commit() {
        try {
            if (con != null && !con.isClosed()) {
                con.commit();
                System.out.println("Commit realizado exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al hacer commit: " + e.getMessage());
        }
    }
    
    
    /**
     * Realiza un rollback de la transacción actual.
     * Esto puede ser útil en caso de que desees deshacer los cambios.
     */
    public static void rollback() {
        try {
            if (con != null && !con.isClosed()) {
                con.rollback();
                System.out.println("Rollback realizado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al hacer rollback: " + e.getMessage());
        }
    }
    
    /**
     * Cierra la conexión con la base de datos.
     */
    public static void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
