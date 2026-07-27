package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InvoicesRepository extends JpaRepository<Invoices,Integer> , JpaSpecificationExecutor<Invoices> {
}
