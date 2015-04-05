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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dinhquangtrung
 */
@Entity
@Table(name = "btsUserProject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProject.findAll", query = "SELECT u FROM UserProject u"),
    @NamedQuery(name = "UserProject.findById", query = "SELECT u FROM UserProject u WHERE u.id = :id"),
    @NamedQuery(name = "UserProject.findByJoinDate", query = "SELECT u FROM UserProject u WHERE u.joinDate = :joinDate"),
    @NamedQuery(name = "UserProject.findByUserId", query = "SELECT u FROM UserProject u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserProject.findByProjectId", query = "SELECT u FROM UserProject u WHERE u.projectId = :projectId"),
    @NamedQuery(name = "UserProject.findByRoleId", query = "SELECT u FROM UserProject u WHERE u.roleId = :roleId")})
public class UserProject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "join_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "project_id")
    private Integer projectId;
    @Column(name = "role_id")
    private Integer roleId;

    public UserProject() {
    }

    public UserProject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        if (!(object instanceof UserProject)) {
            return false;
        }
        UserProject other = (UserProject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpt.hth.bts.entity.UserProject[ id=" + id + " ]";
    }
    
}
