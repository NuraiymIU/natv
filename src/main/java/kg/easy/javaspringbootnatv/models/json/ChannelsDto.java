package kg.easy.javaspringbootnatv.models.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelsDto {

    private Long id;
    private String name;
    private String photo;
    private double price;
    private List<DiscountsDto> discountsDtoList;

    public ChannelsDto(Long id, String name, String photo, double price) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.price = price;
    }

}
