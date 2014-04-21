/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.bullet;

import entities.Sprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public abstract class Bullet extends Sprite {
    
    private float speed;
    
    public static final int BULLET_RED = 0;
    public static final int BULLET_RED_MULTI = 1;

    public Bullet(float x, float y) {
        super(x, y);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    @Override
    public void collision(Sprite s) {
        s.setLife(s.getLife() - super.getDamage());
        super.setAlive(false);
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        super.update(container, game, delta);
        super.setY(super.getY() - speed * delta);
        
        if(super.getY() < -50) {
            setAlive(false);
        }
    }
}
