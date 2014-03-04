/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import entities.player.Player;
import control.BulletManager;
import control.EnemyManager;
import control.LevelHandler;
import control.TileHandler;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import world.level.LevelRenderer;

/**
 *
 * @author patrick
 */
public class World {

    

    private final TileHandler tileManager;
    private final BulletManager bulletManager;
    private final EnemyManager enemyManager;
    private final LevelRenderer levelRenderer;
    private final LevelHandler levelHandler;
    private final Player player;
    private final WorldGUI worldGUI;

    public World() {
        tileManager = new TileHandler();
        bulletManager = new BulletManager();
        enemyManager = new EnemyManager();
        levelRenderer = new LevelRenderer(tileManager, enemyManager);
        levelHandler = new LevelHandler(levelRenderer);
        player = new Player(0, 0, bulletManager);
        worldGUI = new WorldGUI(player);
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        int width = container.getWidth();
        int height = container.getHeight();

        tileManager.init(container, game);
        levelHandler.init(container, game);

        player.setX((width / 2) - (player.getWidth() / 2));
        player.setY(height - player.getHeight() - 90);

        worldGUI.init(container, game);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        levelRenderer.render(container, game, g);
        bulletManager.renderObjects(container, game, g);
        enemyManager.renderObjects(container, game, g);
        player.render(container, game, g);
        worldGUI.render(container, game, g);
    }

    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        levelHandler.verboseRender(container, game, g);
        levelRenderer.verboseRender(container, game, g);
        bulletManager.verboseRenderObjects(container, game, g);
        enemyManager.verboseRenderObjects(container, game, g);
        player.verboseRender(container, game, g);
        worldGUI.verboseRender(container, game, g);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        levelHandler.update(container, game, delta);
        levelRenderer.update(container, game, delta);
        bulletManager.checkCollisions();
        bulletManager.updateObjects(container, game, delta);
        bulletManager.removeObjects();
        enemyManager.updateObjects(container, game, delta);
        enemyManager.removeObjects();
        player.update(container, game, delta);
        worldGUI.update(container, game, delta);
    }
    
    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        levelHandler.verboseUpdate(container, game, delta);
        levelRenderer.verboseUpdate(container, game, delta);
        bulletManager.verboseUpdateObjects(container, game, delta);
        enemyManager.verboseUpdateObjects(container, game, delta);
        player.verboseUpdate(container, game, delta);
        worldGUI.verboseUpdate(container, game, delta);
    }

}
