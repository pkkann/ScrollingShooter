/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import entities.bullet.Bullet;
import entities.bullet.NormalBullet;
import entities.test.TestBox;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class BulletManager {
    
    private TestBoxManager tbManager;

    private ArrayList<Bullet> bullets;
    private float counter = 150;

    public BulletManager(TestBoxManager tbManager) {
        this.tbManager = tbManager;
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
            
            counter = 150;
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
        
        Iterator<Bullet> i = bullets.iterator();
        
        while(i.hasNext()) {
            Bullet b = i.next();
            Iterator<TestBox> it = tbManager.getTestBoxes().iterator();
            
            while(it.hasNext()) {
                TestBox tb = it.next();
                
                if(b.getBounds().intersects(tb.getBounds())) {
                    b.collision(tb);
                }
            }
        }
    }

}
