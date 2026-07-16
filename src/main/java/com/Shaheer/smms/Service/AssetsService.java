package com.Shaheer.smms.Service;

import com.Shaheer.smms.Model.*;
import com.Shaheer.smms.Repository.AssetsTrackingRepository;
import com.Shaheer.smms.Repository.ContentAssetsRepository;
import com.Shaheer.smms.Repository.PerformanceMetricsRepository;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Service;

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

    public Optional<ContentAssets> getAssetsById(int id){
        return this.repo.findById(id);
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
}
