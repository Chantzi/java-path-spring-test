package gr.codelearn.java.path.spring.test.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
//@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {
    String transactionId = UUID.randomUUID().toString().toUpperCase();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    LocalDateTime createdAt = LocalDateTime.now();

    T data;

    gr.codelearn.java.path.spring.test.transfer.ApiError apiError;
}
