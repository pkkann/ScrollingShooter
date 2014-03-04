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
public class JellyCheckBox implements JellyComponent {

    private Image img, checkedImg, uncheckedImg;
    private final String text;
    private final TrueTypeFont font;
    private final Rectangle bounds;
    private final Rectangle mouse;
    private Color checkedCol, uncheckedCol;
    private final Color textColor;
    private int width, height;
    private boolean checked = false;
    private int inlineWidth;

    public JellyCheckBox(String text, Color textColor, TrueTypeFont font, Image[] cbImgs) {
        this.checkedImg = cbImgs[0];
        this.uncheckedImg = cbImgs[2];
        this.img = uncheckedImg;
        this.text = text;
        this.textColor = textColor;
        this.font = font;
        mouse = new Rectangle(0, 0, 2, 2);
        bounds = new Rectangle(0, 0, checkedImg.getWidth(), checkedImg.getHeight());
    }

    public JellyCheckBox(String text, Color textColor, TrueTypeFont font, int inlineWidth, Color checkedCol, Color uncheckedCol, int width, int height) {
        this.text = text;
        this.textColor = textColor;
        this.font = font;
        this.checkedCol = checkedCol;
        this.uncheckedCol = uncheckedCol;
        this.inlineWidth = inlineWidth;
        this.width = width;
        this.height = height;
        mouse = new Rectangle(0, 0, 2, 2);
        bounds = new Rectangle(0, 0, width, height);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public float getWidth() {
        return bounds.getWidth();
    }

    public float getHeight() {
        return bounds.getHeight();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        mouse.setX(container.getInput().getMouseX());
        mouse.setY(container.getInput().getMouseY());
        
        if (mouse.intersects(bounds)) {
            if (container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                clicked(container, game);
            }
        }
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        bounds.setX(x);
        bounds.setY(y);
        if(img != null) {
            img.draw(x, y);
        } else {
            g.setColor(uncheckedCol);
            g.fillRect(x, y, width, height);
            if(checked) {
                g.setColor(checkedCol);
                g.fillRect(x + inlineWidth, y + inlineWidth, width - (inlineWidth * 2), height - (inlineWidth * 2));
            }
        }
        g.setColor(textColor);
        font.drawString(x + width + 10, y + (height / 2) - (font.getHeight() / 2), text, textColor);
    }

    private void clicked(GameContainer container, StateBasedGame game) {
        if (this.isChecked()) {
            setChecked(false);
        } else {
            setChecked(true);
        }
    }

}
