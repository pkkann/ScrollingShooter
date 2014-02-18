/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jellygui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import settings.SettingsTool;

/**
 *
 * @author Patrick
 */
public class JellyCheckbox implements JellyComponent {

    private Image uncheckedImg;
    private Image checkedImg;
    private Image icon;
    private final Rectangle bounds;
    private final Rectangle mouse;
    private boolean checked = false;
    private String label;

    public JellyCheckbox() {
        mouse = new Rectangle(0, 0, 2, 2);
        bounds = new Rectangle(0, 0, 0, 0);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCheckedImage(Image img) {
        this.checkedImg = img;
        bounds.setWidth(checkedImg.getWidth());
        bounds.setHeight(checkedImg.getHeight());
    }

    public void setUncheckedImage(Image img) {
        if (checkedImg != null) {
            if (checkedImg.getWidth() == img.getWidth() && checkedImg.getHeight() == img.getHeight()) {
                uncheckedImg = img;
                icon = img;
            } else {
                System.out.println("Width and height needs to be the same as the checked image");
            }
        } else {
            System.out.println("You need to set checked image first");
        }
    }

    public float getX() {
        return bounds.getX();
    }

    public float getY() {
        return bounds.getY();
    }

    public float getWidth() {
        return icon.getWidth();
    }

    public float getHeight() {
        return icon.getHeight();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        if (checked) {
            icon = this.checkedImg;
        } else {
            icon = this.uncheckedImg;
        }
    }

    public boolean isChecked() {
        return checked;
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        bounds.setX(x);
        bounds.setY(y);

        g.drawImage(icon, x, y);
        g.drawString(label, x + getWidth() + 10, y);
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

    public void clicked(GameContainer container, StateBasedGame game) {
        if (this.isChecked()) {
            setChecked(false);
        } else {
            setChecked(true);
        }
    }

}
