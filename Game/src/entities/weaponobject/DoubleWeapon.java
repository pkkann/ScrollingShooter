/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.weaponobject;

import entities.Sprite;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class DoubleWeapon extends WeaponObject {
    
    private int speed;

    public DoubleWeapon(float x, float y, int speed) {
        super(x, y);
        this.speed = speed;
        super.setWidth(32);
        super.setHeight(32);
        super.setLife(1);
        super.setDamage(0);
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        super.update(container, game, delta); //To change body of generated methods, choose Tools | Templates.
        super.setY(super.getY() + speed * delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.setColor(Color.black);
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

    @Override
    public void collision(Sprite s) {
        
    }
    
}
