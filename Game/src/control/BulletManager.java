/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Sprite;
import entities.bullet.Bullet;
import entities.bullet.GreenBullet;
import entities.bullet.RedBullet;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class BulletManager implements Manager {

    private ArrayList<Bullet> bullets;
    private final float topCount = 150;
    private float counter = topCount;

    public BulletManager() {
        bullets = new ArrayList<>();
    }

    public int getCurrentBulletCount() {
        return bullets.size();
    }

    @Override
    public Sprite spawnObject(int type, float x, float y) {
        Bullet b = null;
        if (counter <= 0) {

            switch (type) {
                case Bullet.BULLET_RED:
                    b = new RedBullet(x, y);
                    bullets.add(b);
                    break;
                case Bullet.BULLET_GREEN:
                    b = new GreenBullet(x, y);
                    bullets.add(b);
                    break;
            }

            counter = topCount;
        }
        return b;
    }

    @Override
    public void removeObjects() {
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            if (!i.next().isAlive()) {
                i.remove();
            }
        }
    }

    @Override
    public void renderObjects(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            Bullet b = i.next();
            b.render(container, game, g);
        }
    }

    @Override
    public void verboseRenderObjects(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            Bullet b = i.next();
            b.verboseRender(container, game, g);
        }
    }

    @Override
    public void updateObjects(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        counter -= 1 * delta;
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            Bullet b = i.next();
            b.update(container, game, delta);
        }
    }

    @Override
    public void verboseUpdateObjects(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Iterator<Bullet> i = bullets.iterator();

        while (i.hasNext()) {
            Bullet b = i.next();
            b.verboseUpdate(container, game, delta);
        }
    }

    @Override
    public void checkCollisions() {

    }

}
