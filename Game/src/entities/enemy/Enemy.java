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
    
    private int life = 100;
    private boolean visible;

    public Enemy(float x, float y) {
        super(x, y);
    }
    
}
