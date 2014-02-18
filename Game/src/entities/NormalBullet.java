/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author Patrick
 */
public class NormalBullet extends Bullet {

    public NormalBullet(Image img, float x, float y) {
        super(img, x, y);
        speed = 0.5f;
    }
    
}
