package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Dto.AssetsTrackingUpdateDTO;
import com.Shaheer.smms.Dto.ContentAssetUpdateDTO;
import com.Shaheer.smms.Model.AssetsTracking;
import com.Shaheer.smms.Model.ContentAssets;
import com.Shaheer.smms.Model.PerformanceMetrics;
import com.Shaheer.smms.Service.AssetsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.AbstractDocument;
import java.util.List;

@RestController
@RequestMapping("/api/v1/assets")
@PreAuthorize("hasAnyRole('USER','ADMIN','VIEWER','MANAGER')")
public class AssetsController {
    private final AssetsService service;

    public AssetsController(AssetsService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<ContentAssets> getAllAssets(){
        return service.getAllAssets();
    }

    @GetMapping("/{id}")
    public ContentAssets getAssetsById(@PathVariable int id){
        return service.getAssetsById(id);
    }

    @GetMapping("/performance")
    public List<PerformanceMetrics> getAllPerformanceMetrics(){
        return service.getAllPerformanceMetrics();
    }

    @GetMapping("/performance/{id}")
    public PerformanceMetrics getPerformanceMetricsById(@PathVariable int id){
        return service.getPerformanceMetricsById(id).orElseThrow();
    }

    @GetMapping("/{id}/performance")
    public List<PerformanceMetrics> getPerformanceMetricsByAssetId(@PathVariable int id){
        return service.getPerformanceMetricsByAssetId(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteAsset(@PathVariable Integer id){
        this.service.deleteAsset(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/tracking/{id}")
    public void deleteAssetTracking(@PathVariable Integer id){
        this.service.deleteAssetTracking(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/performance/{id}")
    public void deletePerformance(@PathVariable Integer id){
        this.service.deletePerformance(id);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN','MANAGER')")
    @PostMapping("")
    public ContentAssets createNewContent(@RequestBody ContentAssets assets){
        return this.service.createNewContent(assets);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN','MANAGER')")
    @PostMapping("/tracking")
    public AssetsTracking createNewAssetTracking(@RequestBody AssetsTracking tracking){
        return this.service.createNewAssetTracking(tracking);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN','MANAGER')")
    @PostMapping("/performance")
    public PerformanceMetrics createNewPerformance(@RequestBody PerformanceMetrics metrics){
        return this.service.createNewPerformance(metrics);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN','MANAGER')")
    @PutMapping("/{id}")
    public ContentAssets updateAssets(@PathVariable Integer id, @RequestBody ContentAssetUpdateDTO updateDTO){
        return this.service.updateAsset(id,updateDTO);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN','MANAGER')")
    @PutMapping("/tracking/{id}")
    public AssetsTracking updateAssettracking(@PathVariable Integer id, @RequestBody AssetsTrackingUpdateDTO updateDTO){
        return this.service.updateassettracking(id,updateDTO);
    }
}
