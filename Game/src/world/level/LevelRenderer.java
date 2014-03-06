/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.level;

import control.EnemyManager;
import control.TileHandler;
import java.util.Arrays;
import java.util.LinkedList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class LevelRenderer {

    private final LinkedList<int[]> currentBgLayer;
    private final LinkedList<int[]> currentMidLayer;
    private final LinkedList<int[]> currentEnemyLayer;

    private final TileHandler tileHandler;
    private final EnemyManager enemyManager;

    private final float scrollSpeed = 0.09f;
    private float scrollCounter;

    private Level nextLevel;
    private boolean loadingNextLevel;

    private int bgLayerDelta;
    private int nextBgLayerArrayPos;
    private int oldBgLayerSize;

    private int midLayerDelta;
    private int nextMidLayerArrayPos;
    private int oldMidLayerSize;

    private int enemyLayerDelta;
    private int nextEnemyLayerArrayPos;
    private int oldEnemyLayerSize;

    public LevelRenderer(TileHandler tileHandler, EnemyManager enemyManager) {
        this.tileHandler = tileHandler;
        this.enemyManager = enemyManager;
        currentBgLayer = new LinkedList<>();
        currentMidLayer = new LinkedList<>();
        currentEnemyLayer = new LinkedList<>();
    }

    public boolean isLoadingNextLevel() {
        return loadingNextLevel;
    }

    public void loadNewLevel(Level lev) {
        nextLevel = lev;

        nextBgLayerArrayPos = 0;
//        nextMidLayerArrayPos = 0;
        nextEnemyLayerArrayPos = 0;

        bgLayerDelta = lev.getBgLayer().length - currentBgLayer.size();
//        midLayerDelta = lev.getMidLayer().length - currentMidLayer.size();
        enemyLayerDelta = lev.getEnemyLayer().length - currentEnemyLayer.size();

        oldBgLayerSize = currentBgLayer.size();
//        oldMidLayerSize = currentMidLayer.size();
        oldEnemyLayerSize = currentEnemyLayer.size();

        loadingNextLevel = true;
    }

    public void loadNewLevelInstantly(Level lev) {
        nextLevel = lev;
        currentBgLayer.addAll(Arrays.asList(nextLevel.getBgLayer()));
//        currentMidLayer.addAll(Arrays.asList(nextLevel.getMidLayer()));
        //   currentEnemyLayer.addAll(Arrays.asList(nextLevel.getEnemyLayer()));
    }

    private void changeBgLayer() {
        if (bgLayerDelta > 0) { //Hvis det nye map er længere
            //Hvis vi er nået til den sidste række, så stop med at loade next map
            if (nextBgLayerArrayPos == nextLevel.getBgLayer().length - 1) {
                loadingNextLevel = false;
                currentBgLayer.addFirst(nextLevel.getBgLayer()[nextBgLayerArrayPos]);
                nextBgLayerArrayPos = 0;
            } else {
                //hvis  næste position er større end det gamle maps size, så er hele det gamle map fjernet, og der bliver derfor ikke fjernet fra mappet
                if (nextBgLayerArrayPos >= oldBgLayerSize) {
                    currentBgLayer.addFirst(nextLevel.getBgLayer()[nextBgLayerArrayPos]);
                    nextBgLayerArrayPos++;
                } else {
                    //fjern sidste position og sæt en ny række ind fra det nye map
                    currentBgLayer.pollLast();
                    currentBgLayer.addFirst(nextLevel.getBgLayer()[nextBgLayerArrayPos]);
                    nextBgLayerArrayPos++;
                }
            }
        } else {
            if (bgLayerDelta == 0) {
                if (nextBgLayerArrayPos == nextLevel.getBgLayer().length - 1) {
                    loadingNextLevel = false;
                    currentBgLayer.pollLast();
                    currentBgLayer.addFirst(nextLevel.getBgLayer()[nextBgLayerArrayPos]);
                    nextBgLayerArrayPos = 0;
                } else {
                    currentBgLayer.pollLast();
                    currentBgLayer.addFirst(nextLevel.getBgLayer()[nextBgLayerArrayPos]);
                    nextBgLayerArrayPos++;
                }
            }
            if (bgLayerDelta < 0) {
                if (nextBgLayerArrayPos == nextLevel.getBgLayer().length - 1) {
                    loadingNextLevel = false;
                    currentBgLayer.pollLast();
                    currentBgLayer.addFirst(nextLevel.getBgLayer()[nextBgLayerArrayPos]);
                    nextBgLayerArrayPos = 0;
                    for (int y = 0; y > bgLayerDelta; y--) {
                        currentBgLayer.pollLast();
                    }
                } else {
                    currentBgLayer.pollLast();
                    currentBgLayer.addFirst(nextLevel.getBgLayer()[nextBgLayerArrayPos]);
                    nextBgLayerArrayPos++;
                }
            }
        }
    }

    private void changeMidLayer() {

    }

    private void changeEnemyLayer() {
        if (enemyLayerDelta > 0) { //Hvis det nye map er længere
            //Hvis vi er nået til den sidste række, så stop med at loade next map
            if (nextEnemyLayerArrayPos == nextLevel.getEnemyLayer().length - 1) {
                loadingNextLevel = false;
                currentEnemyLayer.addFirst(nextLevel.getEnemyLayer()[nextEnemyLayerArrayPos]);
                nextEnemyLayerArrayPos = 0;
            } else {
                //hvis  næste position er større end det gamle maps size, så er hele det gamle map fjernet, og der bliver derfor ikke fjernet fra mappet
                if (nextEnemyLayerArrayPos >= oldEnemyLayerSize) {
                    currentEnemyLayer.addFirst(nextLevel.getEnemyLayer()[nextEnemyLayerArrayPos]);
                    nextEnemyLayerArrayPos++;
                } else {
                    //fjern sidste position og sæt en ny række ind fra det nye map
                    currentEnemyLayer.pollLast();
                    currentEnemyLayer.addFirst(nextLevel.getEnemyLayer()[nextEnemyLayerArrayPos]);
                    nextEnemyLayerArrayPos++;
                }
            }
        } else {
            if (enemyLayerDelta == 0) {
                if (nextEnemyLayerArrayPos == nextLevel.getEnemyLayer().length - 1) {
                    loadingNextLevel = false;
                    currentEnemyLayer.pollLast();
                    currentEnemyLayer.addFirst(nextLevel.getEnemyLayer()[nextEnemyLayerArrayPos]);
                    nextEnemyLayerArrayPos = 0;
                } else {
                    currentEnemyLayer.pollLast();
                    currentEnemyLayer.addFirst(nextLevel.getEnemyLayer()[nextEnemyLayerArrayPos]);
                    nextEnemyLayerArrayPos++;
                }
            }
            if (enemyLayerDelta < 0) {
                if (nextEnemyLayerArrayPos == nextLevel.getEnemyLayer().length - 1) {
                    loadingNextLevel = false;
                    currentEnemyLayer.pollLast();
                    currentEnemyLayer.addFirst(nextLevel.getEnemyLayer()[nextEnemyLayerArrayPos]);
                    nextEnemyLayerArrayPos = 0;
                    for (int y = 0; y > enemyLayerDelta; y--) {
                        currentEnemyLayer.pollLast();
                    }
                } else {
                    currentEnemyLayer.pollLast();
                    currentEnemyLayer.addFirst(nextLevel.getEnemyLayer()[nextEnemyLayerArrayPos]);
                    nextEnemyLayerArrayPos++;
                }
            }
        }
    }

    private void repeatBgLayer() {
        int[] i = currentBgLayer.pollLast();
        currentBgLayer.addFirst(i);
    }

    private void repeatMidLayer() {

    }

    private void repeatEnemyLayer() {
        int[] i = currentEnemyLayer.pollLast();
        for (int x = 0; x < i.length; x++) {
            if (i[x] == 1) {
                enemyManager.spawnObject(1, x * tileHandler.getTileSize(), -tileHandler.getTileSize());
            }
        }
        currentEnemyLayer.addFirst(i);

    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        //Render bg layer
        for (int y = 0; y < currentBgLayer.size(); y++) {
            for (int x = 0; x < currentBgLayer.get(y).length; x++) {
                tileHandler.getTile(currentBgLayer.get(y)[x]).draw(x * tileHandler.getTileSize(), y * tileHandler.getTileSize() + scrollCounter - tileHandler.getTileSize());
            }
        }

        //Render mid layer
        for (int y = 0; y < currentMidLayer.size(); y++) {
            for (int x = 0; x < currentMidLayer.get(y).length; x++) {
                
            }
        }
    }

    public void verboseRender(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        if (loadingNextLevel) {
            g.setColor(Color.white);
            g.fillRect(container.getWidth() - 260, 10, 250, 215);
            g.setColor(Color.red);
            g.drawString("Loading next level", container.getWidth() - 250, 15);
            g.setColor(Color.darkGray);
            g.drawString("BGLayerDelta: " + bgLayerDelta, container.getWidth() - 250, 40);
            g.drawString("NextBGLayerArrayPos: " + nextBgLayerArrayPos, container.getWidth() - 250, 60);
            g.drawString("OldBgLayerSize: " + oldBgLayerSize, container.getWidth() - 250, 80);

            g.drawString("MidLayerDelta: " + midLayerDelta, container.getWidth() - 250, 100);
            g.drawString("NextMidLayerArrayPos: " + nextMidLayerArrayPos, container.getWidth() - 250, 120);
            g.drawString("OldMidLayerSize: " + oldMidLayerSize, container.getWidth() - 250, 140);

            g.drawString("EnemyLayerDelta: " + enemyLayerDelta, container.getWidth() - 250, 160);
            g.drawString("NextEnemyLayerArrayPos: " + nextEnemyLayerArrayPos, container.getWidth() - 250, 180);
            g.drawString("OldEnemyLayerSize: " + oldEnemyLayerSize, container.getWidth() - 250, 200);
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        scrollCounter += scrollSpeed * delta;
        if (scrollCounter >= tileHandler.getTileSize()) {
            if (!loadingNextLevel) {
                repeatBgLayer();
//                repeatMidLayer();
                repeatEnemyLayer();
            } else {
                changeBgLayer();
//                changeMidLayer();
                changeEnemyLayer();
            }

            //Spawn enemies according to enemy layer
            int[] i = currentEnemyLayer.getFirst();
            for (int x = 0; x < i.length; x++) {
                if (i[x] == 1) {
                    enemyManager.spawnObject(1, x * tileHandler.getTileSize(), -tileHandler.getTileSize());
                }
            }
            scrollCounter = 0;
        }

    }

    public void verboseUpdate(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

}
