package kg.easy.javaspringbootnatv.models.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderChannelDto {

    private Long channelId;
    private double price;
    private List<String> days;

}