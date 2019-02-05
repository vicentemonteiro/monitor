package com.monteiro.monitor.bussines;

import com.monteiro.monitor.model.Entry;
import com.monteiro.monitor.model.Hashtag;
import com.monteiro.monitor.repository.EntryRepo;
import com.monteiro.monitor.repository.HashtagRepo;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author vicente.monteiro
 */
@Service
public class AutoSearchService {

    private final Logger logger = LoggerFactory.getLogger(AutoSearchService.class);

    @Autowired
    EntryRepo entryDAO;

    @Autowired
    HashtagRepo hashtagDAO;

    @Autowired
    EntryService entryService;

    @Scheduled(fixedDelay = 50000)
    private void proceedTags() {
        this.logger.info("Updating");
        proceedNewTag();
    }

    public void proceedNewTag() {
        this.hashtagDAO.findAll().iterator().forEachRemaining((final Hashtag tag) -> {
            final Collection<Entry> entryList = AutoSearchService.this.entryService.getEntry(tag);
            entryList.forEach((final Entry entry) -> {
                this.entryDAO.save(entry);
            });
        });
    }
}
