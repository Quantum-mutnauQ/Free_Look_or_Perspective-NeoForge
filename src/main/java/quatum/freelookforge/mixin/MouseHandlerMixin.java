package quatum.freelookforge.mixin;

import net.minecraft.client.MouseHandler;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import quatum.freelookforge.CameraLook;

@Mixin(value = MouseHandler.class, remap = false)
public class MouseHandlerMixin {
    @Redirect(method = "turnPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;turn(DD)V"))
    private void onLocalPlayerTurn(LocalPlayer player, double yRot, double xRot) {
        CameraLook.instance.onPlayerTurn(player, yRot, xRot);
    }
}
