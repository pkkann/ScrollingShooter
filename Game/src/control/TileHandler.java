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
public class TileHandler {

    public static final int water = 1;
    public static final int dirt = 2;
    private Image tileSheet;
    private final int tileSize;
    private final int typeDif;

    public TileHandler() {
        this.typeDif = 1;
        this.tileSize = 32;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        tileSheet = new Image("res/tiles/Tilesheet_environment.png");
    }

    public int getTileSize() {
        return tileSize;
    }

    public Image getTile(int type) {
        Image subI = tileSheet.getSubImage((type - typeDif) * tileSize, 0, tileSize, tileSize);
        return subI;
    }

}
