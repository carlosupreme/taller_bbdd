package models;

import exceptions.ValidationModelException;

public final class Entidad {

    private long id;
    private String nombre;

    public Entidad() {
    }

    public Entidad(long id, String nombre) throws ValidationModelException {
        setId(id);
        setNombre(nombre);
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
