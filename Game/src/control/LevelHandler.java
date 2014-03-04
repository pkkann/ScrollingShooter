/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import world.level.Level;
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

    private LinkedList<Level> levels;

    public LevelHandler(EnemyManager enemyManager, MapRenderer mapRenderer) {
        this.enemyManager = enemyManager;
        this.mapRenderer = mapRenderer;
        levels = new LinkedList<>();
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        level1 = new Level1();
        levelDefault = new LevelDefault();

        levels.add(level1);
        levels.add(levelDefault);
    }

    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        System.out.println(mapRenderer.getLoadNextMap());
        if (!levels.isEmpty()) {
            if (!mapRenderer.getLoadNextMap()) {
                mapRenderer.loadNewMap(levels.pop().getBgLayer());
            }
        }

    }

    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

}
