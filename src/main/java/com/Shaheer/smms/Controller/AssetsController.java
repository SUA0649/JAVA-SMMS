package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.ContentAssets;
import com.Shaheer.smms.Model.PerformanceMetrics;
import com.Shaheer.smms.Service.AssetsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assets")
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

}
