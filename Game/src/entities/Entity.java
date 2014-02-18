/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import org.newdawn.slick.Graphics;

/**
 *
 * @author Patrick
 */
public interface Entity {
    
    public void render(Graphics g);
    public void update(int delta);
    
}
