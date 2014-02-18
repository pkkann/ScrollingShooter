/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.io.IOException;
import states.MenuState;
import states.PlayState;
import states.SettingsState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import settings.SettingsTool;

/**
 *
 * @author Patrick
 */
public class Game extends StateBasedGame {

    public static final String TITLE = "Game";
    
    public static final int MENUSTATE = 1;
    public static final int PLAYSTATE = 2;
    public static final int SETTINGSSTATE = 3;
    
    public Game(String name) {
        super(name);
    }
    
    public static void main(String[] args) throws SlickException, IOException {
        
        AppGameContainer app = new AppGameContainer(new Game(TITLE));
        SettingsTool.getInstance().initLoadProperties(app);
        app.start();
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new MenuState(MENUSTATE));
        addState(new PlayState(PLAYSTATE));
        addState(new SettingsState(SETTINGSSTATE));
        
        getState(MENUSTATE).init(container, this);
        getState(PLAYSTATE).init(container, this);
        getState(SETTINGSSTATE).init(container, this);
        
        this.enterState(MENUSTATE);
    }
    
    
}
