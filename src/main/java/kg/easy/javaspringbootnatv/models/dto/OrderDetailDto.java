package kg.easy.javaspringbootnatv.models.dto;

import lombok.Data;

@Data
public class OrderDetailDto {

    private Long id;
    private Long channelId;
    private Long orderId;
    private double price;

}
