package ru.terra.dentist.orm.entity;
// Generated 08.04.2012 2:29:50 by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name = "comment", catalog = "dentist")
public class Comment implements java.io.Serializable
{
    private int commentId;
    private Date commentDate;
    private String commentTitle;
    private String commentText;
    private Set<Appointment> appointments = new HashSet<Appointment>(0);

    public Comment()
    {
    }

    public Comment(int commentId)
    {
	this.commentId = commentId;
    }

    public Comment(int commentId, Date commentDate, String commentTitle, String commentText, Set<Appointment> appointments)
    {
	this.commentId = commentId;
	this.commentDate = commentDate;
	this.commentTitle = commentTitle;
	this.commentText = commentText;
	this.appointments = appointments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id", unique = true, nullable = false)
    public int getCommentId()
    {
	return this.commentId;
    }

    public void setCommentId(int commentId)
    {
	this.commentId = commentId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "comment_date", length = 10)
    public Date getCommentDate()
    {
	return this.commentDate;
    }

    public void setCommentDate(Date commentDate)
    {
	this.commentDate = commentDate;
    }

    @Column(name = "comment_title", length = 100)
    public String getCommentTitle()
    {
	return this.commentTitle;
    }

    public void setCommentTitle(String commentTitle)
    {
	this.commentTitle = commentTitle;
    }

    @Column(name = "comment_text", length = 200)
    public String getCommentText()
    {
	return this.commentText;
    }

    public void setCommentText(String commentText)
    {
	this.commentText = commentText;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comment")
    public Set<Appointment> getAppointments()
    {
	return this.appointments;
    }

    public void setAppointments(Set<Appointment> appointments)
    {
	this.appointments = appointments;
    }
}
