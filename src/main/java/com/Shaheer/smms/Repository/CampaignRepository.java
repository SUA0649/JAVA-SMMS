package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Campaign;
import com.Shaheer.smms.Model.Sponsorships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
    public List<Campaign> findBySponsorships(Sponsorships sponsor);
}
