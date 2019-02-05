package com.monteiro.monitor.bussines;

import com.monteiro.monitor.model.Entry;
import com.monteiro.monitor.model.Hashtag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 *
 * @author vicente.monteiro
 */
@Service
public class EntryService {

    private final Logger logger = LoggerFactory.getLogger(AutoSearchService.class);

    public Collection<Entry> getEntry(final Hashtag tag) {

        final Twitter twitter = new TwitterFactory().getInstance();
        final List<Entry> entryList = new ArrayList<>();
        try {

            Query query = new Query("#" + tag.getName());
            QueryResult result;
            do {
                result = twitter.search(query);
                final List<Status> tweets = result.getTweets();
                for (final Status tweet : tweets) {
                    final Entry entry = new Entry(tweet.getId(), tweet.getCreatedAt(), tweet.getText(), tweet.getUser().getScreenName(), tag);
                    entryList.add(entry);
                }
            } while ((query = result.nextQuery()) != null);
        } catch (final Exception e) {
            this.logger.error(e.getMessage());
        }
        return entryList;
    }
}
