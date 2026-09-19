package quatum.freelookneoforge.mixin;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import quatum.freelookneoforge.CameraLook;
import quatum.freelookneoforge.Config;


@Mixin(Hud.class)
public class GuiMixin {
        @Inject(method = "extractCrosshair",at = @At("HEAD"),cancellable = true)
        public void renderCrosshair(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker, CallbackInfo ci) {
            if(CameraLook.instance.isLookActive()&& Config.hideCrosshairValue)
                ci.cancel();
        }
}
