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
import entities.enemy.Enemy;
import entities.enemy.OrangeEnemy;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author patrick
 */
public class EnemyManager implements Manager {

    private ArrayList<Enemy> enemies;

    public EnemyManager() {
        enemies = new ArrayList<>();
    }

    @Override
    public Sprite spawnObject(int type, float x, float y) {
        Enemy e = null;

        switch (type) {
            case Enemy.ENEMY_ORANGE:
                e = new OrangeEnemy(x, y);
                enemies.add(e);
                break;
        }
        
        return e;
    }

    @Override
    public void removeObjects() {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            if(!i.next().isAlive()) {
                i.remove();
            }
        }
    }

    @Override
    public void checkCollisions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void renderObjects(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            i.next().render(container, game, g);
        }
    }

    @Override
    public void verboseRenderObjects(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            i.next().verboseRender(container, game, g);
        }
    }

    @Override
    public void updateObjects(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            i.next().update(container, game, delta);
        }
    }

    @Override
    public void verboseUpdateObjects(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            i.next().verboseUpdate(container, game, delta);
        }
    }

}
