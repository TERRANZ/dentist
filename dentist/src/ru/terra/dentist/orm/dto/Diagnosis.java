package ru.terra.dentist.orm.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author terranz
 */
@Entity
@Table(name = "diagnosis", catalog = "dentist", schema = "")
@NamedQueries(
{
    @NamedQuery(name = "Diagnosis.findAll", query = "SELECT d FROM Diagnosis d"),
    @NamedQuery(name = "Diagnosis.findByDiagId", query = "SELECT d FROM Diagnosis d WHERE d.diagId = :diagId"),
    @NamedQuery(name = "Diagnosis.findByDiagCode", query = "SELECT d FROM Diagnosis d WHERE d.diagCode = :diagCode"),
    @NamedQuery(name = "Diagnosis.findByDiagName", query = "SELECT d FROM Diagnosis d WHERE d.diagName = :diagName"),
    @NamedQuery(name = "Diagnosis.findByDiagPrice", query = "SELECT d FROM Diagnosis d WHERE d.diagPrice = :diagPrice")
})
public class Diagnosis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "diag_id", nullable = false)
    private Integer diagId;
    @Column(name = "diag_code", length = 20)
    private String diagCode;
    @Column(name = "diag_name", length = 200)
    private String diagName;
    @Column(name = "diag_price")
    private Integer diagPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diagnosis")
    private List<Appointment> appointmentList;

    public Diagnosis()
    {
    }

    public Diagnosis(Integer diagId)
    {
        this.diagId = diagId;
    }

    public Integer getDiagId()
    {
        return diagId;
    }

    public void setDiagId(Integer diagId)
    {
        this.diagId = diagId;
    }

    public String getDiagCode()
    {
        return diagCode;
    }

    public void setDiagCode(String diagCode)
    {
        this.diagCode = diagCode;
    }

    public String getDiagName()
    {
        return diagName;
    }

    public void setDiagName(String diagName)
    {
        this.diagName = diagName;
    }

    public Integer getDiagPrice()
    {
        return diagPrice;
    }

    public void setDiagPrice(Integer diagPrice)
    {
        this.diagPrice = diagPrice;
    }

    public List<Appointment> getAppointmentList()
    {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList)
    {
        this.appointmentList = appointmentList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (diagId != null ? diagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnosis))
        {
            return false;
        }
        Diagnosis other = (Diagnosis) object;
        if ((this.diagId == null && other.diagId != null) || (this.diagId != null && !this.diagId.equals(other.diagId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ru.terra.dentist.orm.dto.Diagnosis[diagId=" + diagId + "]";
    }

}
