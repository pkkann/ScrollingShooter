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
import tools.FontTool;
import world.level.Level;
import world.level.Level1;
import world.level.Level2;
import world.level.LevelDefault;
import world.level.LevelRenderer;

/**
 *
 * @author patrick
 */
public class LevelHandler {

    private Level1 level1;
    private Level2 level2;
    private LevelDefault levelDefault;

    private final LevelRenderer levelRenderer;

    private final LinkedList<Level> levels;
    private Level currentLevel;
    
    private int tickCount = 0;

    public LevelHandler(LevelRenderer levelRenderer) {
        this.levelRenderer = levelRenderer;
        levels = new LinkedList<>();
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        level1 = new Level1();
        level2 = new Level2();
        levelDefault = new LevelDefault();

        levels.add(level1);
        levels.add(level2);
        levels.add(levelDefault);
        currentLevel = levelDefault;
        
        levelRenderer.loadNewLevelInstantly(currentLevel);
    }
    
    private void nextLevel() {
        currentLevel = levels.pop();
        levelRenderer.loadNewLevel(currentLevel);
        tickCount = 0;
    }
    
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        if(tickCount <= 600 && !currentLevel.getName().isEmpty()) {
            g.setColor(Color.darkGray);
            g.fillRect(340, 250, 350, 100);
            g.setColor(Color.white);
            g.setFont(FontTool.smallTitleFont);
            g.drawString(currentLevel.getName(), 340 + (350 / 2) - (FontTool.smallTitleFont.getWidth(currentLevel.getName()) / 2), 250 + 50 - (FontTool.smallTitleFont.getHeight() / 2) - 6);
        }
    }

    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString("Current level: " + currentLevel.getName(), 10, 130);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        tickCount++;
        if (!levels.isEmpty()) {
            if (!levelRenderer.isLoadingNextLevel()) {
                nextLevel();
            }
        }
    }

    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }

}
