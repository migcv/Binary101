package pt.migcv.binary101.core;

public class Settings {

    private static boolean systemKeyboard = false;

    private static boolean binarySpacing = true;
    private static boolean decimalSpacing = true;

    public static boolean isSystemKeyboardOn() {
        return systemKeyboard;
    }

    public static void setSystemKeyboard(boolean systemKeyboard) {
        Settings.systemKeyboard = systemKeyboard;
    }

    public static boolean isBinarySpacing() {
        return binarySpacing;
    }

    public static void setBinarySpacing(boolean binarySpacing) {
        Settings.binarySpacing = binarySpacing;
    }

    public static boolean isDecimalSpacing() {
        return decimalSpacing;
    }

    public static void setDecimalSpacing(boolean decimalSpacing) {
        Settings.decimalSpacing = decimalSpacing;
    }
}
