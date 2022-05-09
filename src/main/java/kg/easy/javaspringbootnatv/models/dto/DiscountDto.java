package kg.easy.javaspringbootnatv.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DiscountDto {

    private Long id;
    private Long channelId;
    private double percent;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date startDate;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date endDate;
    private int minDays;

}
