package kg.easy.javaspringbootnatv.service.impl;

import kg.easy.javaspringbootnatv.dao.PriceRepo;
import kg.easy.javaspringbootnatv.mapper.PriceMapper;
import kg.easy.javaspringbootnatv.models.dto.PriceDto;
import kg.easy.javaspringbootnatv.models.json.ChannelsDto;
import kg.easy.javaspringbootnatv.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepo priceRepo;
    private final PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepo priceRepo,
                            PriceMapper priceMapper) {
        this.priceRepo = priceRepo;
        this.priceMapper = priceMapper;
    }

    @Override
    public PriceDto savePrice(PriceDto priceDto) {
        return priceMapper.toDto(priceRepo.save(priceMapper.toEntity(priceDto)));
    }

    @Override
    public List<ChannelsDto> findChannelsWithPrice() {
        return priceRepo.findChannelsWithPrice(new Date());
    }

}
