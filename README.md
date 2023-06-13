# Server Controls
Server Controls adds gamerules for operators to edit certain `server.properties` configurations on the fly.

### Currently supported options:
- Difficulty Locked
- Enforced Whitelist
- Allow Flight
- Online Mode
- Player Idle Timeout
- Prevent Proxy Connections
- PVP
- Simulation Distance
- View Distance

### Commands
- `/gamerule sc.difficultyLocked`: If the world's difficulty is locked.
- `/gamerule sc.enforcedWhitelist`: If players not on the whitelist should be kicked immediately if online.
- `/gamerule sc.flight`: If players in survival mode can fly. (aka, Mojang's flight anti cheat)
- `/gamerule sc.onlineMode`: If the server should check connecting players.
- `/gamerule sc.playerIdleTimeout`: Time in minutes until a player is kicked for being afk.
- `/gamerule sc.preventProxyConnections`: If players can connect with a vpn enabled.
- `/gamerule sc.pvp`: If players can fight each other.
- `/gamerule sc.simulationDistance`: The server's simulation distance.
- `/gamerule sc.viewDistance`: The server's view/render distance.
