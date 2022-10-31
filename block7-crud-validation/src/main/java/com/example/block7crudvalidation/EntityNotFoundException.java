package com.example.block7crudvalidation;

import java.util.Calendar;

public class EntityNotFoundException extends Exception {
    public CustomError EntityNotFoundException(String errorMessage) {
        CustomError customError = new CustomError(Calendar.getInstance().getTime(), 404, "El registro solicitado no existe");
        return customError;
    }
}
