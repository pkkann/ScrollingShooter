/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.bullet;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class RedBullet extends Bullet {
    

    public RedBullet(float x, float y) {
        super(x, y);
        super.setSpeed(1.0f);
        super.setDamage(100);
        super.setLife(100);
        super.setWidth(10);
        super.setHeight(10);
        try {
            Image img = new Image("res/tiles/redBullet.png");
            super.setImg(img);
            super.setImageWidth(img.getWidth());
            super.setImageHeight(img.getHeight());
        } catch (SlickException ex) {
            Logger.getLogger(RedBullet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
//        g.setColor(Color.red);
//        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        super.getImg().draw(super.getX(), super.getY());
    }
    
}
