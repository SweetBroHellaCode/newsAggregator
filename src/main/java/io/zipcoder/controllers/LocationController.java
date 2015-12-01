package io.zipcoder.controllers;

import io.zipcoder.models.Location;
import io.zipcoder.models.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by emaron on 11/28/15.
 */
@RestController
public class LocationController {
    @Autowired
    private LocationDAO locationDAO;

    @ResponseBody
    @RequestMapping(value = "/location/create", method = RequestMethod.GET)
    public void createLocation(int article_id, String name) {
        Location newLocation = new Location(article_id, name);
        locationDAO.save(newLocation);
    }

    @ResponseBody
    @RequestMapping(value = "/location/readsingle", method = RequestMethod.GET)
    public Location readSingleLocation(int id) {
        return locationDAO.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/location/update", method = RequestMethod.GET)
    public Location updateLocation(int id, int article_id, String name) {
        Location oldLocation = locationDAO.findOne(id);
        Location newLocation;

        if (oldLocation != null) {
            newLocation = oldLocation;

            newLocation.setName(name);
            newLocation.setArticleId(article_id);

            locationDAO.save(newLocation);
        } else {
            return null;
        }
        return newLocation;
    }

    @ResponseBody
    @RequestMapping(value = "/location/delete", method = RequestMethod.GET)
    public void deleteLocation(int id) {
        Location tempLocation = locationDAO.findOne(id);
        if (tempLocation != null) {
            locationDAO.delete(tempLocation);
        }
    }
}
