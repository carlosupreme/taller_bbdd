package repositories;

import app.MySQLConnection;
import exceptions.ValidationModelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Entidad;

public class EntidadRepository {

    private final Connection connection;

    public EntidadRepository() {
        this.connection = MySQLConnection.getInstance().getConnection();
    }

    public void save(Entidad entidad) throws SQLException, ValidationModelException {
        PreparedStatement st = connection.prepareStatement("INSERT INTO entidades VALUES (?, ?)");
        st.setLong(1, entidad.getId());
        st.setString(2, entidad.getNombre());

        st.executeUpdate();
        
    }

    public List<Entidad> findAll() throws SQLException, ValidationModelException {
        List<Entidad> all = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM entidades");

        while (rs.next()) {
            all.add(new Entidad(rs.getLong("identidad"), rs.getString("nom_entidad")));
        }

        return all;
    }

    public Entidad findById(long id) throws SQLException, ValidationModelException {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM entidades WHERE identidad = ? LIMIT 1");
        st.setLong(1, id);
        ResultSet rs = st.executeQuery();

        if (!rs.next()) {
            return null;
        }

        return new Entidad(rs.getLong("identidad"), rs.getString("nom_entidad"));
    }

    public void update(long id, Entidad entidad) throws SQLException {
        PreparedStatement st = connection.prepareStatement("UPDATE entidades SET identidad = ?, nom_entidad = ? WHERE identidad = ? LIMIT 1");
        st.setLong(1, entidad.getId());
        st.setString(2, entidad.getNombre());
        st.setLong(3, id);
        
        st.executeUpdate();
    }

    public void delete(long id) throws SQLException {
        PreparedStatement st = connection.prepareStatement("DELETE FROM entidades WHERE identidad = ? LIMIT 1");
        st.setLong(1, id);
        st.executeUpdate();
    }
}
