package com.asiergarper.ecommercepriceservice.service;

import com.asiergarper.ecommercepriceservice.model.Price;
import com.asiergarper.ecommercepriceservice.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    public Optional<Price> getPrice(int productId, int brandId, LocalDateTime applicationDate){
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, applicationDate, applicationDate);

        if (!prices.isEmpty()){
            return prices.stream().max(Comparator.comparingInt(Price::getPriority));
        }
        return null;
    }
}
