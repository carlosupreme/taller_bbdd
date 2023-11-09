package models;

import exceptions.ValidationModelException;

public final class Municipio {

    private long idEntidad;
    private long id;
    private String nombre;
    
    public Municipio(long idEntidad, long id, String nombre) throws ValidationModelException {
        setIdEntidad(idEntidad);
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
