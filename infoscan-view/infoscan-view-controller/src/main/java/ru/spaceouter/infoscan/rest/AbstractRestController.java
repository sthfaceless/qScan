package ru.spaceouter.infoscan.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author danil
 * @date 20.04.19
 */
public abstract class AbstractRestController {

    protected ResponseEntity<?> ok(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected ResponseEntity<?> created(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    protected ResponseEntity<?> accepted(){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    protected <T> ResponseEntity<T>  found(T obj){
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    protected ResponseEntity<?> badRequest(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<?> nonAuthorized(){
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    protected ResponseEntity<?> accessDenied(){
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    protected ResponseEntity<?> notFound(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<?> serverError(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
