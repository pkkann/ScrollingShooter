/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.level;

import tools.LevelFileReader;

/**
 *
 * @author Patrick
 */
public class Level2 extends Level {
    
    private final int[][] bgLayer;
    private final String bgLayer_path;
    
    private final int[][] enemyLayer;
    private final String enemyLayer_Path;

    public Level2() {
        super("Level 2");
        this.bgLayer_path = "res/levels/level2_bg.txt";
        bgLayer = LevelFileReader.readLevel(bgLayer_path);
        
        this.enemyLayer_Path = "res/levels/level2_en.txt";
        enemyLayer = LevelFileReader.readLevel(enemyLayer_Path);
    }

    @Override
    public int[][] getBgLayer() {
        return bgLayer;
    }

    @Override
    public int[][] getEnemyLayer() {
        return enemyLayer;
    }

    @Override
    public int[][] getMidLayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
