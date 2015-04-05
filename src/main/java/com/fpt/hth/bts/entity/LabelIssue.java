/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.hth.bts.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dinhquangtrung
 */
@Entity
@Table(name = "btsLabelIssue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabelIssue.findAll", query = "SELECT l FROM LabelIssue l"),
    @NamedQuery(name = "LabelIssue.findById", query = "SELECT l FROM LabelIssue l WHERE l.id = :id"),
    @NamedQuery(name = "LabelIssue.findByLabelId", query = "SELECT l FROM LabelIssue l WHERE l.labelId = :labelId"),
    @NamedQuery(name = "LabelIssue.findByIssueId", query = "SELECT l FROM LabelIssue l WHERE l.issueId = :issueId")})
public class LabelIssue implements Serializable {
    @Size(max = 45)
    @Column(name = "label_name")
    private String labelName;
    @Size(max = 45)
    @Column(name = "label_color")
    private String labelColor;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "label_id")
    private Integer labelId;
    @Column(name = "issue_id")
    private Integer issueId;

    public LabelIssue() {
    }

    public LabelIssue(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
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
        if (!(object instanceof LabelIssue)) {
            return false;
        }
        LabelIssue other = (LabelIssue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpt.hth.bts.entity.LabelIssue[ id=" + id + " ]";
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(String labelColor) {
        this.labelColor = labelColor;
    }
    
}
