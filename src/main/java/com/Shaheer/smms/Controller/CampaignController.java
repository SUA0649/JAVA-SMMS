package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.Campaign;
import com.Shaheer.smms.Model.Invoices;
import com.Shaheer.smms.Model.Sponsorships;
import com.Shaheer.smms.Service.CampaignsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CampaignController {
    private final CampaignsService service;

    public CampaignController(CampaignsService service) {
        this.service = service;
    }

    @GetMapping("/campaigns")
    public List<Campaign> getALlCampaigns(){
        return this.service.getAllCampaigns();
    }

    @GetMapping("/campaigns/{id}")
    public Campaign getCampaignById(@PathVariable int id){
        return this.service.getCampaignById(id).orElseThrow();
    }

    @GetMapping("/sponsors")
    public List<Sponsorships> getAllSponsors(){
        return this.service.getAllSponsors();
    }

    @GetMapping("/sponsors/{id}")
    public Sponsorships getSponsorsById(@PathVariable int id){
        return this.service.getSponsorshipById(id).orElseThrow();
    }

    @GetMapping("/campaign/{id}/sponsors")
    public List<Sponsorships> getSponsorsByCampaignId(@PathVariable int id){
        return this.service.getSponsorsByCampaignId(id);
    }

    @GetMapping("/sponsors/{id}/campaign")
    public List<Campaign> getCampaignBySponsorshipId(@PathVariable int id){
        return this.service.getCampaignBySponsorshipId(id);
    }

    @GetMapping("/sponsors/{id}/invoices")
    public List<Invoices> getInvoicesBySponsorId(@PathVariable int id){
        return this.service.getInvoicesBySponsorId(id);
    }
}
