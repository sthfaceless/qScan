package ru.spaceouter.infoscan.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.spaceouter.infoscan.exceptions.*;

/**
 * @author danil
 * @date 20.04.19
 */
@RestControllerAdvice
public class DefaultExceptionHandler extends AbstractRestController{

    @ExceptionHandler({UnexpectedServerException.class, Exception.class})
    public ResponseEntity<?> unexpectedServerException(){
       return serverError();
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(){
        return notFound();
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> unauthorizedException(){
        return nonAuthorized();
    }

    @ExceptionHandler(WrongArgumentsException.class)
    public ResponseEntity<?> wrongArgumentException(){
        return badRequest();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> accessDeniedException(){
        return accessDenied();
    }

}
