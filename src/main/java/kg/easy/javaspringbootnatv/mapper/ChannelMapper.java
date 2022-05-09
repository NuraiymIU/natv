package kg.easy.javaspringbootnatv.mapper;

import kg.easy.javaspringbootnatv.models.dto.ChannelDto;
import kg.easy.javaspringbootnatv.models.entity.Channel;
import org.springframework.stereotype.Component;

@Component
public class ChannelMapper {

    public Channel toEntity(ChannelDto channelDto) {
        Channel channel = new Channel();
        channel.setName(channelDto.getName());
        channel.setPhoto(channelDto.getPhoto());
        channel.setActive(channelDto.isActive());
        channel.setOrderNum(channelDto.getOrderNum());
        return channel;
    }

    public ChannelDto toDto(Channel channel) {
        ChannelDto channelDto = new ChannelDto();
        channelDto.setId(channel.getId());
        channelDto.setName(channel.getName());
        channelDto.setPhoto(channel.getPhoto());
        channelDto.setActive(channel.isActive());
        channelDto.setOrderNum(channel.getOrderNum());
        return channelDto;
    }

    public Channel dtoToEntity(ChannelDto channelDto, Channel channel) {
        channel.setName(channelDto.getName());
        channel.setPhoto(channelDto.getPhoto());
        channel.setActive(channelDto.isActive());
        channel.setOrderNum(channelDto.getOrderNum());
        return channel;
    }

}
