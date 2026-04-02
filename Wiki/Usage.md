# Usage and Configuration

ToggleSprint is simple to configure and use.

## Default Controls

- **Toggle Sprint Key**: (Default: `Left Control`) - Switches the automatic sprinting state on or off.
- **HUD Overlay**: Displayed at the top-left of the screen, indicating if Toggle Sprint is currently `Enabled` or `Disabled`.

## Mechanics and Input Hierarchy

The toggle sprint logic adheres to the following rules:

1. **Forward Movement Required**: The character will only sprint when the forward movement key is held.
2. **Sneak Priority**: If the player is sneaking, Toggle Sprint is automatically overridden to prevent accidental movement.
3. **Vanilla Override**: Standard sprinting behaviors (e.g., stopping when hitting a wall or running out of hunger) still apply.

## Customization

To change the toggle keybind, navigate to:
1. **Options** > **Controls** > **Key Binds**.
2. Scroll to the **togglesprint:togglesprint** category.
3. Assign a new key for **key.togglesprint.toggle**.
