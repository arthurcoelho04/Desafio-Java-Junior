package teste01.testandoSpring.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)

public record ErroResponseDTO(

        int status,
        String mensagem,
        Map<String, String> erros

) { }
