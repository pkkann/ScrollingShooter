/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

import entities.player.Player;
import entities.test.TestBox;
import game.BulletManager;
import game.TestBoxManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author patrick
 */
public class World {
    
    private BulletManager bulletManager;
    private TestBoxManager testBoxManager;
    private Player player;
    private TestBox tb;
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        int width = container.getWidth();
        int height = container.getHeight();
        
        testBoxManager = new TestBoxManager();
        bulletManager = new BulletManager(testBoxManager);
        
        player = new Player(0, 0, bulletManager);
        player.setX((width / 2) - (player.getWidth() / 2));
        player.setY(height - player.getHeight() - 20);
        
        testBoxManager.spawn(200, 50);
        testBoxManager.spawn(300, 50);
        testBoxManager.spawn(400, 50);
        testBoxManager.spawn(500, 50);
    }
    
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        testBoxManager.renderTestBoxes(container, game, g);
        bulletManager.renderBullets(container, game, g);
        player.render(container, game, g);
        
    }
    
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        testBoxManager.checkLifes();
        testBoxManager.removeTestBoxes();
        testBoxManager.updateTestBoxes(container, game, delta);
        
        bulletManager.checkCollisions();
        bulletManager.updateBullets(container, game, delta);
        bulletManager.removeBullets();
        
        player.update(container, game, delta);
        
    }
    
}
