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
@Table(name = "patient", catalog = "dentist", schema = "")
@NamedQueries(
{
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByPatId", query = "SELECT p FROM Patient p WHERE p.patId = :patId"),
    @NamedQuery(name = "Patient.findByPatNum", query = "SELECT p FROM Patient p WHERE p.patNum = :patNum"),
    @NamedQuery(name = "Patient.findByPatSurname", query = "SELECT p FROM Patient p WHERE p.patSurname = :patSurname"),
    @NamedQuery(name = "Patient.findByPatName", query = "SELECT p FROM Patient p WHERE p.patName = :patName"),
    @NamedQuery(name = "Patient.findByPatMidname", query = "SELECT p FROM Patient p WHERE p.patMidname = :patMidname")
})
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pat_id", nullable = false)
    private Integer patId;
    @Column(name = "pat_num")
    private Integer patNum;
    @Column(name = "pat_surname", length = 100)
    private String patSurname;
    @Column(name = "pat_name", length = 100)
    private String patName;
    @Column(name = "pat_midname", length = 100)
    private String patMidname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Appointment> appointmentList;

    public Patient()
    {
    }

    public Patient(Integer patId)
    {
        this.patId = patId;
    }

    public Integer getPatId()
    {
        return patId;
    }

    public void setPatId(Integer patId)
    {
        this.patId = patId;
    }

    public Integer getPatNum()
    {
        return patNum;
    }

    public void setPatNum(Integer patNum)
    {
        this.patNum = patNum;
    }

    public String getPatSurname()
    {
        return patSurname;
    }

    public void setPatSurname(String patSurname)
    {
        this.patSurname = patSurname;
    }

    public String getPatName()
    {
        return patName;
    }

    public void setPatName(String patName)
    {
        this.patName = patName;
    }

    public String getPatMidname()
    {
        return patMidname;
    }

    public void setPatMidname(String patMidname)
    {
        this.patMidname = patMidname;
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
        hash += (patId != null ? patId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient))
        {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patId == null && other.patId != null) || (this.patId != null && !this.patId.equals(other.patId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ru.terra.dentist.orm.dto.Patient[patId=" + patId + "]";
    }

}
