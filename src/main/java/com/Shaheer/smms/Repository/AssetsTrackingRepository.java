package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Account;
import com.Shaheer.smms.Model.AssetsTracking;
import com.Shaheer.smms.Model.ContentAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Repository
public interface AssetsTrackingRepository extends JpaRepository<AssetsTracking,Integer> {
    public List<AssetsTracking> findByAccount(Account account);
    public List<AssetsTracking> findByAsset(ContentAssets asset);
}
