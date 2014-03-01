/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import jellygui.JellyButton;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tools.FontTool;
import game.Game;

/**
 *
 * @author Patrick
 */
public class MenuState extends BasicGameState {

    private final int id;
    private JellyButton playButton;
    private JellyButton settingsButton;
    private JellyButton exitButton;
    
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
        g.setColor(Color.white);
        float btnX = (container.getWidth() / 2) - (playButton.getWidth() / 2);
        playButton.draw(g, btnX, 200);
        settingsButton.draw(g, btnX, 240);
        exitButton.draw(g, btnX, 280);
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        playButton.update(container, game, delta);
        settingsButton.update(container, game, delta);
        exitButton.update(container, game, delta);
    }
    
    private void initButtons() throws SlickException {
        Color textColor = Color.white;
        Color normalCol = Color.darkGray;
        Color hoverCol = Color.gray;
        int width = 100;
        int height = 30;
        
        playButton = new JellyButton("PLAY", textColor, FontTool.buttonFont, normalCol, hoverCol, width, height) {
            
            @Override
            public void action(GameContainer container, StateBasedGame game) {
                game.enterState(Game.PLAYSTATE);
            }
        };
        
        settingsButton = new JellyButton("SETTINGS", textColor, FontTool.buttonFont, normalCol, hoverCol, width, height) {
            
            @Override
            public void action(GameContainer container, StateBasedGame game) {
                game.enterState(Game.SETTINGSSTATE);
            }
        };
        
        exitButton = new JellyButton("EXIT", textColor, FontTool.buttonFont, normalCol, hoverCol, width, height) {
            
            @Override
            public void action(GameContainer container, StateBasedGame game) {
                container.exit();
            }
        };
    }
    
}
