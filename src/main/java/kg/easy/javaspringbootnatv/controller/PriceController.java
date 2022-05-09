package kg.easy.javaspringbootnatv.controller;

import kg.easy.javaspringbootnatv.models.dto.PriceDto;
import kg.easy.javaspringbootnatv.service.PriceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/price")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping("/save")
    public PriceDto save(@RequestBody PriceDto priceDto) {
        return priceService.savePrice(priceDto);
    }

}
