/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bc.rman.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author bruno
 */
@Embeddable
public class ReportModelPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DB_NAME")
    private String dbName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "BACKUP_OBJECT")
    private String backupObject;

    public ReportModelPK() {
    }

    public ReportModelPK(String dbName, String backupObject) {
        this.dbName = dbName;
        this.backupObject = backupObject;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getBackupObject() {
        return backupObject;
    }

    public void setBackupObject(String backupObject) {
        this.backupObject = backupObject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbName != null ? dbName.hashCode() : 0);
        hash += (backupObject != null ? backupObject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportModelPK)) {
            return false;
        }
        ReportModelPK other = (ReportModelPK) object;
        if ((this.dbName == null && other.dbName != null) || (this.dbName != null && !this.dbName.equals(other.dbName))) {
            return false;
        }
        if ((this.backupObject == null && other.backupObject != null) || (this.backupObject != null && !this.backupObject.equals(other.backupObject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bc.rman.model.ReportModelPK[ dbName=" + dbName + ", backupObject=" + backupObject + " ]";
    }
    
}
