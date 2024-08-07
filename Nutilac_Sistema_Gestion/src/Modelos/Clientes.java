package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import Db.Conexion;

/**
 *
 * @author Sergio Rodriguez
 */
public class Clientes {
    
    private Conexion db;
    
    private int IdCliente;
    private String Nombre;
    private int Celular;
    private String Correo;
    private String Direccion;
    private String Barrio;

    public Clientes(int IdCliente, String Nombre, int Celular, String Correo, String Direccion, String Barrio) {
        this.IdCliente = IdCliente;
        this.Nombre = Nombre;
        this.Celular = Celular;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Barrio = Barrio;
    }
    
    public Clientes(String Nombre, int Celular, String Correo, String Direccion, String Barrio) {
        this.Nombre = Nombre;
        this.Celular = Celular;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Barrio = Barrio;
    }
    
public boolean CrearCliente(String Nombre, int Celular, String Correo, String Direccion, String Barrio) {
    try {
        // Obtener la conexión a través del Singleton
        Connection con = db.getInstance().getConnection();

        // Preparar la consulta con PreparedStatement para evitar inyección SQL
        String sql = "INSERT INTO Clientes(Nombre, Celular, Correo, Direccion, Barrio) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Nombre);
        pstmt.setInt(2, Celular);
        pstmt.setString(3, Correo);
        pstmt.setString(4, Direccion);
        pstmt.setString(5, Barrio);

        // Ejecutar la inserción
        int filasAfectadas = pstmt.executeUpdate();

        // Verificar si se insertó correctamente
        if (filasAfectadas > 0) {
            return true; // Retorna true si se insertó al menos una fila
        } else {
            return false; // Retorna false si no se insertó ninguna fila
        }

    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Retorna false en caso de excepción SQL
    }
}

}
