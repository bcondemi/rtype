/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bc.rman.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "RMAN_REPORT_J")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportModel.findAll", query = "SELECT r FROM ReportModel r"),
    @NamedQuery(name = "ReportModel.findByBackupBegin", query = "SELECT r FROM ReportModel r WHERE r.backupBegin = :backupBegin"),
    @NamedQuery(name = "ReportModel.findByBackupEnd", query = "SELECT r FROM ReportModel r WHERE r.backupEnd = :backupEnd"),
    @NamedQuery(name = "ReportModel.findByBackupsizeMb", query = "SELECT r FROM ReportModel r WHERE r.backupsizeMb = :backupsizeMb"),
    @NamedQuery(name = "ReportModel.findByBackupspeedpersecMb", query = "SELECT r FROM ReportModel r WHERE r.backupspeedpersecMb = :backupspeedpersecMb"),
    @NamedQuery(name = "ReportModel.findBySessionRecid", query = "SELECT r FROM ReportModel r WHERE r.sessionRecid = :sessionRecid"),
    @NamedQuery(name = "ReportModel.findByStatus", query = "SELECT r FROM ReportModel r WHERE r.status = :status"),
    @NamedQuery(name = "ReportModel.findByTargetDevice", query = "SELECT r FROM ReportModel r WHERE r.targetDevice = :targetDevice"),
    @NamedQuery(name = "ReportModel.findByTimeTaken", query = "SELECT r FROM ReportModel r WHERE r.timeTaken = :timeTaken"),
    @NamedQuery(name = "ReportModel.findByDbName", query = "SELECT r FROM ReportModel r WHERE r.reportModelPK.dbName = :dbName"),
    @NamedQuery(name = "ReportModel.findByBackupObject", query = "SELECT r FROM ReportModel r WHERE r.reportModelPK.backupObject = :backupObject")})
public class ReportModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReportModelPK reportModelPK;
    @Column(name = "BACKUP_BEGIN")
    @Temporal(TemporalType.DATE)
    private Date backupBegin;
    @Column(name = "BACKUP_END")
    @Temporal(TemporalType.DATE)
    private Date backupEnd;
    @Column(name = "BACKUPSIZE_MB")
    private Integer backupsizeMb;
    @Column(name = "BACKUPSPEEDPERSEC_MB")
    private Integer backupspeedpersecMb;
    @Column(name = "SESSION_RECID")
    private Integer sessionRecid;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 255)
    @Column(name = "TARGET_DEVICE")
    private String targetDevice;
    @Size(max = 255)
    @Column(name = "TIME_TAKEN")
    private String timeTaken;

    public ReportModel() {
    }

    public ReportModel(ReportModelPK reportModelPK) {
        this.reportModelPK = reportModelPK;
    }

    public ReportModel(String dbName, String backupObject) {
        this.reportModelPK = new ReportModelPK(dbName, backupObject);
    }

    public ReportModelPK getReportModelPK() {
        return reportModelPK;
    }

    public void setReportModelPK(ReportModelPK reportModelPK) {
        this.reportModelPK = reportModelPK;
    }

    public Date getBackupBegin() {
        return backupBegin;
    }

    public void setBackupBegin(Date backupBegin) {
        this.backupBegin = backupBegin;
    }

    public Date getBackupEnd() {
        return backupEnd;
    }

    public void setBackupEnd(Date backupEnd) {
        this.backupEnd = backupEnd;
    }

    public Integer getBackupsizeMb() {
        return backupsizeMb;
    }

    public void setBackupsizeMb(Integer backupsizeMb) {
        this.backupsizeMb = backupsizeMb;
    }

    public Integer getBackupspeedpersecMb() {
        return backupspeedpersecMb;
    }

    public void setBackupspeedpersecMb(Integer backupspeedpersecMb) {
        this.backupspeedpersecMb = backupspeedpersecMb;
    }

    public Integer getSessionRecid() {
        return sessionRecid;
    }

    public void setSessionRecid(Integer sessionRecid) {
        this.sessionRecid = sessionRecid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTargetDevice() {
        return targetDevice;
    }

    public void setTargetDevice(String targetDevice) {
        this.targetDevice = targetDevice;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportModelPK != null ? reportModelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportModel)) {
            return false;
        }
        ReportModel other = (ReportModel) object;
        if ((this.reportModelPK == null && other.reportModelPK != null) || (this.reportModelPK != null && !this.reportModelPK.equals(other.reportModelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bc.rman.model.ReportModel[ reportModelPK=" + reportModelPK + " ]";
    }
    
}
