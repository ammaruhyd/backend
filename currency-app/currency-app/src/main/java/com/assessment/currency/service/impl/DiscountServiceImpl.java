package com.assessment.currency.service.impl;

import com.assessment.currency.objects.BillItem;
import com.assessment.currency.model.ItemCategory;
import com.assessment.currency.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    public double applyDiscounts(List<BillItem> items, String userType, int tenureYears) {
        double total = 0, eligibleTotal4Discount = 0;
        for (BillItem item : items) {
            double price = item.getPrice();
            total += price;
            if (item.getCategory() != ItemCategory.GROCERY)
                eligibleTotal4Discount += price;
        }
        double discount = 0.0;
        if ("EMPLOYEE".equalsIgnoreCase(userType))
            discount = 0.30;
        else if ("AFFILIATE".equalsIgnoreCase(userType))
            discount = 0.10;
        else if ("CUSTOMER".equalsIgnoreCase(userType) && tenureYears > 2)
            discount = 0.05;

        double percentageDiscount = eligibleTotal4Discount * discount;
        double fixedDiscount = Math.floor(total / 100) * 5;
        return total - percentageDiscount - fixedDiscount;
    }
}
