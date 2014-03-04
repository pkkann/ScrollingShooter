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
public class Level1 implements Level {

    private int[][] bgLayer;
    private String bgLayer_path = "res/levels/level1.txt";

    private int[][] enemyLayer;
    private String enemyLayer_path = "";
    
    

    public Level1() {
        loadLayers();
    }
    
    private void loadLayers() {
        bgLayer = LevelFileReader.readLevel(bgLayer_path);
//        enemyLayer = LevelFileReader.readLevel(enemyLayer_path);
    }

    public int[][] getBgLayer() {
        return bgLayer;
    }

    public int[][] getEnemyLayer() {
        return enemyLayer;
    }

}
