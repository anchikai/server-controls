package net.anchikai.server;

import net.anchikai.world.ModGameRuleRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.world.ServerWorld;

public class ServerEvents {
    private boolean serverPvp = true;
    private boolean serverOnlineMode = true;
    private boolean serverFlight = false;
    private int serverView = 10;
    private boolean serverPreventProxyConnections = false;
    private int serverSimulation = 10;
    private int serverPlayerIdleTimeout = 0;
    private boolean serverEnforceWhitelist = false;
    private boolean serverDifficultyLocked = false;


    public ServerEvents() {
        ServerTickEvents.START_SERVER_TICK.register(this::checkGameRules);
    }

    private void checkGameRules(MinecraftServer server) {
        for (ServerWorld world: server.getWorlds()) {
            refreshPvp(server, world);
            refreshOnlineMode(server, world);
            refreshFlight(server, world);
            refreshPreventProxyConnections(server, world);
            refreshDistances(server.getPlayerManager(), world);
            refreshPlayerIdleTimeout(server, world);
            refreshDifficultyLocked(server, world);
            refreshEnforceWhitelist(server, world);
        }
    }


    private void refreshPvp(MinecraftServer server, ServerWorld world) {
        boolean pvp = world.getGameRules().getBoolean(ModGameRuleRegistry.PVP);

        if (serverPvp != pvp) {
            serverPvp = pvp;
            server.setPvpEnabled(pvp);
        }
    }

    private void refreshOnlineMode(MinecraftServer server, ServerWorld world) {
        boolean onlineMode = world.getGameRules().getBoolean(ModGameRuleRegistry.ONLINE_MODE);

        if (serverOnlineMode != onlineMode) {
            serverOnlineMode = onlineMode;
            server.setOnlineMode(onlineMode);
        }
    }

    private void refreshFlight(MinecraftServer server, ServerWorld world) {
        boolean flight = world.getGameRules().getBoolean(ModGameRuleRegistry.FLIGHT);

        if (serverFlight != flight) {
            serverFlight = flight;
            server.setFlightEnabled(flight);
        }
    }

    private void refreshPreventProxyConnections(MinecraftServer server, ServerWorld world) {
        boolean preventProxyConnections = world.getGameRules().getBoolean(ModGameRuleRegistry.PREVENT_PROXY_CONNECTIONS);

        if (serverPreventProxyConnections != preventProxyConnections) {
            serverPreventProxyConnections = preventProxyConnections;
            server.setFlightEnabled(preventProxyConnections);
        }
    }

    private void refreshDistances(PlayerManager playerList, ServerWorld world) {
        int simulation = world.getGameRules().getInt(ModGameRuleRegistry.SIMULATION_DISTANCE);
        int view = world.getGameRules().getInt(ModGameRuleRegistry.VIEW_DISTANCE);

        if (serverSimulation != simulation) {
            serverSimulation = simulation;
            playerList.setSimulationDistance(simulation);
        }
        if (serverView != view) {
            serverView = view;
            playerList.setViewDistance(view);
        }
    }

    private void refreshPlayerIdleTimeout(MinecraftServer server, ServerWorld world) {
        int playerIdleTimeout = world.getGameRules().getInt(ModGameRuleRegistry.PLAYER_IDLE_TIMEOUT);

        if (serverPlayerIdleTimeout != playerIdleTimeout) {
            serverPlayerIdleTimeout = playerIdleTimeout;
            server.setPlayerIdleTimeout(playerIdleTimeout);
        }
    }

    private void refreshEnforceWhitelist(MinecraftServer server, ServerWorld world) {
        boolean enforceWhitelist = world.getGameRules().getBoolean(ModGameRuleRegistry.ENFORCE_WHITELIST);

        if (serverEnforceWhitelist != enforceWhitelist) {
            serverEnforceWhitelist = enforceWhitelist;
            server.setEnforceWhitelist(enforceWhitelist);
        }
    }

    private void refreshDifficultyLocked(MinecraftServer server, ServerWorld world) {
        boolean difficultyLocked = world.getGameRules().getBoolean(ModGameRuleRegistry.DIFFICULTY_LOCKED);

        if (serverDifficultyLocked != difficultyLocked) {
            serverDifficultyLocked = difficultyLocked;
            server.setDifficultyLocked(difficultyLocked);
        }
    }
}