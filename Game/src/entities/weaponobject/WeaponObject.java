/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.weaponobject;

import entities.Sprite;

/**
 *
 * @author Patrick
 */
public abstract class WeaponObject extends Sprite {
    
    public static final int WEAPON_DOUBLE = 0;

    public WeaponObject(float x, float y) {
        super(x, y);
    }
    
}
