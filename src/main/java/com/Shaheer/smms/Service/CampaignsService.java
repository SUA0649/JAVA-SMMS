package com.Shaheer.smms.Service;

import com.Shaheer.smms.Dto.CampaignUpdateDTO;
import com.Shaheer.smms.Dto.SponsorshipUpdateDTO;
import com.Shaheer.smms.Model.Campaign;
import com.Shaheer.smms.Model.Invoices;
import com.Shaheer.smms.Model.Sponsorships;
import com.Shaheer.smms.Repository.CampaignRepository;
import com.Shaheer.smms.Repository.SponsorshipsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignsService {
    private final CampaignRepository repo;
    private final SponsorshipsRepository s_repo;

    public CampaignsService(CampaignRepository repo, SponsorshipsRepository s_repo) {
        this.repo = repo;
        this.s_repo = s_repo;
    }

    public List<Campaign> getAllCampaigns(){
        return repo.findAll();
    }

    public List<Sponsorships> getAllSponsors(){
        return s_repo.findAll();
    }

    public Optional<Campaign> getCampaignById(int id){
        return this.repo.findById(id);
    }

    public Optional<Sponsorships> getSponsorshipById(int id){
        return this.s_repo.findById(id);
    }

    public List<Campaign> getCampaignBySponsorshipId(int id){
        Sponsorships sponsor = this.s_repo.findById(id).orElseThrow();
        return this.repo.findBySponsorships(sponsor);
    }

    public List<Sponsorships> getSponsorsByCampaignId(Integer id){
        Campaign campaign = this.repo.findById(id).orElseThrow();
        return s_repo.findByCampaigns(campaign);
    }

    public List<Invoices> getInvoicesBySponsorId(Integer id){
        Sponsorships sponsorships =this.s_repo.findById(id).orElseThrow();
        return sponsorships.getInvoices();
    }

    // Trying out Response Entity in this service.
    public boolean deleteCampaign(Integer id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteSponsorship(Integer id){
        if(s_repo.existsById(id)){
            s_repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Campaign createNewCampaign(Campaign campaign){
        return this.repo.save(campaign);
    }

    public Sponsorships createNewSponsorship(Sponsorships sponsor){
        return this.s_repo.save(sponsor);
    }

    public Campaign updateCampaign(Integer id, CampaignUpdateDTO updateDTO){
        Campaign existingCampaign = this.repo.findById(id).orElseThrow();

        if(updateDTO.getEnd_date()!=null)
            existingCampaign.setEnd_date(updateDTO.getEnd_date());

        if(updateDTO.getName()!=null)
            existingCampaign.setName(updateDTO.getName());

        if(updateDTO.getBudget()!=null)
            existingCampaign.setBudget(updateDTO.getBudget());

        return this.repo.save(existingCampaign);
    }

    public Sponsorships updateSponsorship(Integer id, SponsorshipUpdateDTO updateDTO){
        Sponsorships existingSponsorship = this.s_repo.findById(id).orElseThrow();

        if(updateDTO.getName()!=null)
            existingSponsorship.setName(updateDTO.getName());

        if(updateDTO.getBudget()!=null)
            existingSponsorship.setBudget(updateDTO.getBudget());

        if(updateDTO.getType()!=null)
            existingSponsorship.setType(updateDTO.getType());

        return this.s_repo.save(existingSponsorship);

    }
}
