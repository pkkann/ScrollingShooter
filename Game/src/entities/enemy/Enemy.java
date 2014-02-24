/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.enemy;

import entities.Sprite;

/**
 *
 * @author Patrick
 */
public abstract class Enemy extends Sprite {
    
    private float speed;

    public Enemy(float x, float y) {
        super(x, y);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    public void moveUp(int delta) {
        super.setY(super.getY() - speed * delta);
    }
    
    public void moveDown(int delta) {
        super.setY(super.getY() + speed * delta);
    }
    public void moveLeft(int delta) {
        super.setX(super.getX() - speed * delta);
    }
    public void moveRight(int delta) {
        super.setX(super.getX() + speed * delta);
    }
    
}
