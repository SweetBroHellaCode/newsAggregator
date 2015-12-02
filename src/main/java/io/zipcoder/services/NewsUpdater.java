package io.zipcoder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by emaron on 12/1/15.
 */
@Service
public class NewsUpdater {
    @Autowired
    DatabaseUpdateFactory databaseUpdateFactory;

    @Scheduled(fixedRate = 1000 * 60 * 60)
    public void updateDatabase() {
        databaseUpdateFactory.updateNews("https://webhose.io/search?token=a600ee1f-6b6f-4c11-9ae4-42835aa5b3cc&format=json&q=news&site=cnn.com&site_type=news");
        databaseUpdateFactory.updateNews("https://webhose.io/search?token=a600ee1f-6b6f-4c11-9ae4-42835aa5b3cc&format=json&q=news&site=msnbc.com&site_type=news");
        databaseUpdateFactory.updateNews("https://webhose.io/search?token=a600ee1f-6b6f-4c11-9ae4-42835aa5b3cc&format=json&q=news&site=foxnews.com&site_type=news");
        databaseUpdateFactory.updateNews("https://webhose.io/search?token=a600ee1f-6b6f-4c11-9ae4-42835aa5b3cc&format=json&q=news&site=ap.org&site_type=news");
        databaseUpdateFactory.updateNews("https://webhose.io/search?token=a600ee1f-6b6f-4c11-9ae4-42835aa5b3cc&format=json&q=news&site=aljazeera.com&site_type=news");
    }
}
