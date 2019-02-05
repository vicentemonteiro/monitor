package com.monteiro.monitor.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author vicente.monteiro
 */
@Entity
public class Hashtag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Collection<Entry> entryList;

    public Hashtag(final String name) {
        this.name = name;
    }

    public Hashtag(final UUID id) {
        this.id = id;
    }

    public Hashtag() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Collection<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(Collection<Entry> entryList) {
        this.entryList = entryList;
    }

}
