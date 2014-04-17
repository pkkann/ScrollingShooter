/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import control.BulletManager;
import control.EnemyManager;
import control.LevelHandler;
import control.TileHandler;
import entities.player.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tools.SettingsTool;
import game.Game;
import world.World;
import world.level.LevelRenderer;

/**
 *
 * @author Patrick
 */
public class PlayState extends BasicGameState {

    private final int id;
    private World world;
    private final Runtime runtime;
    private float totalMemory = 0;
    private float freeMemory = 0;
    private float usedMemory = 0;
    
    private final TileHandler tileHandler;
    private final BulletManager bulletManager;
    private final EnemyManager enemyManager;
    private final LevelRenderer levelRenderer;
    private final LevelHandler levelHandler;
    private final Player player;

    public PlayState(int id, TileHandler tileHandler, BulletManager bulletManager, EnemyManager enemyManager, LevelRenderer levelRenderer, LevelHandler levelHandler, Player player) {
        this.id = id;
        this.tileHandler = tileHandler;
        this.bulletManager = bulletManager;
        this.enemyManager = enemyManager;
        this.levelRenderer = levelRenderer;
        this.levelHandler = levelHandler;
        this.player = player;
        runtime = Runtime.getRuntime();
        
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        world = new World(tileHandler, bulletManager, enemyManager, levelRenderer, levelHandler, player);
        world.init(container, game);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.fillRect(0, 0, container.getWidth(), container.getHeight());

        world.render(container, game, g);

        if (SettingsTool.getInstance().getPropertyAsBoolean("verbose")) {
            world.verboseRender(container, game, g);
            g.setColor(Color.white);
            g.drawString("FPS: " + String.valueOf(container.getFPS()), 10, 10);

            g.setColor(Color.white);
            g.drawString("Used memory: " + usedMemory, 10, 40);
            g.drawString("Free memory: " + freeMemory, 10, 70);
            g.drawString("Total memory: " + totalMemory, 10, 100);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        world.update(container, game, delta);

        if (container.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            game.enterState(Game.MENUSTATE);
        }

        if (SettingsTool.getInstance().getPropertyAsBoolean("verbose")) {
            world.verboseUpdate(container, game, delta);

            usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / 1024;
            freeMemory = runtime.freeMemory() / 1024;
            totalMemory = runtime.totalMemory() / 1024;
        }
    }

}
