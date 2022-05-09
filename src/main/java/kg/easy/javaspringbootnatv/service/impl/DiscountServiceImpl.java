package kg.easy.javaspringbootnatv.service.impl;

import kg.easy.javaspringbootnatv.dao.DiscountRepo;
import kg.easy.javaspringbootnatv.mapper.DiscountMapper;
import kg.easy.javaspringbootnatv.models.dto.DiscountDto;
import kg.easy.javaspringbootnatv.models.json.DiscountsDto;
import kg.easy.javaspringbootnatv.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepo discountRepo;
    private final DiscountMapper discountMapper;

    public DiscountServiceImpl (DiscountRepo discountRepo,
                                DiscountMapper discountMapper) {
        this.discountRepo = discountRepo;
        this.discountMapper = discountMapper;
    }

    @Override
    public List<DiscountsDto> findDiscountsByChannelId(Long channelId) {
       return discountRepo.findDiscountsByChannelId(channelId, new Date());
    }

    @Override
    public DiscountDto saveDiscount(DiscountDto discountDto) {
        return discountMapper.toDto(discountRepo.save(discountMapper.toEntity(discountDto)));
    }

/*    @Override
    public List<DiscountsDto> findDiscountsByChannelId(Long channelId) {
        List<Discount> discountList = discountRepo.findDiscountsByChannelId(channelId, new Date());
        List<DiscountsDto> discountsDtoList = new ArrayList<>();
        for (Discount discount: discountList) {
            discountsDtoList.forEach(x -> toDto(discount));
        }
        return discountsDtoList;
    }

    private DiscountsDto toDto(Discount discount) {
        DiscountsDto discountsDto = new DiscountsDto();
        discountsDto.setMinDays(discount.getMinDays());
        discountsDto.setPercent(discount.getPercent());
        return discountsDto;
    }*/

}
