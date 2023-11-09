package models;

import exceptions.ValidationModelException;

public class Validator {

    public static boolean esIdValido(Long id) throws ValidationModelException {
        if (id <= 0) {
            throw new ValidationModelException("El id del producto debe ser positivo");
        }

        return true;
    }

    public static boolean esNombreValido(String nombre) throws ValidationModelException {
        if (nombre.trim().isEmpty()) {
            throw new ValidationModelException("Nombre es un dato obligatorio");
        }
        
        return true;
    }
}
