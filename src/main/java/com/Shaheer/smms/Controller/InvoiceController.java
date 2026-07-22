package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.Invoices;
import com.Shaheer.smms.Service.InvoiceService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/invoices")
    public Invoices createNewInvoices(@RequestBody Invoices invoice){ return this.service.createNewInvoice(invoice);}

    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Integer id){
        if(this.service.deleteInvoice(id)){
            return ResponseEntity.ok("Invoice was successfully deleted");
         }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Couldn't delete invoice by id.");
        }
    }
}
