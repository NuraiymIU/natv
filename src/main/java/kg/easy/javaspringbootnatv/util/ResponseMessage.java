package kg.easy.javaspringbootnatv.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResponseMessage<T> {
    private T value;
    private String status;
    private T detail;

    public ResponseMessage<T> prepareSuccessMessage(T value) {
        ResponseMessage<T> successMessage = new ResponseMessage<>();
        successMessage.setValue(value);
        successMessage.setStatus("SUCCESS");
        successMessage.setDetail(null);
        return successMessage;
    }

    public ResponseMessage<T> prepareFailMessage(T detail) {
        ResponseMessage<T> failMessage = new ResponseMessage<>();
        failMessage.setValue(null);
        failMessage.setStatus("FAIL");
        failMessage.setDetail(detail);
        return failMessage;
    }

    public ResponseMessage<T> prepareErrorMessage(T detail) {
        ResponseMessage<T> errorMessage = new ResponseMessage<>();
        errorMessage.setValue(null);
        errorMessage.setStatus("ERROR");
        errorMessage.setDetail(detail);
        return errorMessage;
    }

}
