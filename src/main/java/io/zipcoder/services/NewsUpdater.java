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
        databaseUpdateFactory.updateNews("CNN");
        databaseUpdateFactory.updateNews("MSNBC");
        databaseUpdateFactory.updateNews("FOX");
        databaseUpdateFactory.updateNews("AP");
        databaseUpdateFactory.updateNews("ALJAZEERA");
    }
}
