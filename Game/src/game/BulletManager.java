/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import entities.Bullet;
import entities.NormalBullet;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author Patrick
 */
public class BulletManager {

    private ArrayList<Bullet> bullets;
    private float counter = 150;

    public BulletManager() {
        bullets = new ArrayList<>();
    }

    public int getCurrentBulletCount() {
        return bullets.size();
    }

    public Bullet spawnBullet(int type, Image img, float x, float y) {
        Bullet b = null;
        if (counter <= 0) {
            
            switch (type) {
                case Bullet.BULLET_NORMAL:
                    b = new NormalBullet(img, x, y);
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

    public void renderBullets(Graphics g) {
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            i.next().render(g);
        }
    }

    public void updateBullets(int delta) {
        counter -= 1 * delta;
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            i.next().update(delta);
        }
    }

}
