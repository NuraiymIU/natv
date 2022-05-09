package kg.easy.javaspringbootnatv.controller;

import kg.easy.javaspringbootnatv.models.dto.ChannelDto;
import kg.easy.javaspringbootnatv.service.ChannelService;
import kg.easy.javaspringbootnatv.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping("/save")
    public ChannelDto saveChannel(@RequestBody ChannelDto channelDto) {
        return channelService.save(channelDto);
    }

    @PutMapping("/update")
    public ResponseMessage<ChannelDto> updateChannel(@RequestBody ChannelDto channelDto) {
        return new ResponseMessage<ChannelDto>().prepareSuccessMessage(channelService.update(channelDto));
    }

    @GetMapping("/get/{channelId}")
    public ResponseMessage<ChannelDto> getChannel(@PathVariable Long channelId) {
        return new ResponseMessage<ChannelDto>().prepareSuccessMessage(channelService.getChannelById(channelId));
    }

    @GetMapping("/get/all")
    public List<ChannelDto> getAllChannels() {
        return channelService.getAllChannels();
    }

    @DeleteMapping("/delete/{channelId}")
    private String deleteChannel(@PathVariable Long channelId) {
        return channelService.deleteChannelById(channelId);
    }

}
