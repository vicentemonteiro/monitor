package com.monteiro.monitor.repository;

import com.monteiro.monitor.model.Entry;
import com.monteiro.monitor.model.Hashtag;
import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vicente.monteiro
 */
public interface EntryRepo extends JpaRepository<Entry, UUID> {

    public Collection<Entry> findAllByTag(Hashtag tag);
}
