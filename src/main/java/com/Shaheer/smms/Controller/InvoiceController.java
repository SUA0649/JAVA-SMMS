package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.Invoices;
import com.Shaheer.smms.Service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InvoiceController {
    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @GetMapping("/invoices")
    public List<Invoices> getAllInvoices(){
        return this.service.getAllInvoices();
    }

    @GetMapping("/invoices/{id}")
    public Invoices getInvoicesById(@PathVariable int id){
        return this.service.getInvoicesById(id);
    }
}
