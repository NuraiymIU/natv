package kg.easy.javaspringbootnatv.service;

import kg.easy.javaspringbootnatv.models.dto.PriceDto;
import kg.easy.javaspringbootnatv.models.json.ChannelsDto;

import java.util.List;

public interface PriceService {

    PriceDto savePrice(PriceDto priceDto);

    List<ChannelsDto> findChannelsWithPrice();

}
