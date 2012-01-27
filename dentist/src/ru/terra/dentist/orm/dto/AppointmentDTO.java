package ru.terra.dentist.orm.dto;

import java.util.Date;
import ru.terra.dentist.orm.entity.Appointment;

/**
 *
 * @author terranz
 */
public class AppointmentDTO
{
    private Integer id;
    private PatientDTO patient;
    private DiagnosisDTO diagnosis;
    private CommentDTO comment;
    private Date date;

    public AppointmentDTO(Appointment a)
    {
        this.id = a.getId().getAppId();
        this.date = a.getAppDate();
        this.patient = new PatientDTO(a.getPatient());
        this.diagnosis = new DiagnosisDTO(a.getDiagnosis());
        this.comment = new CommentDTO(a.getComment());
    }

    public CommentDTO getComment()
    {
        return comment;
    }

    public void setComment(CommentDTO comment)
    {
        this.comment = comment;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public DiagnosisDTO getDiagnosis()
    {
        return diagnosis;
    }

    public void setDiagnosis(DiagnosisDTO diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public PatientDTO getPatient()
    {
        return patient;
    }

    public void setPatient(PatientDTO patient)
    {
        this.patient = patient;
    }
}
