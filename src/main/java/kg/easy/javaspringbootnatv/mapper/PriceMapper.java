package kg.easy.javaspringbootnatv.mapper;

import kg.easy.javaspringbootnatv.dao.ChannelRepo;
import kg.easy.javaspringbootnatv.exceptions.NotFoundException;
import kg.easy.javaspringbootnatv.models.dto.PriceDto;
import kg.easy.javaspringbootnatv.models.entity.Channel;
import kg.easy.javaspringbootnatv.models.entity.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    private final ChannelRepo channelRepo;

    public PriceMapper(ChannelRepo channelRepo) {
        this.channelRepo = channelRepo;
    }

    public Price toEntity(PriceDto priceDto) {
        Price price = new Price();
        Channel channel = channelRepo.findById(priceDto.getChannelId())
                .orElseThrow(() -> new NotFoundException("Канал не существует!"));
        price.setChannel(channel);
        price.setStartDate(priceDto.getStartDate());
        price.setEndDate(priceDto.getEndDate());
        price.setPrice(priceDto.getPrice());
        return price;
    }

    public PriceDto toDto(Price price) {
        PriceDto priceDto = new PriceDto();
        priceDto.setId(price.getId());
        priceDto.setChannelId(price.getChannel().getId());
        priceDto.setStartDate(price.getStartDate());
        priceDto.setEndDate(price.getEndDate());
        priceDto.setPrice(price.getPrice());
        return priceDto;
    }

}
