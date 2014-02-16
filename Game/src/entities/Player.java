/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Player {
    
    private float x, y;
    private float scale;
    private Image texture;
    private Bullet bullet;
    
    public Player() throws SlickException {
        bullet = new Bullet(new Image("res/ship.png"));
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
    
    public float getScale() {
        return scale;
    }
    
    public void setScale(float scale) {
        this.scale = scale;
    }

    public Image getTexture() {
        return texture;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }
    
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        texture.draw(x, y, scale);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        if(x > 2 && input.isKeyDown(Input.KEY_A)) {
            x -= 1;
        }
        if(x < (container.getWidth() - 29) && input.isKeyDown(Input.KEY_D)) {
            x += 1;
        }
    }
    
}
