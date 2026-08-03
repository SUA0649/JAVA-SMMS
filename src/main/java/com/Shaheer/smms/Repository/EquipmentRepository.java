package com.Shaheer.smms.Repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Shaheer.smms.Model.Equipment;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,Integer> {
}
