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
    
    private int width = 10;
    private int height = 10;

    public NormalBullet(float x, float y) {
        super(x, y);
        super.setSpeed(0.5f);
        super.setDamage(100);
        super.setLife(100);
        super.setWidth(width);
        super.setHeight(height);
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.setColor(Color.red);
        g.fillRect(super.getX(), super.getY(), width, height);
    }
    
}
