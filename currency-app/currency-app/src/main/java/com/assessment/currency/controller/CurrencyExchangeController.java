package com.assessment.currency.controller;

import com.assessment.currency.objects.BillRequest;
import com.assessment.currency.service.CurrencyService;
import com.assessment.currency.service.DiscountService;
import com.assessment.currency.service.impl.CurrencyServiceImpl;
import com.assessment.currency.service.impl.DiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyExchangeController {

    @Autowired
    private DiscountService discountService;

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Object>> calculatePayable(@RequestBody BillRequest request) {
        double discountedAmount = discountService.applyDiscounts(
                request.getItems(),
                request.getUserType(),
                request.getCustomerTenureInYears()
        );

        double finalAmount = currencyService.convert(
                request.getOriginalCurrency(),
                request.getTargetCurrency(),
                discountedAmount
        );

        return ResponseEntity.ok(Map.of("payableAmount", finalAmount));
    }
}
