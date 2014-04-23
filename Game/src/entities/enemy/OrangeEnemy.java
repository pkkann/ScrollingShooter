/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.enemy;

import entities.Sprite;
import entities.bullet.Bullet;
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
 * @author patrick
 */
public class OrangeEnemy extends Enemy {
    
    private final float speed;

    public OrangeEnemy(float x, float y) {
        super(x,y);
        this.speed = 0.28f;
        super.setWidth(32);
        super.setHeight(32);
        super.setLife(100);
        super.setPoint(1);
        super.setDamage(20);
        try {
            Image img = new Image("res/tiles/defaultEnemy.png");
            super.setImg(img);
            super.setImageWidth(img.getWidth());
            super.setImageHeight(img.getHeight());
        } catch (SlickException ex) {
            Logger.getLogger(OrangeEnemy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        super.update(container, game, delta); //To change body of generated methods, choose Tools | Templates.
        super.setY(super.getY() + speed * delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
//        g.setColor(Color.orange);
//        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        super.getImg().draw(super.getX(), super.getY());
    }

    @Override
    public void collision(Sprite s) {
        //Check if bullet
        if(s instanceof Bullet) {
            this.setLife(this.getLife() - s.getDamage());
        }
    }

   
    
}
