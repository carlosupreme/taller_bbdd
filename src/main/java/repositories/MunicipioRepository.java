package repositories;

import app.MySQLConnection;
import exceptions.ValidationModelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Municipio;

public class MunicipioRepository {

    private final Connection connection;

    public MunicipioRepository() {
        this.connection = MySQLConnection.getInstance().getConnection();
    }

    public void save(Municipio municipio) throws SQLException, ValidationModelException {
        PreparedStatement st = connection.prepareStatement("INSERT INTO municipios (identidad, idmunicipio, nom_municipio) VALUES (?, ?, ?)");
        st.setLong(1, municipio.getIdEntidad());
        st.setLong(2, municipio.getId());
        st.setString(3, municipio.getNombre());

        st.executeUpdate();
    }

    public List<Municipio> findAll(long identidad) throws SQLException, ValidationModelException {
        List<Municipio> all = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM municipios WHERE identidad = ?");
        st.setLong(1, identidad);
        ResultSet rs = st.executeQuery();   

        while (rs.next()) {
            all.add(new Municipio(rs.getLong("identidad"), rs.getLong("idmunicipio"), rs.getString("nom_municipio")));
        }

        return all;
    }

    public Municipio findById(long identidad, long idmunicipio) throws SQLException, ValidationModelException {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM municipios WHERE identidad = ? AND idmunicipio = ? LIMIT 1");
        st.setLong(1, identidad);
        st.setLong(2, idmunicipio);
        ResultSet rs = st.executeQuery();

        if (!rs.next()) {
            return null;
        }

        return new Municipio(rs.getLong("identidad"), rs.getLong("idmunicipio"), rs.getString("nom_municipio"));
    }

    public void update(long identidad, long idmunicipio, Municipio municipio) throws SQLException {
        PreparedStatement st = connection.prepareStatement("UPDATE municipios SET identidad = ?, idmunicipio = ?, nom_municipio = ? WHERE identidad = ? and idmunicipio = ? LIMIT 1");
        st.setLong(1, municipio.getIdEntidad());
        st.setLong(2, municipio.getId());
        st.setString(3, municipio.getNombre());
        st.setLong(4, identidad);
        st.setLong(5, idmunicipio);

        st.executeUpdate();
    }

    public void delete(long identidad, long idmunicipio) throws SQLException {
        PreparedStatement st = connection.prepareStatement("DELETE FROM municipios WHERE identidad = ? AND idmunicipio = ? LIMIT 1");
        st.setLong(1, identidad);
        st.setLong(2, idmunicipio);
        st.executeUpdate();
    }
}
