package kg.easy.javaspringbootnatv.models.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountsDto {

    private int minDays;
    private double percent;

}
