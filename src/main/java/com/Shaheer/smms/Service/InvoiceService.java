package com.Shaheer.smms.Service;

import com.Shaheer.smms.Model.Invoices;
import com.Shaheer.smms.Repository.InvoicesRepository;
import com.Shaheer.smms.Utiliity.InvoiceSpecs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoicesRepository repo;

    public InvoiceService(InvoicesRepository repo) {
        this.repo = repo;
    }

    public Page<Invoices> getAllInvoices(Pageable pageable){
        return this.repo.findAll(pageable);
    }

    public Invoices getInvoicesById(int id){
        return this.repo.findById(id).orElseThrow();
    }

    public Invoices createNewInvoice( Invoices invoice){ return this.repo.save(invoice);}

    public boolean deleteInvoice(Integer id){
        if(this.repo.existsById(id)){
            this.repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Invoices> searchInvoiceByFilter(String status, Double minAmount, Pageable pageable){

        Specification<Invoices> spec = Specification
                .where(InvoiceSpecs.hasStatus(status))
                .and(InvoiceSpecs.amountGreaterthan(minAmount));

        return this.repo.findAll(spec,pageable);
    }
}
