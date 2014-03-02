/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import world.level.Level1;
import world.level.LevelDefault;
import world.map.MapRenderer;

/**
 *
 * @author patrick
 */
public class LevelHandler {
    private Level1 level1;
    private LevelDefault levelDefault;
    
    private EnemyManager enemyManager;
    private MapRenderer mapRenderer;
    
    public LevelHandler(EnemyManager enemyManager, MapRenderer mapRenderer) {
        this.enemyManager = enemyManager;
        this.mapRenderer = mapRenderer;
        initLevels();
        mapRenderer.loadNewMap(level1.getBgLayer());
    }
    
    private void initLevels() {
        level1 = new Level1();
        levelDefault = new LevelDefault();
    }
    
    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        
    }
    
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }
    
    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }
    
    
}
