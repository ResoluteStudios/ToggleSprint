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
		
		String fullText;
		if (SprintManager.toggleActive) {
			fullText = "§7Toggle Sprint is §aEnabled§7.";
		} else {
			fullText = "§7Toggle Sprint is §7Disabled§7.";
		}
		
		context.drawText(net.minecraft.client.MinecraftClient.getInstance().textRenderer, fullText, x, y, 0xFFFFFF, true);
	}
}
