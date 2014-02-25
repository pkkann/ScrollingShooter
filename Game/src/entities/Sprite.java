/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import settings.SettingsTool;

/**
 *
 * @author Patrick
 */
public abstract class Sprite implements Entity {
    
    Rectangle bounds;
    Image img;
    int life;
    int damage;
    boolean alive = true;
    
    public Sprite(float x, float y) {
        bounds = new Rectangle(x, y, 0,0);
        setX(x);
        setY(y);
    }
    
    public Sprite(Image img, float x, float y) {
        bounds = new Rectangle(x, y, img.getWidth(), img.getHeight());
        this.img = img;
        setX(x);
        setY(y);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public float getX() {
        return bounds.getX();
    }

    public final void setX(float x) {
        bounds.setX(x);
    }

    public float getY() {
        return bounds.getY();
    }

    public final void setY(float y) {
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public abstract void collision(Sprite s);

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.drawImage(img, getX(), getY());
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        bounds.setX(getX());
        bounds.setY(getY());
    }
    
    @Override
    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g) {
        if(SettingsTool.getInstance().getPropertyAsBoolean("verbose")) {
            g.setColor(Color.red);
            g.draw(bounds);
        }
    }
    
    @Override
    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta) {
        if(SettingsTool.getInstance().getPropertyAsBoolean("verbose")) {
            
        }
    }
    
}
