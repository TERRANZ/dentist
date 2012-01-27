package ru.terra.dentist.orm.dto;

import java.util.Date;
import java.util.HashSet;
import ru.terra.dentist.orm.entity.Appointment;
import ru.terra.dentist.orm.entity.Comment;

/**
 *
 * @author terranz
 */
public class CommentDTO
{
    private Integer id;
    private Date date;
    private String title;
    private String text;
    private HashSet<Appointment> appointments;

    public CommentDTO(Comment c)
    {
        this.id = c.getCommentId();
        this.date = c.getCommentDate();
        this.appointments = (HashSet<Appointment>) (c.getAppointments() != null ? c.getAppointments() : new HashSet<Appointment>());
        this.text = c.getCommentText();
        this.title = c.getCommentTitle();
    }

    public HashSet<Appointment> getAppointments()
    {
        return appointments;
    }

    public void setAppointments(HashSet<Appointment> appointments)
    {
        this.appointments = appointments;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
