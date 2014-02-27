/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

import entities.player.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class WorldGUI {
    
    private Player player;
    private int iX;
    private int iY;
    
    public WorldGUI(Player player) {
        this.player = player;
    }
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        iX = 0;
        iY = container.getHeight() - 70;
    }
    
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.lightGray);
        g.fillRect(0, container.getHeight() - 70, container.getWidth(), 70);
        g.setColor(Color.black);
        g.drawString("Life: " + player.getLife(), iX + 20, iY + 25);
    }
    
    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        
    }
    
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }
    
    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }
    
}
