package resolutestudios.togglesprint.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import resolutestudios.togglesprint.SprintManager;

@Mixin(InGameHud.class)
public class InGameHudMixin {
	@Inject(at = @At("TAIL"), method = "renderStatusBars")
	private void renderOverlay(DrawContext context, CallbackInfo info) {
		int x = 2;
		int y = 2;
		
		String key = SprintManager.toggleActive ? "text.togglesprint.enabled" : "text.togglesprint.disabled";
		context.drawText(net.minecraft.client.MinecraftClient.getInstance().textRenderer, net.minecraft.text.Text.translatable(key), x, y, 0xFFFFFF, true);
	}
}
