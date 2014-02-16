/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import game.FontManager;
import game.Game;
import jellygui.JellyButton;
import jellygui.JellyCheckbox;
import org.newdawn.slick.Color;
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
public class SettingsState extends BasicGameState {
    
    private int id;
    private JellyButton backButton;
    private JellyCheckbox vsyncBox;
    
    public SettingsState(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        initGUI(container, game);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        FontManager.titleFont.drawString(150, 100, "SETTINGS", Color.white);
        g.drawString("All settings are set instantly", 150, 140);
        vsyncBox.draw(g, 400, 200);
        backButton.draw(g, 700, 550);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        vsyncBox.update(container, game, delta);
        backButton.update(container, game, delta);
        container.setVSync(this.vsyncBox.isChecked());
    }
    
    private void initGUI(GameContainer container, StateBasedGame game) throws SlickException {
        backButton = new JellyButton() {

            @Override
            public void mousePressed(GameContainer container, StateBasedGame game) {
                game.enterState(Game.MENUSTATE);
            }
        };
        backButton.setIconNormal(new Image("res/gui/back.png"));
        backButton.setIconHover(new Image("res/gui/back_wbg.png"));
        
        vsyncBox = new JellyCheckbox();
        vsyncBox.setLabel("VSYNC");
        vsyncBox.setCheckedImage(new Image("res/gui/checkbox_checked.png"));
        vsyncBox.setUncheckedImage(new Image("res/gui/checkbox_unchecked.png"));
        vsyncBox.setChecked(container.isVSyncRequested());
    }
    
}
