package com.asiergarper.ecommercepriceservice;

import com.asiergarper.ecommercepriceservice.controller.PriceController;
import com.asiergarper.ecommercepriceservice.model.Price;
import com.asiergarper.ecommercepriceservice.service.PriceService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Optional;

@WebMvcTest(PriceController.class)
public class ECommercePriceServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;


    //Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void test1() throws Exception {
        Price mockPrice = new Price();
        mockPrice.setProductId(35455);
        mockPrice.setBrandId(1L);
        mockPrice.setPrice(35.50);
        mockPrice.setCurrency("EUR");
        mockPrice.setPriceList(1);
        mockPrice.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        mockPrice.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));

        when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 14, 10, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T10:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"));
    }

    //Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void test2() throws Exception {
        Price mockPrice = new Price();
        mockPrice.setProductId(35455);
        mockPrice.setBrandId(1L);
        mockPrice.setPrice(25.45);
        mockPrice.setCurrency("EUR");
        mockPrice.setPriceList(2);
        mockPrice.setStartDate(LocalDateTime.of(2020, 6, 14, 15, 0));
        mockPrice.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30));

        when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 14, 16, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T16:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T15:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14T18:30:00"));
    }

    //Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void test3() throws Exception {
        Price mockPrice = new Price();
        mockPrice.setProductId(35455);
        mockPrice.setBrandId(1L);
        mockPrice.setPrice(30.50);
        mockPrice.setCurrency("EUR");
        mockPrice.setPriceList(3);
        mockPrice.setStartDate(LocalDateTime.of(2020, 6, 15, 0, 0));
        mockPrice.setEndDate(LocalDateTime.of(2020, 6, 15, 11, 0));

        when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 14, 21, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T21:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15T11:00:00"));
    }

    //Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void test4() throws Exception {
        Price mockPrice = new Price();
        mockPrice.setProductId(35455);
        mockPrice.setBrandId(1L);
        mockPrice.setPrice(30.50);
        mockPrice.setCurrency("EUR");
        mockPrice.setPriceList(3);
        mockPrice.setStartDate(LocalDateTime.of(2020, 6, 15, 0, 0));
        mockPrice.setEndDate(LocalDateTime.of(2020, 6, 15, 11, 0));

        when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 15, 10, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-15T10:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15T11:00:00"));
    }

    //Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void test5() throws Exception {
        Price mockPrice = new Price();
        mockPrice.setProductId(35455);
        mockPrice.setBrandId(1L);
        mockPrice.setPrice(38.95);
        mockPrice.setCurrency("EUR");
        mockPrice.setPriceList(4);
        mockPrice.setStartDate(LocalDateTime.of(2020, 6, 15, 16, 0));
        mockPrice.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));

        when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 16, 21, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-16T21:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T16:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"));
    }

}