package net.anchikai.server;

import net.anchikai.ServerControls;
import net.anchikai.world.ModGameRuleRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.world.ServerWorld;

public class ServerEvents {
    private int serverSimulation = 10;
    private int serverView = 10;


    public ServerEvents() {
        ServerTickEvents.START_SERVER_TICK.register(this::checkGameRules);
    }

    /**
     * Checks for when the gamerules added in the mod are updated. If they are, update the respective values in server.properties
     */
    private void checkGameRules(MinecraftServer minecraftServer) {
        for (ServerWorld world: minecraftServer.getWorlds()) {
            refreshDistances(minecraftServer.getPlayerManager(), world);
        }
    }

    /**
     * Update all players view and simulation distances to respect the new cap.
     */
    public void refreshDistances(PlayerManager playerList, ServerWorld world) {
        int simulation = world.getGameRules().getInt(ModGameRuleRegistry.SIMULATION_DISTANCE);
        int view = world.getGameRules().getInt(ModGameRuleRegistry.VIEW_DISTANCE);

        if (serverSimulation != simulation) {
            serverSimulation = simulation;
            playerList.setSimulationDistance(simulation);
            ServerControls.LOGGER.info("Updated simulation distance.");
        }
        if (serverView != view) {
            serverView = view;
            playerList.setViewDistance(view);
            ServerControls.LOGGER.info("Updated view distance.");
        }
    }
}