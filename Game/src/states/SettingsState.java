/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import control.FontManager;
import game.Game;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jellygui.JellyButton;
import jellygui.JellyCheckbox;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import settings.SettingsTool;

/**
 *
 * @author Patrick
 */
public class SettingsState extends BasicGameState {

    private final int id;
    private JellyButton backButton;
    private JellyButton saveButton;
    private JellyCheckbox verboseBox;
    private JellyCheckbox updateOnlyWhenVisibleBox;
    private JellyCheckbox fullscreenBox;

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
        g.setColor(Color.white);
        FontManager.titleFont.drawString(150, 100, "SETTINGS", Color.white);
        
        verboseBox.draw(g, 400, 200);
        updateOnlyWhenVisibleBox.draw(g, 400, 250);
        fullscreenBox.draw(g, 400, 300);
        
        backButton.draw(g, 700, 550);
        saveButton.draw(g, 600, 550);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        verboseBox.update(container, game, delta);
        updateOnlyWhenVisibleBox.update(container, game, delta);
        fullscreenBox.update(container, game, delta);
        
        backButton.update(container, game, delta);
        saveButton.update(container, game, delta);
    }

    private void initGUI(GameContainer container, StateBasedGame game) throws SlickException {
        //BackButton
        backButton = new JellyButton() {

            @Override
            public void mousePressed(GameContainer container, StateBasedGame game) {
                game.enterState(Game.MENUSTATE);
            }
        };
        backButton.setIconNormal(new Image("res/gui/back.png"));
        backButton.setIconHover(new Image("res/gui/back_wbg.png"));
        
        //VerboseBOx
        verboseBox = new JellyCheckbox();
        verboseBox.setLabel("VERBOSE");
        verboseBox.setCheckedImage(new Image("res/gui/checkbox_checked.png"));
        verboseBox.setUncheckedImage(new Image("res/gui/checkbox_unchecked.png"));
        verboseBox.setChecked(SettingsTool.getInstance().getPropertyAsBoolean("verbose"));
        
        //UpdateOnlyWhenVisible
        updateOnlyWhenVisibleBox = new JellyCheckbox();
        updateOnlyWhenVisibleBox.setLabel("Update only when visible");
        updateOnlyWhenVisibleBox.setCheckedImage(new Image("res/gui/checkbox_checked.png"));
        updateOnlyWhenVisibleBox.setUncheckedImage(new Image("res/gui/checkbox_unchecked.png"));
        updateOnlyWhenVisibleBox.setChecked(SettingsTool.getInstance().getPropertyAsBoolean("updateOnlyWhenVisible"));
        
        //Fullscreen
        fullscreenBox = new JellyCheckbox();
        fullscreenBox.setLabel("Fullscreen");
        fullscreenBox.setCheckedImage(new Image("res/gui/checkbox_checked.png"));
        fullscreenBox.setUncheckedImage(new Image("res/gui/checkbox_unchecked.png"));
        fullscreenBox.setChecked(SettingsTool.getInstance().getPropertyAsBoolean("fullscreen"));

        //SaveButton
        saveButton = new JellyButton() {

            @Override
            public void mousePressed(GameContainer container, StateBasedGame game) {
                //Get gui sets
                boolean verbose = verboseBox.isChecked();
                boolean uowv = updateOnlyWhenVisibleBox.isChecked();
                boolean fullscreen = fullscreenBox.isChecked();
                
                //Save settings and go to menu
                SettingsTool.getInstance().setProperty("verbose", verbose);
                SettingsTool.getInstance().setProperty("updateOnlyWhenVisible", uowv);
                SettingsTool.getInstance().setProperty("fullscreen", fullscreen);
                
                try {
                    SettingsTool.getInstance().saveProperties();
                    SettingsTool.getInstance().reloadProperties(container);
                } catch (IOException | SlickException ex) {
                    Logger.getLogger(SettingsState.class.getName()).log(Level.SEVERE, null, ex);
                }
                game.enterState(Game.MENUSTATE);
            }
        };
        saveButton.setIconNormal(new Image("res/gui/save.png"));
        saveButton.setIconHover(new Image("res/gui/save_wbg.png"));
    }

}
