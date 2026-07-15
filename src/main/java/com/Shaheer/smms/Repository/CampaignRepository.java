package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
}
