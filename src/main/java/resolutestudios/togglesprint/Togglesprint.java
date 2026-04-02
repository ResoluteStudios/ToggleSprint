package resolutestudios.togglesprint;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Togglesprint implements ClientModInitializer {
	public static final String MOD_ID = "togglesprint";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final KeyBinding toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"key.togglesprint.toggle",
			GLFW.GLFW_KEY_LEFT_CONTROL,
			new KeyBinding.Category(id("togglesprint", "togglesprint"))
	));

	/**
	 * Helper method to create an Identifier across Minecraft versions 1.20 - 1.21.x.
	 * 1.21+ uses Identifier.of(), 1.20- uses Identifier() constructor.
	 */
	public static Identifier id(String namespace, String path) {
		try {
			// Try 1.21+ static factory method: Identifier.of(String, String)
			return (Identifier) Identifier.class.getMethod("of", String.class, String.class).invoke(null, namespace, path);
		} catch (Exception e1) {
			try {
				// Fallback to 1.20- constructor: new Identifier(String, String)
				return (Identifier) Identifier.class.getConstructor(String.class, String.class).newInstance(namespace, path);
			} catch (Exception e2) {
				throw new RuntimeException("Failed to create Identifier for " + namespace + ":" + path, e2);
			}
		}
	}


	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (toggleKey.wasPressed()) {
				SprintManager.toggle();
			}
		});

		LOGGER.info("[Togglesprint] Has been initialized!");
	}
}