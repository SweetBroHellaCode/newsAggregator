package io.zipcoder.controllers;

import io.zipcoder.models.Organization;
import io.zipcoder.models.OrganizationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by emaron on 11/28/15.
 */
@RestController
public class OrganizationController {
    @Autowired
    private OrganizationDAO organizationDAO;

    @ResponseBody
    @RequestMapping(value = "/organization/create", method = RequestMethod.GET)
    public void createOrganization(int article_id, String name) {
        Organization newOrganization = new Organization(article_id, name);
        organizationDAO.save(newOrganization);
    }

    @ResponseBody
    @RequestMapping(value = "/organization/readsingle", method = RequestMethod.GET)
    public Organization readSingleOrganization(int id) {
        return organizationDAO.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/organization/update", method = RequestMethod.GET)
    public Organization updateOrganization(int id, int article_id, String name) {
        Organization oldOrganization = organizationDAO.findOne(id);
        Organization newOrganization;

        if (oldOrganization != null) {
            newOrganization = oldOrganization;

            newOrganization.setName(name);
            newOrganization.setArticleId(article_id);

            organizationDAO.save(newOrganization);
        } else {
            return null;
        }
        return newOrganization;
    }

    @ResponseBody
    @RequestMapping(value = "/organization/delete", method = RequestMethod.GET)
    public void deleteOrganization(int id) {
        Organization tempOrganization = organizationDAO.findOne(id);
        if (tempOrganization != null) {
            organizationDAO.delete(tempOrganization);
        }
    }
}
