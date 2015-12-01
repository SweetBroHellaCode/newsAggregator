package io.zipcoder.controllers;

import io.zipcoder.models.Persons;
import io.zipcoder.models.PersonsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by emaron on 11/28/15.
 */
@RestController
public class PersonsController {
    @Autowired
    private PersonsDAO personsDAO;

    @ResponseBody
    @RequestMapping(value = "/persons/create", method = RequestMethod.GET)
    public void createPersons(int article_id, String name) {
        Persons newPersons = new Persons(article_id, name);
        personsDAO.save(newPersons);
    }

    @ResponseBody
    @RequestMapping(value = "/persons/readsingle", method = RequestMethod.GET)
    public Persons readSinglePersons(int id) {
        return personsDAO.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/persons/update", method = RequestMethod.GET)
    public Persons updatePersons(int id, int article_id, String name) {
        Persons oldPersons = personsDAO.findOne(id);
        Persons newPersons;

        if (oldPersons != null) {
            newPersons = oldPersons;

            newPersons.setName(name);
            newPersons.setArticleId(article_id);

            personsDAO.save(newPersons);
        } else {
            return null;
        }
        return newPersons;
    }

    @ResponseBody
    @RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
    public void deletePersons(int id) {
        Persons tempPersons = personsDAO.findOne(id);
        if (tempPersons != null) {
            personsDAO.delete(tempPersons);
        }
    }
}
