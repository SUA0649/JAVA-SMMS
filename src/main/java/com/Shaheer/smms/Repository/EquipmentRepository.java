package com.Shaheer.smms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Shaheer.smms.Model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment,Integer> {
}
