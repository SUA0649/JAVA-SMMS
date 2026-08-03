package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.PerformanceMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceMetricsRepository extends JpaRepository<PerformanceMetrics,Integer> {
}
