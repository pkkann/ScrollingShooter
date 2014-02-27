/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Patrick
 */
public class SettingsTool {

    private static SettingsManager instance;

    private SettingsTool() {
    }

    public static SettingsManager getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new SettingsManager();
            return instance;
        }
    }

    public static class SettingsManager {

        private Properties settings;
        private OutputStream output;
        private InputStream input;
        private final File name;

        public SettingsManager() {
            name = new File("settings.properties");
            settings = new Properties();
        }

        public String getPropertyAsString(String property) {
            return settings.getProperty(property);
        }

        public int getPropertyAsInteger(String property) {
            return Integer.valueOf(settings.getProperty(property));
        }

        public float getPropertyAsFloat(String property) {
            return Float.valueOf(settings.getProperty(property));
        }

        public boolean getPropertyAsBoolean(String property) {
            return Boolean.valueOf(settings.getProperty(property));
        }

        public void setProperty(String property, String value) {
            settings.setProperty(property, value);
        }

        public void setProperty(String property, int value) {
            settings.setProperty(property, String.valueOf(value));
        }

        public void setProperty(String property, float value) {
            settings.setProperty(property, String.valueOf(value));
        }

        public void setProperty(String property, boolean value) {
            settings.setProperty(property, String.valueOf(value));
        }

        public void saveProperties() throws IOException {
            output = new FileOutputStream(name);
            settings.store(output, null);
            output.close();
        }

        public void initLoadProperties(AppGameContainer app) throws IOException, SlickException {
            input = new FileInputStream(name);
            settings.load(input);
            input.close();

            boolean showOnlyWhenVisible = getPropertyAsBoolean("updateOnlyWhenVisible");
            boolean verbose = getPropertyAsBoolean("verbose");
            int width = getPropertyAsInteger("resWidth");
            int height = getPropertyAsInteger("resHeight");
            boolean fullscreen = getPropertyAsBoolean("fullscreen");

            app.setShowFPS(false);
            app.setDisplayMode(width, height, fullscreen);
            app.setVerbose(verbose);
            app.setUpdateOnlyWhenVisible(showOnlyWhenVisible);
        }

        public void reloadProperties(GameContainer container) throws IOException, SlickException {
            input = new FileInputStream(name);
            settings.load(input);
            input.close();

            boolean showOnlyWhenVisible = getPropertyAsBoolean("updateOnlyWhenVisible");
            boolean verbose = getPropertyAsBoolean("verbose");
            boolean fullscreen = getPropertyAsBoolean("fullscreen");

            container.setVerbose(verbose);
            container.setUpdateOnlyWhenVisible(showOnlyWhenVisible);
            container.setFullscreen(fullscreen);
        }

        public void closeAll() throws IOException {
            settings.clear();
            input.close();
            output.close();
        }

    }

}
