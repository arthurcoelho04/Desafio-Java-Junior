package teste01.testandoSpring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import teste01.testandoSpring.DTOs.ErroResponseDTO;
import teste01.testandoSpring.infrastructure.exception.ConflictException;
import teste01.testandoSpring.infrastructure.exception.ResourceNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 400 - Dados inválidos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(erro ->
                erros.put(erro.getField(), erro.getDefaultMessage()));

        ErroResponseDTO resposta = new ErroResponseDTO(
                400,
                "Erro de validação",
                erros
        );

        return ResponseEntity.badRequest().body(resposta);
    }


    // 400 - JSON inválido
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponseDTO> handleJsonInvalido(
            HttpMessageNotReadableException ex) {

        ErroResponseDTO resposta = new ErroResponseDTO(
                400,
                "JSON inválido. Verifique a estrutura e os valores enviados.",
                null
        );

        return ResponseEntity.badRequest().body(resposta);
    }


    // 404 - Produto não encontrado
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErroResponseDTO resposta = new ErroResponseDTO(
                404,
                ex.getMessage(),
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }



    // 409 - Produto já cadastrado
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErroResponseDTO> handleConflictException(
            ConflictException ex) {

        ErroResponseDTO resposta = new ErroResponseDTO(
                409,
                ex.getMessage(),
                null
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(resposta);
    }

}