package com.asiergarper.ecommercepriceservice.repository;

import com.asiergarper.ecommercepriceservice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            int productId,
            int brandId,
            LocalDateTime startDate,
            LocalDateTime endDate
    );

}
