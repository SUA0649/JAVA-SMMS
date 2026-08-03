package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Campaign;
import com.Shaheer.smms.Model.Sponsorships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorshipsRepository extends JpaRepository<Sponsorships,Integer> {
    List<Sponsorships> findByCampaigns(Campaign campaign);

    @Query("SELECT COALESCE(SUM(s.budget),0) FROM Sponsorships s")
    Double calculateTotalSponsorshipRevenue();
}
