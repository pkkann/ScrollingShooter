/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jellygui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public interface JellyComponent {
    
    public void update(GameContainer container, StateBasedGame game, int delta);
    
    public void draw(Graphics g, float x, float y);
    
}
