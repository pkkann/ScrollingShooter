/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import entities.player.Player;
import game.Game;
import static game.Game.PLAYSTATE;
import java.util.logging.Level;
import java.util.logging.Logger;
import jellygui.JellyButton;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tools.FontTool;

/**
 *
 * @author Patrick
 */
public class GameOverState extends BasicGameState {

    private int id;

    private Player player;

    private JellyButton startOverButton;
    private JellyButton menuButton;

    public GameOverState(int id, Player player) {
        this.id = id;
        this.player = player;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        Color textColor = Color.black;
        Color normalCol = Color.white;
        Color hoverCol = Color.orange;
        Color borderCol = Color.gray;
        int lineWidth = 5;
        int width = 200;
        int height = 40;

        startOverButton = new JellyButton("START OVER", textColor, FontTool.buttonFont, borderCol, lineWidth, normalCol, hoverCol, width, height) {

            @Override
            public void action(GameContainer container, StateBasedGame game) {
                player.setLife(100);
                player.setAlive(true);
                player.setScore(0);
                player.setDeathCount(0);
                Game.resetGame();
                game.enterState(Game.PLAYSTATE);
            }
        };

        menuButton = new JellyButton("MENU", textColor, FontTool.buttonFont, borderCol, lineWidth, normalCol, hoverCol, width, height) {

            @Override
            public void action(GameContainer container, StateBasedGame game) {
                player.setLife(100);
                player.setAlive(true);
                player.setScore(0);
                player.setDeathCount(0);
                Game.resetGame();
                game.enterState(Game.MENUSTATE);
            }
        };
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setFont(FontTool.titleFont);
        g.setColor(Color.white);
        g.drawString("GAME OVER", 405, 250);
        startOverButton.draw(g, 410, 300);
        menuButton.draw(g, 410, 350);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        startOverButton.update(container, game, delta);
        menuButton.update(container, game, delta);
    }

}
