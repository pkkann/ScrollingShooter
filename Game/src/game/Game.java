/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import control.BulletManager;
import control.EnemyManager;
import control.LevelHandler;
import control.TileHandler;
import entities.player.Player;
import java.io.IOException;
import states.MenuState;
import states.PlayState;
import states.SettingsState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tools.SettingsTool;
import world.WorldGUI;
import world.level.LevelRenderer;

/**
 *
 * @author Patrick
 */
public class Game extends StateBasedGame {

    public static final String TITLE = "Game";
    
    public static final int MENUSTATE = 1;
    public static final int PLAYSTATE = 2;
    public static final int SETTINGSSTATE = 3;
    
    private final TileHandler tileManager;
    private final BulletManager bulletManager;
    private final EnemyManager enemyManager;
    private final LevelRenderer levelRenderer;
    private final LevelHandler levelHandler;
    private final Player player;
    
    public Game(String name) {
        super(name);
        tileManager = new TileHandler();
        enemyManager = new EnemyManager();
        bulletManager = new BulletManager(enemyManager);
        levelRenderer = new LevelRenderer(tileManager, enemyManager);
        levelHandler = new LevelHandler(levelRenderer);
        player = new Player(0, 0, bulletManager);
    }
    
    public static void main(String[] args) throws SlickException, IOException {
        
        AppGameContainer app = new AppGameContainer(new Game(TITLE));
        SettingsTool.getInstance().initLoadProperties(app);
        app.start();
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new MenuState(MENUSTATE));
        addState(new PlayState(PLAYSTATE, tileManager, bulletManager, enemyManager, levelRenderer, levelHandler, player));
        addState(new SettingsState(SETTINGSSTATE));
        
        getState(MENUSTATE).init(container, this);
        getState(PLAYSTATE).init(container, this);
        getState(SETTINGSSTATE).init(container, this);
        
        this.enterState(MENUSTATE);
    }
    
    
}
