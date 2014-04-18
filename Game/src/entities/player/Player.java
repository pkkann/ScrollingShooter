/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.player;

import control.BulletManager;
import entities.Sprite;
import entities.bullet.Bullet;
import entities.enemy.Enemy;
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
    private final BulletManager bManager;
    private final int width = 50;
    private final int height = 50;
    private int score = 0;

    public Player(float x, float y, BulletManager bManager) {
        super(x, y);
        this.bManager = bManager;
//        try {
//            super.setImg(new Image("res/plane.png"));
//        } catch (SlickException ex) {
//            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        super.setWidth(super.getImg().getWidth());
//        super.setHeight(super.getImg().getHeight());
        super.setLife(100);
        super.setWidth(50);
        super.setHeight(50);
        super.setDamage(100);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
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
            bManager.spawnObject(Bullet.BULLET_RED, super.getX() + (super.getWidth() / 2) - 6, super.getY() - 10);
        }
        
        if(input.isKeyDown(Input.KEY_F)) {
            bManager.spawnObject(Bullet.BULLET_GREEN, super.getX() + (super.getWidth() / 2) - 6, super.getY() - 10);
        }
    }

    @Override
    public void collision(Sprite s) {
        if(s instanceof Enemy) {
            s.setLife(s.getLife() - this.getDamage());
            this.setLife(this.getLife() - s.getDamage());
        }
    }
    
}
