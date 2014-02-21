/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import entities.test.TestBox;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author patrick
 */
public class TestBoxManager {
    
    private ArrayList<TestBox> testBoxes;
    
    public TestBoxManager() {
        testBoxes = new ArrayList<>();
    }
    
    public void spawn(float x, float y) {
        testBoxes.add(new TestBox(x, y));
    }
    
    public void checkLifes() {
        Iterator<TestBox> i = testBoxes.iterator();
        
        while(i.hasNext()) {
            TestBox tb = i.next();
            if(tb.getLife() <= 0) {
                tb.setAlive(false);
            }
        }
    }
    
    public void removeTestBoxes() {
        Iterator<TestBox> i = testBoxes.iterator();
        
        while(i.hasNext()) {
            TestBox tb = i.next();
            if(!tb.isAlive()) {
                i.remove();
            }
        }
    }
    
    public ArrayList<TestBox> getTestBoxes() {
        return testBoxes;
    }

    public void updateTestBoxes(GameContainer container, StateBasedGame game, int delta) {
        Iterator<TestBox> i = testBoxes.iterator();
        
        while(i.hasNext()) {
            TestBox tb = i.next();
            tb.update(container, game, delta);
            tb.verboseUpdate(container, game, delta);
        }
    }

    public void renderTestBoxes(GameContainer container, StateBasedGame game, Graphics g) {
        Iterator<TestBox> i = testBoxes.iterator();
        
        while(i.hasNext()) {
            TestBox tb = i.next();
            tb.render(container, game, g);
            tb.verboseRender(container, game, g);
        }
    }
    
}
