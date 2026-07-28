package com.Shaheer.smms.Service;

import com.Shaheer.smms.Dto.AssetsTrackingUpdateDTO;
import com.Shaheer.smms.Dto.ContentAssetUpdateDTO;
import com.Shaheer.smms.Model.*;
import com.Shaheer.smms.Repository.AssetsTrackingRepository;
import com.Shaheer.smms.Repository.ContentAssetsRepository;
import com.Shaheer.smms.Repository.PerformanceMetricsRepository;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Service;

import javax.swing.text.AbstractDocument;
import java.util.List;
import java.util.Optional;

@Service
public class AssetsService {
    private final ContentAssetsRepository repo;
    private final AssetsTrackingRepository t_repo;
    private final PerformanceMetricsRepository pm_repo;

    public AssetsService(ContentAssetsRepository repo, AssetsTrackingRepository t_repo,PerformanceMetricsRepository pm_repo) {
        this.repo = repo;
        this.t_repo = t_repo;
        this.pm_repo = pm_repo;
    }

    public List<ContentAssets> getAllAssets(){
        return this.repo.findAll();
    }

    public ContentAssets getAssetsById(int id){
        return this.repo.findById(id).orElseThrow();
    }

    public List<PerformanceMetrics> getAllPerformanceMetrics(){
        return pm_repo.findAll();
    }
    public Optional<PerformanceMetrics> getPerformanceMetricsById(int id){
        return pm_repo.findById(id);
    }
    public List<PerformanceMetrics> getPerformanceMetricsByAssetId(int id){
        ContentAssets asset = this.repo.findById(id).orElseThrow();
        List<AssetsTracking> assetsTrackingsList = this.t_repo.findByAsset(asset);
        List<List<PerformanceMetrics>> stream=  assetsTrackingsList.stream().map(AssetsTracking::getMetrics).toList();
        return stream.stream().flatMap(List::stream).toList();
    }

    public List<Account> getAccountByAssetId(int id){
        ContentAssets asset = this.repo.findById(id).orElseThrow();
        List<AssetsTracking> assetsTrackingList= this.t_repo.findByAsset(asset);
        return assetsTrackingList.stream().map(AssetsTracking::getAccount).toList();
    }

    public void deleteAsset(Integer id){
        this.repo.deleteById(id);
    }
    public void deleteAssetTracking(Integer id){
        this.t_repo.deleteById(id);
    }
    public void deletePerformance(Integer id){
        this.pm_repo.deleteById(id);
    }

    public ContentAssets createNewContent(ContentAssets assets){
        return this.repo.save(assets);
    }

    public AssetsTracking createNewAssetTracking(AssetsTracking tracking){
        return this.t_repo.save(tracking);
    }

    public PerformanceMetrics createNewPerformance(PerformanceMetrics metrics){
        return this.pm_repo.save(metrics);
    }

    public ContentAssets updateAsset(Integer id, ContentAssetUpdateDTO updateDTO){
        ContentAssets existingAsset = this.repo.findById(id).orElseThrow();

        if(updateDTO.getInternalStatus()!=null){
            existingAsset.setInternalStatus(updateDTO.getInternalStatus());
        }

        if(updateDTO.getTitle()!=null){
            existingAsset.setTitle(updateDTO.getTitle());
        }

        return this.repo.save(existingAsset);
    }

    public AssetsTracking updateassettracking(Integer id, AssetsTrackingUpdateDTO updateDTO){
        AssetsTracking existingTracking = this.t_repo.findById(id).orElseThrow();

        if(updateDTO.getUrl()!=null){
            existingTracking.setUrl(updateDTO.getUrl());
        }

        return this.t_repo.save(existingTracking);
    }
}
