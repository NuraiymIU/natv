package kg.easy.javaspringbootnatv.controller;

import kg.easy.javaspringbootnatv.models.dto.DiscountDto;
import kg.easy.javaspringbootnatv.service.DiscountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/save")
    public DiscountDto save(@RequestBody DiscountDto discountDto) {
        return discountService.saveDiscount(discountDto);
    }

}
