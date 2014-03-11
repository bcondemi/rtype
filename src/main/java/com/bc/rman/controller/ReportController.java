/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bc.rman.controller;

import com.bc.rman.model.ReportModel;
import com.bc.rman.sercices.ReportFacade;
import com.bc.rman.sercices.ReportHelper;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author bruno
 */
@ManagedBean
@RequestScoped
public class ReportController {

    private CartesianChartModel reportGraphModel = new CartesianChartModel();
    private List<ReportModel> reportList;
     private List<ReportModel> selectedReports;
    private List<ReportModel> filteredReports;
    @EJB
    ReportFacade reportServcice;

    public ReportController() {
    }

    public void initReportList() {
        reportList = null;
    }

    /*
     *Getter and Setter
     */
    public List<ReportModel> getReportList() {
        if (reportList == null) {
            reportList = reportServcice.findAll();

            Iterator<ChartSeries> i = ReportHelper.getChartSeries(reportList).iterator();
            while (i.hasNext()) {
                reportGraphModel.addSeries(i.next());
            }

        }
        return reportList;
    }

    public void setReportList(List<ReportModel> reportList) {
        this.reportList = reportList;
    }

    public CartesianChartModel getReportGraphModel() {
        this.getReportList();
        return reportGraphModel;
    }

    public void setReportGraphModel(CartesianChartModel categoryModel) {
        this.reportGraphModel = categoryModel;
    }

    public List<ReportModel> getFilteredReports() {
        return filteredReports;
    }

    public void setFilteredReports(List<ReportModel> filteredReports) {
        this.filteredReports = filteredReports;
    }

    public List<ReportModel> getSelectedReports() {
        return selectedReports;
    }

    public void setSelectedReports(List<ReportModel> selectedReports) {
        this.selectedReports = selectedReports;
    }
    
    
    

}
