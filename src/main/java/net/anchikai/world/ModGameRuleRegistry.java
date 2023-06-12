package net.anchikai.world;

import net.anchikai.ServerControls;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRuleRegistry {
    public static final GameRules.Key<GameRules.IntRule> VIEW_DISTANCE =
            GameRuleRegistry.register(ServerControls.MOD_ID + ".viewDistance", GameRules.Category.MISC, GameRuleFactory.createIntRule(10));
    public static final GameRules.Key<GameRules.IntRule> SIMULATION_DISTANCE =
            GameRuleRegistry.register(ServerControls.MOD_ID + ".simulationDistance", GameRules.Category.MISC, GameRuleFactory.createIntRule(10));


    public static void register() {
        ServerControls.LOGGER.info("Loaded Server Controls gamerules.");
    }
}