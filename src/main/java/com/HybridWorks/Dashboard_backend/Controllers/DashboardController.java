package com.HybridWorks.Dashboard_backend.Controllers;

import com.HybridWorks.Dashboard_backend.Entity.Dashboard;
import com.HybridWorks.Dashboard_backend.Services.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")

@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {
    public DashboardService dashboardService;
    public DashboardController(DashboardService dashboardService){
        this.dashboardService = dashboardService;
    }

    @PostMapping()
    public Dashboard createDashboard(@RequestBody Dashboard dashboard){
        return dashboardService.saveDashboard(dashboard);
    }

    @GetMapping()
    public List<Dashboard> getDashboards(){
        return dashboardService.listAllDashboards();
    }

    @GetMapping("/{id}")
    public Dashboard getDashboardById(@PathVariable Long id){
        return dashboardService.returnDashboardById(id);
    }

    @PutMapping("/{id}")
    public Dashboard update(@PathVariable Long id, @RequestBody Dashboard dashboard){
        return dashboardService.updateDashboard(id, dashboard);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id){
        dashboardService.deleteDashboard(id);

        Map<String,String> response = new HashMap<>();
        response.put("message", "Dashboard deleted successfully");

        return response;
    }
}
