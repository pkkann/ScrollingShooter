/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import entities.Sprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author patrick
 */
public interface SpriteManager {
    
    public Sprite spawnObject(int type, float x, float y);
    
    public void removeObjects();
    
    public void SetAliveOnObjects();

    public void checkCollisions();
    
    public void renderObjects(GameContainer container, StateBasedGame game, Graphics g) throws SlickException;
    
    public void verboseRenderObjects(GameContainer container, StateBasedGame game, Graphics g) throws SlickException;
    
    public void updateObjects(GameContainer container, StateBasedGame game, int delta) throws SlickException;
    
    public void verboseUpdateObjects(GameContainer container, StateBasedGame game, int delta) throws SlickException;
    
}
