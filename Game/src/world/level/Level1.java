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
public class Level1 extends Level {

    private final int[][] bgLayer;
    private final String bgLayer_path;
    
    private final int[][] enemyLayer;
    private final String enemyLayer_Path;

    public Level1() {
        super("Level1");
        this.bgLayer_path = "res/levels/level1_bg.txt";
        bgLayer = LevelFileReader.readLevel(bgLayer_path);
        
        this.enemyLayer_Path = "res/levels/level1_en.txt";
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
