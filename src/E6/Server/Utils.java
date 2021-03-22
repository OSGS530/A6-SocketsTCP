package E6.Server;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Utils {
    public static void logFile(String textToLog, Level level){
        final Logger logger = Logger.getLogger("Logs");
        FileHandler fh;

        try {
            fh = new FileHandler("./Logs.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            if(level.equals(Level.INFO))
                logger.info(textToLog);
            else
                logger.severe(textToLog);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
