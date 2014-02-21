/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public interface Entity {
    
    public void render(GameContainer container, StateBasedGame game, Graphics g);
    public void update(GameContainer container, StateBasedGame game, int delta);
    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g);
    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta);
    
}
