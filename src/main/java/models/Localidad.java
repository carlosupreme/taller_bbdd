package models;

import exceptions.ValidationModelException;

public final class Localidad {

    private long idEntidad;
    private long idMunicipio;
    private long id;
    private String nombre;

    public Localidad(long idEntidad, long idMunicipio, long id, String nombre) throws ValidationModelException {
        setIdEntidad(idEntidad);
        setIdMunicipio(idMunicipio);
        setId(id);
        setNombre(nombre);
    }

    public long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(long idEntidad) {
        Validator.esIdValido(idEntidad);
        this.idEntidad = idEntidad;
    }

    public long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(long idMunicipio) {
        Validator.esIdValido(idMunicipio);
        this.idMunicipio = idMunicipio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) throws ValidationModelException {
        Validator.esIdValido(id);
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ValidationModelException {
        Validator.esNombreValido(nombre);
        this.nombre = nombre;
    }
}
