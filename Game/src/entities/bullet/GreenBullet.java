/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.bullet;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class GreenBullet extends Bullet {
    

    public GreenBullet(float x, float y) {
        super(x, y);
        super.setSpeed(0.5f);
        super.setDamage(100);
        super.setLife(100);
        super.setWidth(10);
        super.setHeight(10);
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.setColor(Color.green);
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
    
}
