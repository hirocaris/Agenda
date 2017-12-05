/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author yami
 */
@Entity
@Table(name = "telefone", catalog = "agenda", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t")
    , @NamedQuery(name = "Telefone.findByTelId", query = "SELECT t FROM Telefone t WHERE t.telId = :telId")
    , @NamedQuery(name = "Telefone.findByTelNumero", query = "SELECT t FROM Telefone t WHERE t.telNumero = :telNumero")
    , @NamedQuery(name = "Telefone.findByPesId", query = "SELECT t FROM Telefone t WHERE t.pesId = :pesId")})
public class Telefone implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tel_id")
    private Integer telId;
    @Column(name = "tel_numero")
    private String telNumero;
    @Column(name = "pes_id")
    private Integer pesId;

    public Telefone() {
    }

    public Telefone(Integer telId) {
        this.telId = telId;
    }

    public Integer getTelId() {
        return telId;
    }

    public void setTelId(Integer telId) {
        Integer oldTelId = this.telId;
        this.telId = telId;
        changeSupport.firePropertyChange("telId", oldTelId, telId);
    }

    public String getTelNumero() {
        return telNumero;
    }

    public void setTelNumero(String telNumero) {
        String oldTelNumero = this.telNumero;
        this.telNumero = telNumero;
        changeSupport.firePropertyChange("telNumero", oldTelNumero, telNumero);
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        Integer oldPesId = this.pesId;
        this.pesId = pesId;
        changeSupport.firePropertyChange("pesId", oldPesId, pesId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telId != null ? telId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.telId == null && other.telId != null) || (this.telId != null && !this.telId.equals(other.telId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Interface.Telefone[ telId=" + telId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
