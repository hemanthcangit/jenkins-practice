package com.HybridWorks.Dashboard_backend.Repository;

import com.HybridWorks.Dashboard_backend.Entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard,Long> {

}
