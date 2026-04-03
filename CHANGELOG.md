# Changelog

All notable changes to the ToggleSprint mod will be documented in this file.

## [1.5.5] - 2026-04-03
### Fixed
- Fixed a compilation error in `ClientPlayerEntityMixin.java` where `input.sprint` was being accessed incorrectly. The mod now uses `player.setSprinting(true)` for better compatibility with 1.21.1 Yarn mappings.
- Cleaned up mixin logic for smoother execution during tick updates.

### Added
- Enhanced anticheat compatibility and realistic behavior. The mod now automatically pauses sprinting if:
    - Food level is too low (≤ 6).
    - Player has the Blindness status effect.
    - Player is taking significant damage (hurt time check).
    - Player is sneaking or colliding horizontally (hitting a wall).
    - This prevents the "packet storm" (rapid start/stop packets) that often triggers server-side anticheat alerts.

## [1.5.3] - 2026-04-02
### Added
- Initial release of the ToggleSprint mod for Minecraft 1.21.1.
- Implemented core toggle logic in `SprintManager`.
- Added a persistence-aware HUD overlay displaying the current toggle status.
- Registered a custom keybinding (default: **Left Ctrl**) under the custom "Togglesprint" category.
- Full Fabric API and Yarn mapping support.

## [1.5.0] - Prior versions
- Early development stages and framework setup for the client-side mod.
