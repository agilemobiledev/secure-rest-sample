package com.jayway.template.sample;

/**
 * Created with IntelliJ IDEA.
 * User: magnuskivi
 * Date: 2013-02-08
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 */
public class ActionDTO {

    public PersonDTO person;
    public String action;

    public ActionDTO(PersonDTO person, String action) {
        this.person = person;
        this.action = action;
    }


}
