/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import entities.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class PlayState extends BasicGameState {

    private int id;
    private Player player;
    private Image playerTexture;

    public PlayState(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        playerTexture = new Image("res/ship.png");
        player = new Player();
        player.setTexture(playerTexture);
        player.setScale(1);
        player.setX(container.getWidth() / 2);
        player.setY((container.getHeight() - 20) - player.getTexture().getHeight());
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        //Draw background color
        g.setColor(Color.white);
        g.fillRect(0, 0, container.getWidth(), container.getHeight());
        
        player.render(container, game, g);
        
        //Draw FPS
        g.setColor(Color.red);
        g.drawString(String.valueOf(container.getFPS()), 10, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        
        player.update(container, game, delta);
    }

}
