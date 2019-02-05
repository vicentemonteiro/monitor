package com.monteiro.monitor.repository;

import com.monteiro.monitor.model.Hashtag;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vicente.monteiro
 */
public interface HashtagRepo extends JpaRepository<Hashtag, UUID> {
}
