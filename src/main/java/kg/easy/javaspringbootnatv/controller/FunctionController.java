package kg.easy.javaspringbootnatv.controller;

import kg.easy.javaspringbootnatv.models.json.ChannelsDto;
import kg.easy.javaspringbootnatv.models.sql.ChannelResultSet;
import kg.easy.javaspringbootnatv.service.ChannelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/function")
public class FunctionController {

    private final ChannelService channelService;

    public FunctionController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/channel/list")
    public List<ChannelsDto> findAllChannels() {
        return channelService.findAllChannels();
    }

    @GetMapping("/channel/all")
    public List<ChannelsDto> findChannels() {
        return channelService.findChannels();
    }

}
