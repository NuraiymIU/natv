package kg.easy.javaspringbootnatv.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.easy.javaspringbootnatv.enums.OrderStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {

    private Long id;
    private String text;
    private String name;
    private String phone;
    private String email;
    private double totalPrice;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date editDate;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date addDate;
    private OrderStatus status;

}
