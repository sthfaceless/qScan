package ru.spaceouter.infoscan.rest;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> unexpectedServerException(Exception exception){

        exception.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(){

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> unauthorizedException(){

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(WrongArgumentsException.class)
    public ResponseEntity<?> wrongArgumentException(){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> accessDeniedException(){

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
