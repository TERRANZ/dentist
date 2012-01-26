package ru.terra.dentist.orm.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author terranz
 */
@Entity
@Table(name = "appointment", catalog = "dentist", schema = "")
@NamedQueries(
{
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByAppId", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.appId = :appId"),
    @NamedQuery(name = "Appointment.findByAppDate", query = "SELECT a FROM Appointment a WHERE a.appDate = :appDate"),
    @NamedQuery(name = "Appointment.findByPatId", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.patId = :patId"),
    @NamedQuery(name = "Appointment.findByDiagId", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.diagId = :diagId"),
    @NamedQuery(name = "Appointment.findByCommentId", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.commentId = :commentId")
})
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppointmentPK appointmentPK;
    @Column(name = "app_date")
    @Temporal(TemporalType.DATE)
    private Date appDate;
    @JoinColumn(name = "diag_id", referencedColumnName = "diag_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diagnosis diagnosis;
    @JoinColumn(name = "pat_id", referencedColumnName = "pat_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patient patient;
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comment comment;

    public Appointment()
    {
    }

    public Appointment(AppointmentPK appointmentPK)
    {
        this.appointmentPK = appointmentPK;
    }

    public Appointment(int appId, int patId, int diagId, int commentId)
    {
        this.appointmentPK = new AppointmentPK(appId, patId, diagId, commentId);
    }

    public AppointmentPK getAppointmentPK()
    {
        return appointmentPK;
    }

    public void setAppointmentPK(AppointmentPK appointmentPK)
    {
        this.appointmentPK = appointmentPK;
    }

    public Date getAppDate()
    {
        return appDate;
    }

    public void setAppDate(Date appDate)
    {
        this.appDate = appDate;
    }

    public Diagnosis getDiagnosis()
    {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    public Comment getComment()
    {
        return comment;
    }

    public void setComment(Comment comment)
    {
        this.comment = comment;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (appointmentPK != null ? appointmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment))
        {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appointmentPK == null && other.appointmentPK != null) || (this.appointmentPK != null && !this.appointmentPK.equals(other.appointmentPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ru.terra.dentist.orm.dto.Appointment[appointmentPK=" + appointmentPK + "]";
    }

}
