/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.bullet;

import entities.Sprite;

/**
 *
 * @author Patrick
 */
public abstract class Bullet extends Sprite {
    
    private boolean alive = true;
    private float lifeTime;
    private float speed;
    
    public static final int BULLET_NORMAL = 0;

    public Bullet(float x, float y) {
        super(x, y);
    }
    
    public float getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(float lifeTime) {
        this.lifeTime = lifeTime;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    @Override
    public void update(int delta) {
        super.update(delta);
        lifeTime += 1 * delta;
        super.setY(super.getY() - speed * delta);
        
        if(super.getY() < -50) {
            setAlive(false);
        }
    }
}
