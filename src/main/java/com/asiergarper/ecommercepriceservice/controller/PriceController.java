package com.asiergarper.ecommercepriceservice.controller;

import com.asiergarper.ecommercepriceservice.model.Price;
import com.asiergarper.ecommercepriceservice.model.PriceResponse;
import com.asiergarper.ecommercepriceservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<String> test(){
        return ResponseEntity
                .status(HttpStatus.OK) // .ok() for shortcut
                .header("Custom-Header", "value")
                .body("Test correcto, aplicacion levantada");
    }

    @RequestMapping(value = "/price", method = RequestMethod.GET)
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam int productId,
            @RequestParam int brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate
            ){

        Optional<Price> price = priceService.getPrice(productId, brandId, applicationDate);

        if(price.isPresent()){
            Price p = price.get();
            PriceResponse response = new PriceResponse(
                    p.getProductId(),
                    p.getBrandId(),
                    p.getPriceList(),
                    p.getStartDate(),
                    p.getEndDate(),
                    p.getPrice(),
                    p.getCurrency()
            );

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
