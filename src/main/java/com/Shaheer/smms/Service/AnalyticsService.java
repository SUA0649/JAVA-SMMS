package com.Shaheer.smms.Service;

import com.Shaheer.smms.Dto.AnalyticsSummaryDTO;
import com.Shaheer.smms.Repository.InvoicesRepository;
import com.Shaheer.smms.Repository.SponsorshipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    @Autowired
    private InvoicesRepository repo;

    @Autowired
    private SponsorshipsRepository s_repo;

    public AnalyticsSummaryDTO getFinancialSummary(){
        Double i_revenue = this.repo.calculateTotalRevenue();
        Double s_revenue = this.s_repo.calculateTotalSponsorshipRevenue();
        Double expenses = this.repo.calculateTotalExpense();

        Double totalRevenue = i_revenue + s_revenue;
        Double netProfit = totalRevenue - expenses;

        Double paidAmount = this.repo.calculateTotalPaid();
        Double pendingAmount = this.repo.calculateTotalPending();

        Double totalInvoice = paidAmount + pendingAmount;
        Double collectionRate = 0.0;

        if(totalInvoice > 0){
            collectionRate= (paidAmount / totalInvoice)*100;
        }
        AnalyticsSummaryDTO dto = new AnalyticsSummaryDTO(totalRevenue,expenses,netProfit,paidAmount,pendingAmount,(Math.round(collectionRate*100.0)/100.0));

        return dto;
    }
}
