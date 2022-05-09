package kg.easy.javaspringbootnatv.service.impl;

import kg.easy.javaspringbootnatv.dao.ChannelRepo;
import kg.easy.javaspringbootnatv.exceptions.NotFoundException;
import kg.easy.javaspringbootnatv.mapper.ChannelMapper;
import kg.easy.javaspringbootnatv.models.dto.ChannelDto;
import kg.easy.javaspringbootnatv.models.entity.Channel;
import kg.easy.javaspringbootnatv.models.json.ChannelsDto;
import kg.easy.javaspringbootnatv.models.json.DiscountsDto;
import kg.easy.javaspringbootnatv.models.sql.ChannelResultSet;
import kg.easy.javaspringbootnatv.service.ChannelService;
import kg.easy.javaspringbootnatv.service.DiscountService;
import kg.easy.javaspringbootnatv.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepo channelRepo;
    private final ChannelMapper channelMapper;
    private final PriceService priceService;
    private final DiscountService discountService;

    public ChannelServiceImpl(ChannelRepo channelRepo,
                              ChannelMapper channelMapper,
                              PriceService priceService,
                              DiscountService discountService) {
        this.channelRepo = channelRepo;
        this.channelMapper = channelMapper;
        this.priceService = priceService;
        this.discountService = discountService;
    }

    @Override
    public ChannelDto save(ChannelDto channelDto) {
        Channel channel = new Channel();
        channel.setActive(true);
        Channel channel1 = channelRepo.save(channelMapper.toEntity(channelDto));
        return channelMapper.toDto(channel1);
    }

    @Override
    public ChannelDto update(ChannelDto channelDto) {
        Channel channel = channelRepo.findById(channelDto.getId())
                .orElseThrow(() -> new NotFoundException("Канал не найден."));
        Channel channelResult = channelRepo.save(channelMapper.dtoToEntity(channelDto, channel));
        return channelMapper.toDto(channelResult);
    }

    @Override
    public ChannelDto getChannelById(Long channelId) {
        Channel channel = channelRepo.findById(channelId)
                .orElseThrow(() -> new NotFoundException("Канал не найден."));
        return channelMapper.toDto(channel);
    }

    @Override
    public List<ChannelDto> getAllChannels() {
        List<Channel> channelList = channelRepo.findAll();
        List<ChannelDto> channelDtoList = new ArrayList<>();
        for (Channel channel : channelList) {
            channelDtoList.add(channelMapper.toDto(channel));
        }
        return channelDtoList;
    }

    @Override
    public String deleteChannelById(Long channelId) {
        if(channelRepo.existsById(channelId)) {
            Channel channel = channelRepo.findById(channelId).
                    orElseThrow(() -> new NotFoundException("Канал не найден."));
            if(channel.isActive()) {
                channel.setActive(false);
                channelRepo.save(channel);
            } else {
                throw new NotFoundException("Канал уже удален.");
            }
        } else {
            throw new NotFoundException("Канал не найден.");
        }
        return "Success";
    }

    @Override
    public List<ChannelsDto> findAllChannels() {
        List<ChannelsDto> channelsDtoList = priceService.findChannelsWithPrice();
        channelsDtoList.forEach(
                x -> x.setDiscountsDtoList(discountService.findDiscountsByChannelId(x.getId())));
        return channelsDtoList;
    }

    @Override
    public List<ChannelsDto> findChannels() {
        List<ChannelResultSet> channelResultSetList = channelRepo.findAllChannels();

        List<ChannelsDto> channelsDtoList = new ArrayList<>();

        channelResultSetList.forEach(x -> {
            long count = channelsDtoList.stream()
                    .filter(y -> y.getId() == x.getId())
                    .count();

            if(count == 0) {
                ChannelsDto channelsDto = new ChannelsDto();
                channelsDto.setId(x.getId());
                channelsDto.setName(x.getName());
                channelsDto.setPhoto(x.getPhoto());
                channelsDto.setPrice(x.getPrice());

                List<DiscountsDto> discountsDtos = new ArrayList<>();
                DiscountsDto discountsDto = new DiscountsDto();
                discountsDto.setMinDays(x.getMinDays());
                discountsDto.setPercent(x.getPercent());
                discountsDtos.add(discountsDto);

                channelsDto.setDiscountsDtoList(discountsDtos);
                channelsDtoList.add(channelsDto);

            } else {

                ChannelsDto channelsDto = channelsDtoList.stream()
                        .filter(y -> y.getId() == x.getId())
                        .findFirst().get();

                List<DiscountsDto> discountsDtos = channelsDto.getDiscountsDtoList();
                DiscountsDto discountsDto = new DiscountsDto();
                discountsDto.setMinDays(x.getMinDays());
                discountsDto.setPercent(x.getPercent());
                discountsDtos.add(discountsDto);

            }
        });
        return channelsDtoList;
    }

}
