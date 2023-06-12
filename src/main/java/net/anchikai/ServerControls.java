package net.anchikai;

import net.anchikai.server.ServerEvents;
import net.anchikai.world.ModGameRuleRegistry;
import net.fabricmc.api.DedicatedServerModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerControls implements DedicatedServerModInitializer {
    public static final String MOD_ID = "sc";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static ServerEvents SERVER_EVENTS;

    @Override
    public void onInitializeServer() {
        ModGameRuleRegistry.register();
        SERVER_EVENTS = new ServerEvents();
    }
}