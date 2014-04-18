/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Sprite;
import entities.bullet.Bullet;
import entities.enemy.Enemy;
import entities.enemy.OrangeEnemy;
import entities.player.Player;
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
public class EnemyManager implements SpriteManager {

    private final ArrayList<Enemy> enemies;
    private Player player;
    private BulletManager bulletManager;

    public EnemyManager(Player player, BulletManager bulletManager) {
        this.player = player;
        this.bulletManager = bulletManager;
        enemies = new ArrayList<>();
    }
    
    public ArrayList<Enemy> getEnemies() {
        return enemies;
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
            Enemy e = i.next();
            if(!e.isAlive()) {
                player.setScore(player.getScore() + e.getPoint());
                i.remove();
            }
        }
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

    @Override
    public void checkCollisions() {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            Enemy e = i.next();
            Iterator<Bullet> ib = bulletManager.getBullets().iterator();
            while(ib.hasNext()) {
                Bullet b = ib.next();
                if(e.getBounds().intersects(b.getBounds())) {
                    b.setAlive(false);
                    e.collision(b);
                }
            }
            
            if(e.getBounds().intersects(player.getBounds())) {
                player.collision(e);
            }
        }
    }

    @Override
    public void SetAliveOnObjects() {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            Enemy e = i.next();
            
            if(e.getLife() <= 0) {
                e.setAlive(false);
            }
        }
    }

}
