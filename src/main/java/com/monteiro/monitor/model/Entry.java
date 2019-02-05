package com.monteiro.monitor.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author vicente.monteiro
 */
@Entity
public class Entry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date insertDate;

    @Column(nullable = false, length = 500)
    private String body;

    @Column(nullable = false)
    private String author;

    @ManyToOne
    private Hashtag tag;

    public Entry(final Long id, final Date insertDate, final String body, final String author, final Hashtag tag) {
        this.id = id;
        this.insertDate = insertDate;
        this.body = body;
        this.author = author;
        this.tag = tag;
    }

    public Entry() {
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(final Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public Hashtag getTag() {
        return tag;
    }

    public void setTag(Hashtag tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}
