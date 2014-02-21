/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import entities.bullet.Bullet;
import entities.player.Player;
import game.BulletManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import settings.SettingsTool;
import game.Game;
import world.World;

/**
 *
 * @author Patrick
 */
public class PlayState extends BasicGameState {

    private final int id;
    private World world;

    public PlayState(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        world = new World();
        world.init(container, game);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        //Draw background color
        g.setColor(Color.white);
        g.fillRect(0, 0, container.getWidth(), container.getHeight());

        world.render(container, game, g);
        
        if (SettingsTool.getInstance().getPropertyAsBoolean("verbose")) {
            g.setColor(Color.red);
            g.drawString(String.valueOf(container.getFPS()), 10, 10);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
        world.update(container, game, delta);
        
        if(container.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            game.enterState(Game.MENUSTATE);
        }
    }

}
