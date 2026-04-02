package resolutestudios.togglesprint.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import resolutestudios.togglesprint.SprintManager;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {
	@Inject(at = @At("TAIL"), method = "tickMovement")
	private void onTickMovement(CallbackInfo info) {
		ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
		
		if (SprintManager.toggleActive) {
			// If toggle is active, force sprinting if moving horizontally
			if (player.getVelocity().horizontalLengthSquared() > 1.0E-6 && !player.isSneaking() && !player.isSubmergedInWater()) {
				player.setSprinting(true);
			}
		}
	}
}
