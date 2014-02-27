/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import entities.bullet.Bullet;
import entities.player.Player;
import control.BulletManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tools.SettingsTool;
import game.Game;
import world.World;

/**
 *
 * @author Patrick
 */
public class PlayState extends BasicGameState {

    private final int id;
    private World world;
    private Runtime runtime;
    private float totalMemory = 0;
    private float freeMemory = 0;
    private float usedMemory = 0;

    public PlayState(int id) {
        this.id = id;
        runtime = Runtime.getRuntime();
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
        g.setColor(Color.white);
        g.fillRect(0, 0, container.getWidth(), container.getHeight());

        world.render(container, game, g);

        if (SettingsTool.getInstance().getPropertyAsBoolean("verbose")) {
            world.verboseRender(container, game, g);
            g.setColor(Color.white);
            g.drawString(String.valueOf(container.getFPS()), 10, 10);

            g.setColor(Color.white);
            g.drawString("Used memory: " + usedMemory, 200, 10);
            g.drawString("Free memory: " + freeMemory, 200, 30);
            g.drawString("Total memory: " + totalMemory, 200, 50);
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
