/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bc.rman.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "CON_CONFIG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Connection.findAll", query = "SELECT c FROM Connection c"),
    @NamedQuery(name = "Connection.findByDescription", query = "SELECT c FROM Connection c WHERE c.description = :description"),
    @NamedQuery(name = "Connection.findByConString", query = "SELECT c FROM Connection c WHERE c.conString = :conString"),
    @NamedQuery(name = "Connection.findByName", query = "SELECT c FROM Connection c WHERE c.name = :name")})
public class Connection implements Serializable {
    @Size(max = 30)
    @Column(name = "DRIVER")
    private String driver;
    @Size(max = 30)
    @Column(name = "UNSERNAME")
    private String unsername;
    @Size(max = 30)
    @Column(name = "PASSWORD")
    private String password;
    private static final long serialVersionUID = 1L;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 256)
    @Column(name = "CON_STRING")
    private String conString;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;

    public Connection() {
    }

    public Connection(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConString() {
        return conString;
    }

    public void setConString(String conString) {
        this.conString = conString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Connection)) {
            return false;
        }
        Connection other = (Connection) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bc.rman.model.Connection[ name=" + name + " ]";
    }

    public String getUnsername() {
        return unsername;
    }

    public void setUnsername(String unsername) {
        this.unsername = unsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
}
