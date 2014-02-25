/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.map;

import control.TileManager;
import java.util.Arrays;
import java.util.LinkedList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Tiler {

    private TileManager tileManager;
    
    private LinkedList<int[]> map;
    private boolean repeat = true;
    private float scrollSpeed = 0.1f;
    private float scroll = 0;

    public Tiler(TileManager tileManager) {
        map = new LinkedList<>();
        
        this.tileManager = tileManager;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public float getScrollSpeed() {
        return scrollSpeed;
    }

    public void setScrollSpeed(float scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
    }

    public void loadNewMap(int[][] map) {
        
    }
    
    public void init(GameContainer container, StateBasedGame game, int[][] startMap) {
        map.addAll(Arrays.asList(startMap));
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        for(int y = 0; y < map.size(); y++) {
            for (int x = 0; x < map.get(y).length; x++) {
                tileManager.getTile(map.get(y)[x]).draw(x * tileManager.getTileSize(), y * tileManager.getTileSize() - 32 + scroll);
            }
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
        scroll += scrollSpeed * delta;
        
        if(repeat) {
            if(scroll >= tileManager.getTileSize()) {
                int[] i = map.pollLast();
                map.addFirst(i);
                scroll = 0;
            }
        }
    }

}
