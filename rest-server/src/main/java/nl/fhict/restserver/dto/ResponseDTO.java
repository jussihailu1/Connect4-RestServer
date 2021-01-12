package nl.fhict.restserver.dto;

import lombok.Getter;
import nl.fhict.restserver.enums.Response;
import org.springframework.http.ResponseEntity;


public class ResponseDTO {

    @Getter
    private String message;

    @Getter
    private Object content;

    public ResponseDTO(Response response) {
        this.message = response.toString();
    }

    public ResponseDTO(Response response, Object object) {
        this.message = response.toString();
        this.content = object;
    }

    public static ResponseEntity<ResponseDTO> send(Response response) {
        return ResponseEntity.ok(new ResponseDTO(response));
    }

    public static ResponseEntity<ResponseDTO> success() {
        return ResponseEntity.ok(new ResponseDTO(Response.SUCCES));
    }

    public static ResponseEntity<ResponseDTO> success(Object object) {
        return ResponseEntity.ok(new ResponseDTO(Response.SUCCES, object));
    }

    public static ResponseEntity<ResponseDTO> error() {
        return ResponseEntity.ok(new ResponseDTO(Response.SERVER_ERROR));
    }
}
