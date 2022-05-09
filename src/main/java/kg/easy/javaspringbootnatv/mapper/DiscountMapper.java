package kg.easy.javaspringbootnatv.mapper;

import kg.easy.javaspringbootnatv.dao.ChannelRepo;
import kg.easy.javaspringbootnatv.exceptions.NotFoundException;
import kg.easy.javaspringbootnatv.models.dto.DiscountDto;
import kg.easy.javaspringbootnatv.models.entity.Channel;
import kg.easy.javaspringbootnatv.models.entity.Discount;
import org.springframework.stereotype.Component;

@Component
public class DiscountMapper {

    private final ChannelRepo channelRepo;

    public DiscountMapper(ChannelRepo channelRepo) {
        this.channelRepo = channelRepo;
    }

    public Discount toEntity(DiscountDto discountDto) {
        Discount discount = new Discount();
        Channel channel = channelRepo.findById(discountDto.getChannelId())
                .orElseThrow(() -> new NotFoundException("Канал не существует!"));
        discount.setChannel(channel);
        discount.setStartDate(discountDto.getStartDate());
        discount.setEndDate(discountDto.getEndDate());
        discount.setPercent(discountDto.getPercent());
        discount.setMinDays(discountDto.getMinDays());
        return discount;
    }

    public DiscountDto toDto(Discount discount) {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setId(discount.getId());
        discountDto.setChannelId(discount.getChannel().getId());
        discountDto.setStartDate(discount.getStartDate());
        discountDto.setEndDate(discount.getEndDate());
        discountDto.setPercent(discount.getPercent());
        discountDto.setMinDays(discount.getMinDays());
        return discountDto;
    }

}
