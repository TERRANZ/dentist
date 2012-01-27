package ru.terra.dentist.orm.entity;
// Generated 26.01.2012 19:42:07 by Hibernate Tools 3.2.1.GA

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Appointment generated by hbm2java
 */
@Entity
@Table(name = "appointment", catalog = "dentist")
public class Appointment implements java.io.Serializable
{
    private AppointmentId id;
    private Patient patient;
    private Diagnosis diagnosis;
    private Comment comment;
    private Date appDate;

    public Appointment()
    {
    }

    public Appointment(AppointmentId id, Patient patient, Diagnosis diagnosis, Comment comment)
    {
        this.id = id;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.comment = comment;
    }

    public Appointment(AppointmentId id, Patient patient, Diagnosis diagnosis, Comment comment, Date appDate)
    {
        this.id = id;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.comment = comment;
        this.appDate = appDate;
    }

    @EmbeddedId
    @AttributeOverrides(
    {
        @AttributeOverride(name = "appId", column =
        @Column(name = "app_id", nullable = false)),
        @AttributeOverride(name = "patId", column =
        @Column(name = "pat_id", nullable = false)),
        @AttributeOverride(name = "diagId", column =
        @Column(name = "diag_id", nullable = false)),
        @AttributeOverride(name = "commentId", column =
        @Column(name = "comment_id", nullable = false))
    })
    public AppointmentId getId()
    {
        return this.id;
    }

    public void setId(AppointmentId id)
    {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pat_id", nullable = false, insertable = false, updatable = false)
    public Patient getPatient()
    {
        return this.patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diag_id", nullable = false, insertable = false, updatable = false)
    public Diagnosis getDiagnosis()
    {
        return this.diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false, insertable = false, updatable = false)
    public Comment getComment()
    {
        return this.comment;
    }

    public void setComment(Comment comment)
    {
        this.comment = comment;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "app_date", length = 10)
    public Date getAppDate()
    {
        return this.appDate;
    }

    public void setAppDate(Date appDate)
    {
        this.appDate = appDate;
    }
}
