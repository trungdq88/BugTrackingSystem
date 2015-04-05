/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.hth.bts.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dinhquangtrung
 */
@Entity
@Table(name = "btsMilestone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Milestone.findAll", query = "SELECT m FROM Milestone m"),
    @NamedQuery(name = "Milestone.findById", query = "SELECT m FROM Milestone m WHERE m.id = :id"),
    @NamedQuery(name = "Milestone.findByName", query = "SELECT m FROM Milestone m WHERE m.name = :name"),
    @NamedQuery(name = "Milestone.findByDescription", query = "SELECT m FROM Milestone m WHERE m.description = :description"),
    @NamedQuery(name = "Milestone.findByDeadline", query = "SELECT m FROM Milestone m WHERE m.deadline = :deadline"),
    @NamedQuery(name = "Milestone.findByStatus", query = "SELECT m FROM Milestone m WHERE m.status = :status"),
    @NamedQuery(name = "Milestone.findByProjectId", query = "SELECT m FROM Milestone m WHERE m.projectId = :projectId")})
public class Milestone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;
    @Column(name = "status")
    private Integer status;
    @Column(name = "project_id")
    private Integer projectId;

    public Milestone() {
    }

    public Milestone(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Milestone)) {
            return false;
        }
        Milestone other = (Milestone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpt.hth.bts.entity.Milestone[ id=" + id + " ]";
    }
    
}
