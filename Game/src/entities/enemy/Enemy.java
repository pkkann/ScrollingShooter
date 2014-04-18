/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.enemy;

import entities.Sprite;

/**
 *
 * @author patrick
 */
public abstract class Enemy extends Sprite {
    
    public static final int ENEMY_ORANGE = 1;

    private int point = 1;
    
    public Enemy(float x, float y) {
        super(x, y);
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    
    
    
}
