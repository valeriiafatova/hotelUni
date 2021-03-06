package Hotel.factory;

import Hotel.controller.Command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lerafatova on 27.04.17.
 */
public class CommandFactory {
    private static final CommandFactory instance = new CommandFactory();
    private final PageResolver pageResolver = new PageResolver();
    private final PostResolver postResolver = new PostResolver();
    private final Map<String, Command> commandMap = new HashMap<>();

    public CommandFactory() {
        commandMap.put("notFound", new NotFound());
        commandMap.put("openPage", new OpenPage());
        commandMap.put("subscribe", new Subscribe());
        commandMap.put("showRooms", new ShowRooms());
        commandMap.put("about_us", new OpenPage());
        commandMap.put("reservation", new OpenPage());
        commandMap.put("gallery", new OpenPage());
        commandMap.put("reservInfo", new OpenPage());
        commandMap.put("contact", new OpenPage());
        commandMap.put("home", new Home());
        commandMap.put("reservRoom", new ReserveRoom());

    }

    public static CommandFactory getInstance() {
        return instance;
    }

    public Command getCommand(String command) {
        return commandMap.get(command);
    }

    public PageResolver getPageResolver() {
        return pageResolver;
    }

    public PostResolver getPostResolver() {
        return postResolver;
    }
}
