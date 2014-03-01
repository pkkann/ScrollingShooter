/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jellygui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author patrick
 */
public abstract class JellyButton implements JellyComponent {

    private Image button, normal, hover;
    private String text;
    private TrueTypeFont font;
    private Rectangle bounds;
    private Rectangle mouse;
    private Color color, normalCol, hoverCol;
    private Color textColor;
    private int width, height;

    /**
     * Constructs a JellyButton. The image array should have normal image on 0,
     * and hover image on 1
     *
     * @param text
     * @param textColor
     * @param font
     * @param buttonImages
     */
    public JellyButton(String text, Color textColor, TrueTypeFont font, Image[] buttonImages) {
        this.normal = buttonImages[0];
        this.hover = buttonImages[1];
        this.button = normal;
        this.text = text;
        this.textColor = textColor;
        this.font = font;
        mouse = new Rectangle(0, 0, 2, 2);
        bounds = new Rectangle(0, 0, button.getWidth(), button.getHeight());
    }

    /**
     * Constructs a JellyButton.
     * @param text
     * @param textColor
     * @param font
     * @param normalCol
     * @param hoverCol
     * @param width
     * @param height 
     */
    public JellyButton(String text, Color textColor, TrueTypeFont font, Color normalCol, Color hoverCol, int width, int height) {
        this.normalCol = normalCol;
        this.hoverCol = hoverCol;
        this.color = normalCol;
        this.text = text;
        this.textColor = textColor;
        this.font = font;
        this.width = width;
        this.height = height;
        mouse = new Rectangle(0, 0, 2, 2);
        bounds = new Rectangle(0, 0, width, height);
    }
    
    public float getWidth() {
        return bounds.getWidth();
    }
    
    public float getHeight() {
        return bounds.getHeight();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    private void hover(Input input) {
        if(bounds.intersects(mouse)) {
            if(button != null) {
                button = hover;
            } else {
                color = hoverCol;
            }
        } else {
            if(button != null) {
                button = normal;
            } else {
                color = normalCol;
            }
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        mouse.setX(container.getInput().getMouseX());
        mouse.setY(container.getInput().getMouseY());
        hover(container.getInput());
        if (mouse.intersects(bounds)) {
            if (container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                action(container, game);
            }
        }
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        bounds.setX(x);
        bounds.setY(y);
        if (button != null) {
            button.draw(x, y);
            font.drawString(x + (button.getWidth() / 2) - (font.getWidth(text) / 2), y + (button.getHeight() / 2) - (font.getHeight() / 2), text, textColor);
        } else {
            g.setColor(color);
            g.fillRect(x, y, width, height);
            font.drawString(x + (width / 2) - (font.getWidth(text) / 2), y + (height / 2) - (font.getHeight() / 2), text, textColor);
        }

    }
    
    public abstract void action(GameContainer container, StateBasedGame game);

}
