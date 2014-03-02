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
public class LevelDefault {
    
    private int[][] bgLayer;
    private String bgLayer_path = "res/levels/defaultLevel.txt";
    
    public LevelDefault() {
        loadLayers();
    }
    
    private void loadLayers() {
        bgLayer = LevelFileReader.readLevel(bgLayer_path);
    }
    
    public int[][] getBgLayer() {
        return bgLayer;
    }
    
}
