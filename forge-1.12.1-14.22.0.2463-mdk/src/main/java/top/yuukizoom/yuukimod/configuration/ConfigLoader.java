package top.yuukizoom.yuukimod.configuration;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * Created by realdata on 2017/8/31.
 */
public class ConfigLoader {

    private static Configuration configuration;

    public static int diamondBurnTime;

    private static Logger logger;

    public ConfigLoader (FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        configuration = new Configuration(event.getSuggestedConfigurationFile());
        configuration.load();
        loadConfig();
    }

    public static void loadConfig()
    {
        logger.info("Started load config");
        String comment;
        comment = "How many seconds can a diamond burn in a furnace.";
        diamondBurnTime = configuration.get(Configuration.CATEGORY_GENERAL,"diamondBurnTime",640,comment).getInt();
        configuration.save();
        logger.info("Finished loading config.");
    }

    public static Logger logger()
    {
        return logger;
    }

}
