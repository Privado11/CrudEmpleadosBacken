package com.empleados.recursos_humanos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends RuntimeException{
    public RecursoNoEncontradoException() {
    }

    public RecursoNoEncontradoException(String message){
        super(message);
    }

    public RecursoNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecursoNoEncontradoException(Throwable cause) {
        super(cause);
    }

    public RecursoNoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
