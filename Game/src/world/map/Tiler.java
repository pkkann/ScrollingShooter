/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.map;

import control.TileHandler;
import java.util.Arrays;
import java.util.LinkedList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Tiler {

    private TileHandler tileManager;

    private LinkedList<int[]> map;
    private boolean repeat = true;
    private float scrollSpeed = 0.1f;
    private float scroll = 0;
    private int mapDelta;
    private int nextMapArrayPos;
    private int[][] nextMap;
    private boolean loadNextMap;
    private int oldMapSize;

    public Tiler(TileHandler tileManager) {
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

    public void loadNewMap(int[][] nextMap) {
        this.nextMap = nextMap;
        loadNextMap = true;
        nextMapArrayPos = 0;
        mapDelta = nextMap.length - map.size();
        oldMapSize = map.size();
    }

    private void changeMap() {
        
        if (mapDelta > 0) { //Hvis det nye map er længere
            //Hvis vi er nået til den sidste række, så stop med at loade next map
            if (nextMapArrayPos == nextMap.length - 1) {
                loadNextMap = false;
                map.addFirst(nextMap[nextMapArrayPos]);
                nextMapArrayPos = 0;
            } else {
                //hvis  næste position er større end det gamle maps size, så er hele det gamle map fjernet, og der bliver derfor ikke fjernet fra mappet
                if (nextMapArrayPos >= oldMapSize) {
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos++;
                } else {
                    //fjern sidste position og sæt en ny række ind fra det nye map
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos++;
                }
            }
        } else {
            if (mapDelta == 0) {
                if (nextMapArrayPos == nextMap.length - 1) {
                    loadNextMap = false;
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos = 0;
                } else {
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos++;
                }
            }
            if (mapDelta < 0) {
                if (nextMapArrayPos == nextMap.length - 1) {
                    loadNextMap = false;
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos = 0;
                    for (int y = 0; y > mapDelta; y--) {
                        map.pollLast();
                    }
                } else {
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos++;
                }
            }
        }
    }

    public void init(GameContainer container, StateBasedGame game, int[][] startMap) {
        map.addAll(Arrays.asList(startMap));
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        for (int y = 0; y < map.size(); y++) {
            for (int x = 0; x < map.get(y).length; x++) {
                tileManager.getTile(map.get(y)[x]).draw(x * tileManager.getTileSize(), y * tileManager.getTileSize() - 32 + scroll);
            }
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
        scroll += scrollSpeed * delta;

        if (container.getInput().isKeyDown(Input.KEY_1)) {
            int[][] i = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
            loadNewMap(i);
        }

        if (repeat) {
            if (scroll >= tileManager.getTileSize()) {
                if (loadNextMap) {
                    changeMap();
                } else {
                    int[] i = map.pollLast();
                    map.addFirst(i);
                }
                scroll = 0;
            }
        }
    }

}
