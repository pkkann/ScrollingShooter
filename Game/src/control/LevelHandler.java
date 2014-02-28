/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.ArrayList;
import java.util.logging.Level;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author patrick
 */
public class LevelHandler {
    
    private ArrayList<Level> levels;
    
    private EnemyManager enemyManager;
    
    public LevelHandler(EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
        levels = new ArrayList<>();
    }
    
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        
    }
    
    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        
    }
    
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }
    
    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }
    
    
}
