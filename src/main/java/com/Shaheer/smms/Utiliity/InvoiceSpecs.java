package com.Shaheer.smms.Utiliity;

import com.Shaheer.smms.Model.Invoices;
import org.springframework.data.jpa.domain.Specification;

public class InvoiceSpecs {

    // Filter by Status
    public static Specification<Invoices> hasStatus(String status){
        return (root,query,builder)-> {
            if(status==null|| status.isEmpty()){
                return null;
            }
            return builder.equal(root.get("status"),status);
        };
    }

    //Filter by Minimum Amount
    public static Specification<Invoices> amountGreaterthan(Double minAmount){
        return (root,query,builder) ->{
            if(minAmount==null){
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get("amount"),minAmount);
        };
    }
}
