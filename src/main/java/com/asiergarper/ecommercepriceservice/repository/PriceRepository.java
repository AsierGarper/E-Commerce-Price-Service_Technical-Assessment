package com.asiergarper.ecommercepriceservice.repository;

import com.asiergarper.ecommercepriceservice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            int productId,
            int brandId,
            LocalDateTime startDate,
            LocalDateTime endDate
    );

}
