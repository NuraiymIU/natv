package kg.easy.javaspringbootnatv.service;

import kg.easy.javaspringbootnatv.models.dto.ChannelDto;
import kg.easy.javaspringbootnatv.models.json.ChannelsDto;

import java.util.List;

public interface ChannelService {

    ChannelDto save(ChannelDto channelDto);

    ChannelDto update(ChannelDto channelDto);

    ChannelDto getChannelById(Long id);

    List<ChannelDto> getAllChannels();

    String deleteChannelById(Long channelId);

    List<ChannelsDto> findAllChannels();

    List<ChannelsDto> findChannels();
}
