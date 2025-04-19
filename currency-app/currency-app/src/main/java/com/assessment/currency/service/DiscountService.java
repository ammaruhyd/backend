package com.assessment.currency.service;

import com.assessment.currency.objects.BillItem;

import java.util.List;

public interface DiscountService {
    public double applyDiscounts(List<BillItem> items, String userType, int tenureYears);
}
