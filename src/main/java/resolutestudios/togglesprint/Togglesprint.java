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
			new KeyBinding.Category(Identifier.of("togglesprint:togglesprint"))
	));

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