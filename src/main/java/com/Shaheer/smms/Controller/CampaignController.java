package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Dto.CampaignUpdateDTO;
import com.Shaheer.smms.Dto.SponsorshipUpdateDTO;
import com.Shaheer.smms.Model.Campaign;
import com.Shaheer.smms.Model.Invoices;
import com.Shaheer.smms.Model.Sponsorships;
import com.Shaheer.smms.Service.CampaignsService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CampaignController {
    private final CampaignsService service;

    public CampaignController(CampaignsService service) {
        this.service = service;
    }

    @GetMapping("/campaign")
    public List<Campaign> getALlCampaigns(){
        return this.service.getAllCampaigns();
    }

    @GetMapping("/campaign/{id}")
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

    @DeleteMapping("/campaign/{id}")
    public ResponseEntity<String> deleteCampaign(@PathVariable int id ){
        if(this.service.deleteCampaign(id)){
            return ResponseEntity.ok("Campaign Deleted Successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("An error occured while deleting the Campgin via id");
        }
    }

    @DeleteMapping("/sponsors/{id}")
    public ResponseEntity<String> deleteSponsor(@PathVariable int id){
        if(this.service.deleteSponsorship(id)){
            return ResponseEntity.ok("Sponsorship deleted Successfully.");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("An error occured while deleting sponsorship via id");
        }
    }

    @PostMapping("/sponsors")
    public Sponsorships createNewSponsor(@RequestBody Sponsorships sponsor){
            return this.service.createNewSponsorship(sponsor);
    }

    @PostMapping("/campaign")
    public Campaign createNewCampaign(@RequestBody Campaign campaign){
        return this.service.createNewCampaign(campaign);
    }

    @PutMapping("/sponsors/{id}")
    public Sponsorships updateSponsor(@PathVariable Integer id, @RequestBody SponsorshipUpdateDTO updateDTO){
        return this.service.updateSponsorship(id,updateDTO);
    }

    @PutMapping("/campaign/{id}")
    public Campaign updateCampaign(@PathVariable Integer id, @RequestBody CampaignUpdateDTO updateDTO){
        return this.service.updateCampaign(id,updateDTO);
    }
}
