package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Campaign;
import com.Shaheer.smms.Model.Sponsorships;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SponsorshipsRepository extends JpaRepository<Sponsorships,Integer> {
    List<Sponsorships> findByCampaigns(Campaign campaign);
}
