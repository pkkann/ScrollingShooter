/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Bullet {
    
    private Image img;
    private float speed;
    private float angle;
    private Rectangle bounds;
    
    public Bullet(Image img) {
        setImg(img);
    }

    public void setImg(Image img) {
        this.img = img;
        bounds = new Rectangle(0, 0, img.getWidth(), img.getHeight());
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getSpeed() {
        return speed;
    }

    public float getAngle() {
        return angle;
    }

    public Rectangle getBounds() {
        return bounds;
    }
    
    public void draw(Graphics g, float x, float y) {
        bounds.setX(x);
        bounds.setY(y);
        g.drawImage(img, x, y);
    }
    
}
