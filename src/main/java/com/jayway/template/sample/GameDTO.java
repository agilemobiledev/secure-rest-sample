package com.jayway.template.sample;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: magnuskivi
 * Date: 2013-02-08
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement
public class GameDTO {

    public String gameID;
    public PersonDTO playerOne;
    public PersonDTO playerTwo;
    public ActionDTO action1;
    public ActionDTO action2;

    public GameDTO(String userName) {
        this.gameID = userName + System.currentTimeMillis();
        playerOne = new PersonDTO(userName);

    }

    public void addPlayer(String userName) {
        playerTwo = new PersonDTO(userName);
    }

    public void addAction(ActionDTO action) {
        if (action.person.userName.equalsIgnoreCase(playerOne.userName)) {
            action1 = action;
        } else {
            action2 = action;
        }

        if(action1 != null && action2 != null) {
            //calculateWinner();
        }
    }



}
