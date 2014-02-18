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
public abstract class JellyButton implements JellyComponent {

    private float x, y;
    private Image iconNormal;
    private Image iconHover;
    private Image icon;
    private final Rectangle bounds;
    private final Rectangle mouse;

    public JellyButton() {
        mouse = new Rectangle(0, 0, 2, 2);
        bounds = new Rectangle(x, y, 0, 0);
    }

    public void setIconNormal(Image icon) {
        this.iconNormal = icon;
        this.icon = iconNormal;
        bounds.setWidth(getWidth());
        bounds.setHeight(getHeight());
    }

    public void setIconHover(Image icon) {
        if (iconNormal != null) {
            if (icon.getWidth() == iconNormal.getWidth() && icon.getHeight() == iconNormal.getHeight()) {
                this.iconHover = icon;
            } else {
                System.out.println("The iconHover needs to have the same width and height as iconNormal");
            }
        } else {
            System.out.println("iconNormal needs to be set first");
        }
    }

    public float getWidth() {
        return iconNormal.getWidth();
    }

    public float getHeight() {
        return iconNormal.getHeight();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Rectangle getBounds() {
        return bounds;
    }
    
    private void mouseOver(Input input) {
        if (mouse.intersects(bounds)) {
            icon = iconHover;
        } else {
            icon = iconNormal;
        }
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        this.x = x;
        this.y = y;
        bounds.setX(x);
        bounds.setY(y);
        g.drawImage(icon, x, y);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        
        mouse.setX(container.getInput().getMouseX());
        mouse.setY(container.getInput().getMouseY());
        
        mouseOver(container.getInput());
        
        if (mouse.intersects(bounds)) {
            if (container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                mousePressed(container, game);
            }
        }
    }
    
    public abstract void mousePressed(GameContainer container, StateBasedGame game);

}
