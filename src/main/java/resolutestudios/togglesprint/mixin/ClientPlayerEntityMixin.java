package resolutestudios.togglesprint.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.input.Input;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import resolutestudios.togglesprint.SprintManager;
import net.minecraft.entity.effect.StatusEffects;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {
	@Shadow
	public Input input;

	@Inject(at = @At("HEAD"), method = "tickMovement")
	private void onTickMovement(CallbackInfo info) {
		if (SprintManager.toggleActive) {
			ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;

			// Anticheat Compatibility & Realistic Behavior:
			// We mimic vanilla "Hold Sprint" behavior but only when it is safe to do so.
			// This prevents the mod from forcing a sprint state while hitting a wall or taking damage,
			// which would otherwise cause a "packet storm" (rapid start/stop packets) flagged by anticheats.
			
			boolean isMovingForward = this.input.hasForwardMovement(); // Yarn method (known good)
			boolean canSprint = player.getHungerManager().getFoodLevel() > 6 || player.getAbilities().creativeMode;
			boolean isNotObstructed = !player.horizontalCollision; 
			boolean isNotDamaged = player.hurtTime <= 0; 
			boolean isNotSneaking = !player.isSneaking(); // Using Entity method
			boolean isNotBlind = !player.hasStatusEffect(StatusEffects.BLINDNESS);

			if (isMovingForward && canSprint && isNotObstructed && isNotDamaged && isNotSneaking && isNotBlind) {
                // Testing sprint field (if sprinting failed)
				player.setSprinting(true); 
			}
		}
	}
}
