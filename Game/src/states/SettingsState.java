/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import tools.FontTool;
import game.Game;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jellygui.JellyButton;
import jellygui.JellyCheckBox;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tools.SettingsTool;

/**
 *
 * @author Patrick
 */
public class SettingsState extends BasicGameState {

    private final int id;
    private JellyButton backButton;
    private JellyButton saveButton;
    private JellyCheckBox verboseBox;
    private JellyCheckBox updateOnlyWhenVisibleBox;
    private JellyCheckBox fullscreenBox;

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
        FontTool.titleFont.drawString(150, 100, "SETTINGS", Color.white);

        verboseBox.draw(g, 400, 200);
        updateOnlyWhenVisibleBox.draw(g, 400, 250);
        fullscreenBox.draw(g, 400, 300);

        backButton.draw(g, 710, 550);
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
        Color textColor = Color.white;
        Color checkedCol = Color.orange;
        Color uncheckedCol = Color.darkGray;
        int inlineWidth = 8;
        int widthChk = 30;
        int heightChk = 30;
        
        verboseBox = new JellyCheckBox("Verbose", textColor, FontTool.checkBoxFont, inlineWidth, checkedCol, uncheckedCol, widthChk, heightChk);
        verboseBox.setChecked(SettingsTool.getInstance().getPropertyAsBoolean("verbose"));
        updateOnlyWhenVisibleBox = new JellyCheckBox("Update only when visible", textColor, FontTool.checkBoxFont, inlineWidth, checkedCol, uncheckedCol, widthChk, heightChk);
        updateOnlyWhenVisibleBox.setChecked(SettingsTool.getInstance().getPropertyAsBoolean("updateOnlyWhenVisible"));
        fullscreenBox = new JellyCheckBox("Fullscreen", textColor, FontTool.checkBoxFont, inlineWidth, checkedCol, uncheckedCol, widthChk, heightChk);
        fullscreenBox.setChecked(SettingsTool.getInstance().getPropertyAsBoolean("fullscreen"));
        
        
        Color normalCol = Color.darkGray;
        Color hoverCol = Color.gray;
        Color borderCol = Color.gray;
        int lineWidth = 2;
        int widthBtn = 100;
        int heightBtn = 30;

        backButton = new JellyButton("BACK", textColor, FontTool.buttonFont, borderCol, lineWidth, normalCol, hoverCol, widthBtn, heightBtn) {

            @Override
            public void action(GameContainer container, StateBasedGame game) {
                game.enterState(Game.MENUSTATE);
            }
        };

        saveButton = new JellyButton("SAVE", textColor, FontTool.buttonFont, borderCol, lineWidth, normalCol, hoverCol, widthBtn, heightBtn) {

            @Override
            public void action(GameContainer container, StateBasedGame game) {
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
    }

}
