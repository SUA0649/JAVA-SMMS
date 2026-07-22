package com.Shaheer.smms.Service;

import com.Shaheer.smms.Model.Invoices;
import com.Shaheer.smms.Repository.InvoicesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoicesRepository repo;

    public InvoiceService(InvoicesRepository repo) {
        this.repo = repo;
    }

    public List<Invoices> getAllInvoices(){
        return this.repo.findAll();
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
}
