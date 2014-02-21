/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.player;

import entities.Sprite;
import entities.bullet.Bullet;
import game.BulletManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Player extends Sprite {
    
    private float speed = 0.5f;
    private BulletManager bManager;
    private int width = 50;
    private int height = 50;
    private int life = 100;

    public Player(float x, float y, BulletManager bManager) {
        super(x, y);
        this.bManager = bManager;
        super.setWidth(width);
        super.setHeight(height);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(super.getX(), super.getY(), width, height);
    }
    
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
            bManager.spawnBullet(Bullet.BULLET_NORMAL, super.getX() + (super.getWidth() / 2) - 6, super.getY());
        }
    }
    
}