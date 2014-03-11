/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bc.rman.sercices;

import com.bc.rman.model.ReportModel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author bruno
 */
public class ReportHelper {

    public static Collection<ChartSeries> getChartSeries(List<ReportModel> reportList) {
        Iterator<ReportModel> i = reportList.iterator();
        ChartSeries reportSeries = new ChartSeries();
        HashMap<String, ChartSeries> map = new HashMap<String, ChartSeries>();

        while (i.hasNext()) {
            ReportModel r = i.next();
            String name = r.getReportModelPK().getDbName() + " - " + r.getReportModelPK().getBackupObject();
            if (map.containsKey(name)) {
                ChartSeries series = map.get(name);
                series.set(200, 3);
                series.set(100, 5);
                series.set(130, 7);
            } else {
                ChartSeries series = new ChartSeries(name);
                map.put(name, series);
                series.set(200, 3);
                series.set(100, 5);
                series.set(130, 7);
            }

        }

        return map.values();

    }

}
