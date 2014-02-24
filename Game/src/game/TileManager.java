/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class TileManager {

    public static final int water = 1;
    private Image waterImg;
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        waterImg = new Image("res/tiles/water.png");
    }

    public Image getTile(int type) {
        switch(type) {
            case water:
                return waterImg;
            default:
                return null;
        }
    }

}
