/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.bullet;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class NormalBullet extends Bullet {

    public NormalBullet(float x, float y) {
        super(x, y);
        super.setSpeed(0.5f);
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.setColor(Color.red);
        g.fillRect(super.getX(), super.getY(), 10, 10);
    }
    
}
