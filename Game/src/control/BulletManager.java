/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.bullet.Bullet;
import entities.bullet.NormalBullet;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.TestBox;

/**
 *
 * @author Patrick
 */
public class BulletManager {

    private ArrayList<Bullet> bullets;
    private final float topCount = 150;
    private float counter = topCount;

    public BulletManager() {
        bullets = new ArrayList<>();
    }

    public int getCurrentBulletCount() {
        return bullets.size();
    }

    public Bullet spawnBullet(int type, float x, float y) {
        Bullet b = null;
        if (counter <= 0) {
            
            switch (type) {
                case Bullet.BULLET_NORMAL:
                    b = new NormalBullet(x, y);
                    bullets.add(b);
                    break;
            }
            
            counter = topCount;
        }
        return b;
    }

    public void removeBullets() {
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            if (!i.next().isAlive()) {
                i.remove();
            }
        }
    }

    public void renderBullets(GameContainer container, StateBasedGame game, Graphics g) {
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            Bullet b = i.next();
            b.render(container, game, g);
            b.verboseRender(container, game, g);
        }
    }

    public void updateBullets(GameContainer container, StateBasedGame game, int delta) {
        counter -= 1 * delta;
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            Bullet b = i.next();
            b.update(container, game, delta);
            b.verboseUpdate(container, game, delta);
        }
    }
    
    public void checkCollisions() {
        
    }

}
