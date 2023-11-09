package repositories;

import app.MySQLConnection;
import exceptions.ValidationModelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Localidad;

public class LocalidadRepository {

    private final Connection connection;

    public LocalidadRepository() {
        this.connection = MySQLConnection.getInstance().getConnection();
    }

    public void save(Localidad localidad) throws SQLException, ValidationModelException {
        PreparedStatement st = connection.prepareStatement("INSERT INTO localidades (identidad, idmunicipio, idlocalidad, nom_localidad) VALUES (?, ?, ?, ?)");
        st.setLong(1, localidad.getIdEntidad());
        st.setLong(2, localidad.getIdMunicipio());
        st.setLong(3, localidad.getId());
        st.setString(4, localidad.getNombre());

        st.executeUpdate();
    }

    public List<Localidad> findAll(long identidad, long idMunicipio) throws SQLException, ValidationModelException {
        List<Localidad> all = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM localidades WHERE identidad = ? AND idmunicipio = ?");
        st.setLong(1, identidad);
        st.setLong(2, idMunicipio);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            all.add(new Localidad(rs.getLong("identidad"), rs.getLong("idmunicipio"), rs.getLong("idlocalidad"), rs.getString("nom_localidad")));
        }

        return all;
    }

    public Localidad findById(long identidad, long idmunicipio, long id) throws SQLException, ValidationModelException {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM localidades WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ? LIMIT 1");
        st.setLong(1, identidad);
        st.setLong(2, idmunicipio);
        st.setLong(3, id);
        ResultSet rs = st.executeQuery();

        if (!rs.next()) {
            return null;
        }

        return new Localidad(rs.getLong("identidad"), rs.getLong("idmunicipio"), rs.getLong("idlocalidad"), rs.getString("nom_localidad"));
    }

    public void update(long identidad, long idmunicipio, long id, Localidad localidad) throws SQLException {
        PreparedStatement st = connection.prepareStatement("UPDATE localidades SET identidad = ?, idmunicipio = ?, idlocalidad = ?, nom_localidad = ? WHERE identidad = ? and idmunicipio = ? AND idlocalidad = ? LIMIT 1");
        st.setLong(1, localidad.getIdEntidad());
        st.setLong(2, localidad.getIdMunicipio());
        st.setLong(3, localidad.getId());
        st.setString(4, localidad.getNombre());
        st.setLong(5, identidad);
        st.setLong(6, idmunicipio);
        st.setLong(7, id);

        st.executeUpdate();
    }

    public void delete(long identidad, long idmunicipio, long id) throws SQLException {
        PreparedStatement st = connection.prepareStatement("DELETE FROM localidades WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ? LIMIT 1");
        st.setLong(1, identidad);
        st.setLong(2, idmunicipio);
        st.setLong(3, id);
        st.executeUpdate();
    }
}
