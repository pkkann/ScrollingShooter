/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patrick
 */
public class LevelFileReader {

    private LevelFileReader() {
    }

    public static int[][] readLevel(String path) {
        //System.out.println("Path: " + path);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(path));
            ArrayList<int[]> al = new ArrayList<>();
            while (in.ready()) {
                String[] ss = in.readLine().split(",");
                int[] ii = new int[ss.length];

                for (int i = 0; i < ss.length; i++) {
                    ii[i] = Integer.parseInt(ss[i]);
                }
                al.add(ii);
            }
            int[][] iii = al.toArray(new int[al.size()][32]);
//            for(int y = 0; y < iii.length; y++) {
//                System.out.println("");
//                for(int x = 0; x < iii[y].length; x++) {
//                    System.out.print(iii[y][x] + ",");
//                }
//            }
            return iii;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LevelFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LevelFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(LevelFileReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
