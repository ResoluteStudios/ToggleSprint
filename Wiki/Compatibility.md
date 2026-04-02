# Compatibility and System Requirements

ToggleSprint is designed for efficiency and broad version support.

## Supported Versions

- **Minecraft 1.21.x**: Full support using Java 21 and the latest Fabric API.
- **Minecraft 1.20.1**: Supported using Java 17 and the legacy Fabric API.

## Tested Performance Mods

The following mods have been tested to ensure they do not conflict with ToggleSprint's rendering or movement hooks:

- **Sodium**: Full compatibility with HUD overlay.
- **Lithium**: No conflicts with movement and sprinting logic.
- **C2ME**: No conflicts with chunk management or entrypoint stages.
- **Iris**: Compatible with shader-based rendering.

## Known Mod Interactions

ToggleSprint only modifies client-side input handlers and HUD rendering. It does not alter game state on the server or affect packets, making it generally compatible with most movement-based utility mods.
