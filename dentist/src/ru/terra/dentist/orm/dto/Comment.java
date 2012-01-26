package ru.terra.dentist.orm.dto;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author terranz
 */
@Entity
@Table(name = "comment", catalog = "dentist", schema = "")
@NamedQueries(
{
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByCommentId", query = "SELECT c FROM Comment c WHERE c.commentId = :commentId"),
    @NamedQuery(name = "Comment.findByCommentDate", query = "SELECT c FROM Comment c WHERE c.commentDate = :commentDate"),
    @NamedQuery(name = "Comment.findByCommentTitle", query = "SELECT c FROM Comment c WHERE c.commentTitle = :commentTitle"),
    @NamedQuery(name = "Comment.findByCommentText", query = "SELECT c FROM Comment c WHERE c.commentText = :commentText")
})
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "comment_id", nullable = false)
    private Integer commentId;
    @Column(name = "comment_date")
    @Temporal(TemporalType.DATE)
    private Date commentDate;
    @Column(name = "comment_title", length = 100)
    private String commentTitle;
    @Column(name = "comment_text", length = 200)
    private String commentText;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comment")
    private List<Appointment> appointmentList;

    public Comment()
    {
    }

    public Comment(Integer commentId)
    {
        this.commentId = commentId;
    }

    public Integer getCommentId()
    {
        return commentId;
    }

    public void setCommentId(Integer commentId)
    {
        this.commentId = commentId;
    }

    public Date getCommentDate()
    {
        return commentDate;
    }

    public void setCommentDate(Date commentDate)
    {
        this.commentDate = commentDate;
    }

    public String getCommentTitle()
    {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle)
    {
        this.commentTitle = commentTitle;
    }

    public String getCommentText()
    {
        return commentText;
    }

    public void setCommentText(String commentText)
    {
        this.commentText = commentText;
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
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment))
        {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ru.terra.dentist.orm.dto.Comment[commentId=" + commentId + "]";
    }

}
