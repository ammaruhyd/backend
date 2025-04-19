package com.assessment.currency.objects;

import java.util.List;

public class BillRequest {
    private List<BillItem> items;
    private String userType;
    private int customerTenureInYears;
    private String originalCurrency;
    private String targetCurrency;

    public BillRequest() {}

    public List<BillItem> getItems() {
        return items;
    }

    public void setItems(List<BillItem> items) {
        this.items = items;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getCustomerTenureInYears() {
        return customerTenureInYears;
    }

    public void setCustomerTenureInYears(int customerTenureInYears) {
        this.customerTenureInYears = customerTenureInYears;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
}
