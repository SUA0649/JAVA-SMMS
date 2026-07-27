package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.Invoices;
import com.Shaheer.smms.Service.InvoiceService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@PreAuthorize("hasAnyRole('USER','ADMIN','MANAGER')")
public class InvoiceController {
    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }


    @GetMapping("/invoices/{id}")
    public Invoices getInvoicesById(@PathVariable int id){
        return this.service.getInvoicesById(id);
    }

    @GetMapping("/invoices")
    public ResponseEntity<Page<Invoices>> getInvoiceByFilter(@RequestParam(required = false) String status,
                                                             @RequestParam(required = false) Double minAmount,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "2")int size){
        Pageable pageable = PageRequest.of(page,size);

        Page<Invoices> invoicepage;

        if(status!=null && !status.isEmpty()|| minAmount!=null)
            return ResponseEntity.ok(this.service.searchInvoiceByFilter(status, minAmount, pageable));
        else
            return ResponseEntity.ok(this.service.getAllInvoices(pageable));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping("/invoices")
    public Invoices createNewInvoices(@RequestBody Invoices invoice){ return this.service.createNewInvoice(invoice);}

    @PreAuthorize("hasAnyRole('ADMIN')")
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
