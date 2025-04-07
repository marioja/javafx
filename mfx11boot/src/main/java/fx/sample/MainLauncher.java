package fx.sample;

/**
 * Launcher class that properly configures JavaFX module path when running from an IDE.
 * This class ensures that the JavaFX runtime components are found when running the application.
 * See readme.md for more information.
 */
public class MainLauncher {
    
    /**
     * Main method that launches the JavaFX application with the proper module path configuration.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // When running from IDE, this class properly sets up the module path
        //System.setProperty("javafx.verbose", "true");
        Main.main(args);
    }
}