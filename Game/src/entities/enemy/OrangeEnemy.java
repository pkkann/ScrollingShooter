/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.enemy;

import entities.Sprite;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author patrick
 */
public class OrangeEnemy extends Enemy {
    
    private float speed = 0.5f;

    public OrangeEnemy(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        super.update(container, game, delta); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(super.getX(), super.getY(), 32, 32);
    }

    @Override
    public void collision(Sprite s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
