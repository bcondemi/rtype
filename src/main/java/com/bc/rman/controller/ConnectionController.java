/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bc.rman.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.bc.rman.model.Connection;

import com.bc.rman.model.ReportModel;
import com.bc.rman.sercices.ConnectionFacade;
import com.bc.rman.sercices.ReportFacade;
import com.bc.rman.sercices.ReportHelper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
/**
 *
 * @author bruno
 */
public class ConnectionController {

    private Connection currentConnection = new Connection();
    ;
    private List<Connection> connectionList;
    private Connection[] selectedConnection;
    @EJB
    private ConnectionFacade connectionFacade;

    public void initConnectionList() {
        connectionList = null;
    }

    public void initCurrentConnection() {
        currentConnection = new Connection();
    }

    public void saveConnection() {
        connectionFacade.create(currentConnection);
        initCurrentConnection();
        initConnectionList();
    }
    
    public void editCurrentConnection(){
        System.out.println("EditConnection");
        System.out.println(selectedConnection.length);
    }

    public void testCurrentConnection() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {            
            cpds.setDriverClass(currentConnection.getDriver());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cpds.setJdbcUrl(currentConnection.getConString());
        cpds.setUser(currentConnection.getUnsername());
        cpds.setPassword(currentConnection.getPassword());
        
    }
    
    public void testSelectedConnection(){
   
    }

    public Connection getCurrentConnection() {
        return currentConnection;
    }

    public void setCurrentConnection(Connection currentConnection) {
        this.currentConnection = currentConnection;
    }

    public List<Connection> getConnectionList() {
        if (connectionList == null) {
            connectionList = connectionFacade.findAll();
        }

        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public Connection[] getSelectedConnection() {
        return selectedConnection;
    }

    public void setSelectedConnection(Connection[] selectedConnection) {
        this.selectedConnection = selectedConnection;
    }

    

}
