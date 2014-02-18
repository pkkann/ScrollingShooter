/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Patrick
 */
public abstract class Sprite implements Entity {
    
    float x, y;
    Rectangle bounds;
    Image img;
    
    public Sprite(Image img, float x, float y) {
        this.img = img;
        this.x = x;
        this.y = y;
        bounds = new Rectangle(x, y, img.getWidth(), img.getHeight());
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, x, y);
    }

    @Override
    public void update(int delta) {
        bounds.setX(x);
        bounds.setY(y);
    }
    
}
