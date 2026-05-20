package com.HybridWorks.Dashboard_backend.Services;

import com.HybridWorks.Dashboard_backend.Entity.Dashboard;
import com.HybridWorks.Dashboard_backend.Repository.DashboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {

    private DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository){
        this.dashboardRepository = dashboardRepository;
    }

    public Dashboard saveDashboard(Dashboard dashboard){
        return dashboardRepository.save(dashboard);
    }

    public List<Dashboard> listAllDashboards(){
        return dashboardRepository.findAll();
    }

    public Dashboard returnDashboardById(Long id){
        return dashboardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dashboard not found"));
    }

    public Dashboard updateDashboard(Long id, Dashboard dashboard){
        Dashboard existingDashboard = returnDashboardById(id);
        existingDashboard.setDashboardName(dashboard.getDashboardName());
        existingDashboard.setDescription(dashboard.getDescription());
        return dashboardRepository.save(existingDashboard);
    }

    public void deleteDashboard(Long id) {
        Dashboard dashboard=returnDashboardById(id);
        dashboardRepository.delete(dashboard);
    }
}
