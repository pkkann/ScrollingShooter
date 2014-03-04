/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.level;

import tools.LevelFileReader;

/**
 *
 * @author patrick
 */
public class LevelDefault extends Level {
    
    private final int[][] bgLayer;
    private final String bgLayer_path;
    
    public LevelDefault() {
        super("LevelDefault");
        this.bgLayer_path = "res/levels/defaultLevel.txt";
        bgLayer = LevelFileReader.readLevel(bgLayer_path);
    }
    
    @Override
    public int[][] getBgLayer() {
        return bgLayer;
    }

    @Override
    public int[][] getEnemyLayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] getMidLayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
