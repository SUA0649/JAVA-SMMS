package com.Shaheer.smms.Dto;

public class AnalyticsSummaryDTO {
    private Double totalRevenue;
    private Double totalExpenses;
    private Double netProfit;

    private Double totalPaid;
    private Double totalPending;
    private Double percentageBar;

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public AnalyticsSummaryDTO(Double totalRevenue, Double totalExpenses, Double netProfit, Double totalPaid, Double totalPending, Double percentageBar) {
        this.totalRevenue = totalRevenue;
        this.totalExpenses = totalExpenses;
        this.netProfit = netProfit;
        this.totalPaid = totalPaid;
        this.totalPending = totalPending;
        this.percentageBar = percentageBar;
    }

    public AnalyticsSummaryDTO() {
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Double netProfit) {
        this.netProfit = netProfit;
    }

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Double getTotalPending() {
        return totalPending;
    }

    public void setTotalPending(Double totalPending) {
        this.totalPending = totalPending;
    }

    public Double getPercentageBar() {
        return percentageBar;
    }

    public void setPercentageBar(Double percentageBar) {
        this.percentageBar = percentageBar;
    }
}
