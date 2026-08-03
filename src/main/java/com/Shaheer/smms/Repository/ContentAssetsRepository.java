package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.ContentAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentAssetsRepository extends JpaRepository<ContentAssets,Integer> {
}
