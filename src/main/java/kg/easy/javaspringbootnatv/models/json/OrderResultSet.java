package kg.easy.javaspringbootnatv.models.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResultSet {

    private String text;
    private String name;
    private String phone;
    private String email;
    private double totalPrice;
    private List<OrderChannelDto> channels;

}
