/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.player;

import entities.Sprite;
import entities.bullet.Bullet;
import control.BulletManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
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
public class Player extends Sprite {
    
    private float speed = 0.5f;
    private final BulletManager bManager;
    private final int width = 50;
    private final int height = 50;

    public Player(float x, float y, BulletManager bManager) {
        super(x, y);
        this.bManager = bManager;
        try {
            super.setImg(new Image("res/plane.png"));
        } catch (SlickException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.setWidth(super.getImg().getWidth());
        super.setHeight(super.getImg().getHeight());
        super.setLife(100);
        
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
//    @Override
//    public void render(GameContainer container, StateBasedGame game, Graphics g) {
//        g.setColor(Color.blue);
//        g.fillRect(super.getX(), super.getY(), width, height);
//    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        super.update(container, game, delta);
        move(container, delta);
    }
    
    private void move(GameContainer container, int delta) {
        Input input = container.getInput();
        
        if(input.isKeyDown(Input.KEY_A)) {
            super.setX(super.getX() - speed * delta);
        }
        
        if(input.isKeyDown(Input.KEY_D)) {
            super.setX(super.getX() + speed * delta);
        }
        
        if(input.isKeyDown(Input.KEY_SPACE)) {
            bManager.spawnObject(Bullet.BULLET_RED, super.getX() + (super.getWidth() / 2) - 6, super.getY() - 10);
        }
        
        if(input.isKeyDown(Input.KEY_F)) {
            bManager.spawnObject(Bullet.BULLET_GREEN, super.getX() + (super.getWidth() / 2) - 6, super.getY() - 10);
        }
    }

    @Override
    public void collision(Sprite s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
