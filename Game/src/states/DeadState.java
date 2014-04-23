/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import entities.player.Player;
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
public class DeadState extends BasicGameState {

    private int id;

    private Player player;

    private JellyButton endButton;

    private String scoreName = "";

    public DeadState(int id, Player player) {
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

        endButton = new JellyButton("EXIT", textColor, FontTool.buttonFont, borderCol, lineWidth, normalCol, hoverCol, width, height) {

            @Override
            public void action(GameContainer container, StateBasedGame game) {
                container.exit();
            }
        };
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setFont(FontTool.titleFont);
        g.setColor(Color.white);
        g.drawString("You Died", 430, 250);
        g.setFont(FontTool.smallTitleFont);
        g.setColor(Color.white);
        g.drawString("Your score: " + player.getScore(), 425, 300);
        endButton.draw(g, 413, 360);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        endButton.update(container, game, delta);
    }

}
