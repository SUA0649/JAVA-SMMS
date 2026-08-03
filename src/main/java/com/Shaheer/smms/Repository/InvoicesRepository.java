package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoices,Integer> , JpaSpecificationExecutor<Invoices> {

    //Calculate total Revenue
    @Query("SELECT COALESCE(SUM(i.amount),0) FROM Invoices i WHERE i.type = 'Credit' AND i.status = 'PAID'")
    Double calculateTotalRevenue();
    //COALESCE evaluates a list of values from left to right and returns the very first non-NULL value if finds.

    //Calculate Total Expense
    @Query("SELECT COALESCE(SUM(i.amount),0) FROM Invoices i WHERE i.type = 'Debit' AND i.status= 'PAID'")
    Double calculateTotalExpense();

    @Query("SELECT COALESCE(SUM(i.amount),0) FROM Invoices i WHERE i.status ='PAID'")
    Double calculateTotalPaid();

    @Query("SELECT COALESCE(SUM(i.amount),0) FROM Invoices i WHERE i.status='PENDING'")
    Double calculateTotalPending();
}
