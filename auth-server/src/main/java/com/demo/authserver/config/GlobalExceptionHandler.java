//package com.demo.authserver.config;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//
//import java.util.NoSuchElementException;
//
///**
// * The type Global exception handler.
// */
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<Object> exception(Exception ex) {
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }
//
//    /**
//     * Message not readable response entity.
//     *
//     * @param ex the ex
//     * @return the response entity
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<Object> messageNotReadable(HttpMessageNotReadableException ex) {
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }
//
//
//    /**
//     * Method argument type mismatch response entity.
//     *
//     * @param ex the ex
//     * @return the response entity
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<Object> methodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }
//
//
//    /**
//     * No such element response entity.
//     *
//     * @param ex the ex
//     * @return the response entity
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<Object> noSuchElement(NoSuchElementException ex) {
//       return ResponseEntity.badRequest().body(ex.getMessage());
//    }
//
//    /**
//     * Handle invalid argument response entity.
//     *
//     * @param ex the ex
//     * @return the response entity
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleInvalidArgument(MethodArgumentNotValidException ex) {
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }
//
//
//}
