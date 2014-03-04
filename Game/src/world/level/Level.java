/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.level;

/**
 *
 * @author Patrick
 */
public abstract class Level {
    
    private String name;
    
    public Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public abstract int[][] getBgLayer();
    
    public abstract int[][] getMidLayer();
    
    public abstract int[][] getEnemyLayer();
    
}
