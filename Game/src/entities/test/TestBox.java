/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.test;

import entities.Sprite;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author patrick
 */
public class TestBox extends Sprite {

    public TestBox(float x, float y) {
        super(x, y);
        super.setWidth(50);
        super.setHeight(50);
        super.setLife(100);
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(super.getX(), super.getY(), 50, 50);;
    }
    
}
