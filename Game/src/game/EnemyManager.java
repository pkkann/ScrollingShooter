/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import entities.enemy.Enemy;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class EnemyManager {
    
    private ArrayList<Enemy> enemies;
    
    public EnemyManager() {
        enemies = new ArrayList<>();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    
    public void spawn(float x, float y, int type) {
        switch(type) {
            
        }
    }
    
    public void checkLifes() {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            Enemy e = i.next();
            if(e.getLife() <= 0) {
                e.setAlive(false);
            }
        }
    }
    
    public void removeEnemies() {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            if(!i.next().isAlive()) {
                i.remove();
            }
        }
    }
    
    public void renderEnemies(GameContainer container, StateBasedGame game, Graphics g) {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            Enemy e = i.next();
            
            e.render(container, game, g);
            e.verboseRender(container, game, g);
        }
    }
    
    public void updateEnemies(GameContainer container, StateBasedGame game, int delta) {
        Iterator<Enemy> i = enemies.iterator();
        
        while(i.hasNext()) {
            Enemy e = i.next();
            
            e.update(container, game, delta);
            e.verboseUpdate(container, game, delta);
        }
    }
    
}
