package net.anchikai.world;

import net.anchikai.ServerControls;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRuleRegistry {
    public static final GameRules.Key<GameRules.BooleanRule> PVP = GameRuleRegistry.register(ServerControls.MOD_ID + ".pvp", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> ONLINE_MODE = GameRuleRegistry.register(ServerControls.MOD_ID + ".onlineMode", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> FLIGHT = GameRuleRegistry.register(ServerControls.MOD_ID + ".flight", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.IntRule> VIEW_DISTANCE = GameRuleRegistry.register(ServerControls.MOD_ID + ".viewDistance", GameRules.Category.MISC, GameRuleFactory.createIntRule(10));
    public static final GameRules.Key<GameRules.BooleanRule> PREVENT_PROXY_CONNECTIONS = GameRuleRegistry.register(ServerControls.MOD_ID + ".preventProxyConnections", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.IntRule> SIMULATION_DISTANCE = GameRuleRegistry.register(ServerControls.MOD_ID + ".simulationDistance", GameRules.Category.MISC, GameRuleFactory.createIntRule(10));
    public static final GameRules.Key<GameRules.IntRule> PLAYER_IDLE_TIMEOUT = GameRuleRegistry.register(ServerControls.MOD_ID + ".playerIdleTimeout", GameRules.Category.MISC, GameRuleFactory.createIntRule(0));
    public static final GameRules.Key<GameRules.BooleanRule> ENFORCE_WHITELIST = GameRuleRegistry.register(ServerControls.MOD_ID + ".enforceWhitelist", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanRule> DIFFICULTY_LOCKED = GameRuleRegistry.register(ServerControls.MOD_ID + ".difficultyLocked", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));


    public static void register() {
        ServerControls.LOGGER.info("Loaded Server Controls gamerules.");
    }
}