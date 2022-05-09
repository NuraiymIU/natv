package kg.easy.javaspringbootnatv.models.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelResultSet {

    private Long id;
    private String name;
    private String photo;
    private double price;
    private int minDays;
    private double percent;

}

