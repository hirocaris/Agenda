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
@Table(name = "pessoa", catalog = "agenda", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
    , @NamedQuery(name = "Pessoa.findByPessId", query = "SELECT p FROM Pessoa p WHERE p.pessId = :pessId")
    , @NamedQuery(name = "Pessoa.findByPessNome", query = "SELECT p FROM Pessoa p WHERE p.pessNome = :pessNome")})
public class Pessoa implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pess_id")
    private Integer pessId;
    @Column(name = "pess_nome")
    private String pessNome;

    public Pessoa() {
    }

    public Pessoa(Integer pessId) {
        this.pessId = pessId;
    }

    public Integer getPessId() {
        return pessId;
    }

    public void setPessId(Integer pessId) {
        Integer oldPessId = this.pessId;
        this.pessId = pessId;
        changeSupport.firePropertyChange("pessId", oldPessId, pessId);
    }

    public String getPessNome() {
        return pessNome;
    }

    public void setPessNome(String pessNome) {
        String oldPessNome = this.pessNome;
        this.pessNome = pessNome;
        changeSupport.firePropertyChange("pessNome", oldPessNome, pessNome);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessId != null ? pessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pessId == null && other.pessId != null) || (this.pessId != null && !this.pessId.equals(other.pessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Interface.Pessoa[ pessId=" + pessId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
