/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.Font;
import org.newdawn.slick.TrueTypeFont;

/**
 *
 * @author Patrick
 */
public class FontTool {

    public static TrueTypeFont titleFont = new TrueTypeFont(new Font("Verdana", Font.BOLD, 32), true);
    public static TrueTypeFont buttonFont = new TrueTypeFont(new Font("Verdana", Font.BOLD, 16), true);
    public static TrueTypeFont checkBoxFont = new TrueTypeFont(new Font("Verdana", Font.BOLD, 14), true);

    private FontTool() {
    }

}
