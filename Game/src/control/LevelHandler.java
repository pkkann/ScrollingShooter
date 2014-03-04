/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import world.level.Level;
import world.level.Level1;
import world.level.LevelDefault;
import world.level.LevelRenderer;
import world.level.MapRenderer;

/**
 *
 * @author patrick
 */
public class LevelHandler {

    private Level1 level1;
    private LevelDefault levelDefault;

    private final LevelRenderer levelRenderer;

    private final LinkedList<Level> levels;
    private Level currentLevel;

    public LevelHandler(LevelRenderer levelRenderer) {
        this.levelRenderer = levelRenderer;
        levels = new LinkedList<>();
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        level1 = new Level1();
        levelDefault = new LevelDefault();

        levels.add(level1);
        levels.add(levelDefault);
        currentLevel = levelDefault;
        
        levelRenderer.loadNewLevelInstantly(currentLevel);
    }
    
    private void nextLevel() {
        currentLevel = levels.pop();
        levelRenderer.loadNewLevel(currentLevel);
    }

    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString("Current level: " + currentLevel.getName(), 10, 130);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (!levels.isEmpty()) {
            if (!levelRenderer.isLoadingNextLevel()) {
                nextLevel();
            }
        }
    }

    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }

}
