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
public abstract class Sprite implements Entity {
    
    float x, y;
    Rectangle bounds;
    Image img;
    
    public Sprite(float x, float y) {
        this.x = x;
        this.y = y;
        bounds = new Rectangle(x, y, 0,0);
    }
    
    public Sprite(Image img, float x, float y) {
        this.x = x;
        this.y = y;
        this.img = img;
        bounds = new Rectangle(x, y, img.getWidth(), img.getHeight());
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        bounds.setX(x);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        bounds.setY(y);
    }
    
    public float getWidth() {
        return bounds.getWidth();
    }
    
    public void setWidth(int width) {
        bounds.setWidth(width);
    }
    
    public float getHeight() {
        return bounds.getHeight();
    }
    
    public void setHeight(int height) {
        bounds.setHeight(height);
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
        bounds.setWidth(img.getWidth());
        bounds.setHeight(img.getHeight());
    }
    
    public float getImageWidth() {
        return img.getWidth();
    }
    
    public void setImageWidth(int width) {
        img = img.getScaledCopy(width, img.getHeight());
    }
    
    public float getImageHeight() {
        return img.getHeight();
    }
    
    public void setImageHeight(int height) {
        img = img.getScaledCopy(img.getWidth(), height);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.drawImage(img, x, y);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        bounds.setX(x);
        bounds.setY(y);
    }
    
}
