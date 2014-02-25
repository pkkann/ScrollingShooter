/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
    public static final int dirt = 2;
    private Image waterImg, dirtImg;
    private int tileSize = 32;
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        waterImg = new Image("res/tiles/water.png");
        dirtImg = new Image("res/tiles/dirt.png");
    }
    
    public int getTileSize() {
        return tileSize;
    }

    public Image getTile(int type) {
        switch(type) {
            case water:
                return waterImg;
            case dirt:
                return dirtImg;
            default:
                return null;
        }
    }

}
