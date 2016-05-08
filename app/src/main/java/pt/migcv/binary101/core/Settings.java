package pt.migcv.binary101.core;

/**
 * Created by Miguel on 08/05/2016.
 */
public class Settings {

    private static boolean systemKeyboard = false;

    public static boolean isSystemKeyboardOn() {
        return systemKeyboard;
    }

    public static void setSystemKeyboard(boolean state) {
        systemKeyboard = state;
    }

}
