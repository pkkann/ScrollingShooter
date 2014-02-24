/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

import entities.player.Player;
import game.BulletManager;
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
    private Player player;
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        int width = container.getWidth();
        int height = container.getHeight();
        
        bulletManager = new BulletManager();
        
        player = new Player(0, 0, bulletManager);
        player.setX((width / 2) - (player.getWidth() / 2));
        player.setY(height - player.getHeight() - 20);
    }
    
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        bulletManager.renderBullets(container, game, g);
        player.render(container, game, g);
        
    }
    
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
        bulletManager.checkCollisions();
        bulletManager.updateBullets(container, game, delta);
        bulletManager.removeBullets();
        
        player.update(container, game, delta);
        
    }
    
}
