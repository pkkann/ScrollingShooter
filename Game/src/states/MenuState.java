/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import game.Game;
import jellygui.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class MenuState extends BasicGameState {

    private final int id;
    private JellyButton playButton;
    private JellyButton quitButton;
    private JellyButton settingsButton;
    
    public MenuState(int id) {
        this.id = id;
    }
    
    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        initButtons();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        playButton.draw(g, (container.getWidth() / 2) - (playButton.getWidth() / 2), 200);
        settingsButton.draw(g, (container.getWidth() / 2) - (settingsButton.getWidth() / 2), 250);
        quitButton.draw(g, (container.getWidth() / 2) - (quitButton.getWidth() / 2), 300);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        playButton.update(container, game, delta);
        settingsButton.update(container, game, delta);
        quitButton.update(container, game, delta);
    }
    
    private void initButtons() throws SlickException {
        // Play
        playButton = new JellyButton() {

            @Override
            public void mousePressed(GameContainer container, StateBasedGame game) {
                game.enterState(Game.PLAYSTATE);
            }
        };
        
        playButton.setIconNormal(new Image("res/gui/play.png"));
        playButton.setIconHover(new Image("res/gui/play_wbg.png"));
        
        // Quit
        quitButton = new JellyButton() {

            @Override
            public void mousePressed(GameContainer container, StateBasedGame game) {
                container.exit();
            }
        };
        
        quitButton.setIconNormal(new Image("res/gui/quit.png"));
        quitButton.setIconHover(new Image("res/gui/quit_wbg.png"));
        
        // Settings
        settingsButton = new JellyButton() {

            @Override
            public void mousePressed(GameContainer container, StateBasedGame game) {
                game.enterState(Game.SETTINGSSTATE);
            }
        };
        
        settingsButton.setIconNormal(new Image("res/gui/settings.png"));
        settingsButton.setIconHover(new Image("res/gui/settings_wbg.png"));
    }
    
}
