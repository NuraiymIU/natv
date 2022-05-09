package kg.easy.javaspringbootnatv.service;

import kg.easy.javaspringbootnatv.models.dto.DiscountDto;
import kg.easy.javaspringbootnatv.models.json.DiscountsDto;

import java.util.List;

public interface DiscountService {

    List<DiscountsDto> findDiscountsByChannelId(Long channelId);

    DiscountDto saveDiscount(DiscountDto discountDto);

}
