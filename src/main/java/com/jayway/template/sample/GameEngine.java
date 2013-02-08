package com.jayway.template.sample;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: michaelkober
 * Date: 2013-02-08
 * Time: 18:12
 * To change this template use File | Settings | File Templates.
 */
public class GameEngine {

    public static String calculateWinner(ActionDTO action1, ActionDTO action2) {
        String move1 = action1.action;
        String move2 = action2.action;
        if (move1.equals(move2)) {
            return "Tie";
        } else if (move1.equals("Paper") && move2.equals("Stone")) {
            return action1.person;
        } else if (move1.equals("Stone") && move2.equals("Scissors")) {
            return action1.person;
        } else if(move1.equals("Scissors") && move2.equals("Paper")) {
            return action1.person;
        } return action2.person;
    }
}
