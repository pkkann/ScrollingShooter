/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.map;

import game.TileManager;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
    
    private List<int[]> map;
    private boolean repeat = true;
    private float scrollSpeed = 0.1f;
    private float scroll = 0;
    private int[] i;

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
        
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
//        scroll += scrollSpeed * delta;
//        if (repeat) {
//            if (scroll >= 32) {
//                for (int y = map.length - 1; y > -1; y--) {
//
//                    if (y == map.length - 1) {
//                        i = map[0];
//                        map[0] = map[y];
//                    } else {
//                        if (y == 0) {
//                            map[y + 1] = i;
//                        } else {
//                            map[y + 1] = map[y];
//                        }
//                    }
//                }
//                scroll = 0;
//            }
//        }
    }

}
