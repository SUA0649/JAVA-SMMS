package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Dto.AnalyticsSummaryDTO;
import com.Shaheer.smms.Service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
@PreAuthorize("hasAnyRole('USER','ADMIN','VIEWER','MANAGER')")
public class AnalyticsController {
    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/analytics/summary")
    public ResponseEntity<AnalyticsSummaryDTO> getSummary(){
        return ResponseEntity.ok(analyticsService.getFinancialSummary());
    }
}
