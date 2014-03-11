/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bc.rman.sercices;

import com.bc.rman.model.ReportModel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bruno
 */
@Stateless
public class ReportFacade extends AbstractFacade<ReportModel> {
    @PersistenceContext(unitName = "com.bc.rman_RMAN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportFacade() {
        super(ReportModel.class);
    }
    
}
