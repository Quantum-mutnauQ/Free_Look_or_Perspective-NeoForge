package quatum.freelookforge.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import quatum.freelookforge.CameraLook;
import quatum.freelookforge.Config;

@Mixin(Gui.class)
public class GuiMixin {
        @Inject(method = "renderCrosshair",at = @At("HEAD"),cancellable = true)
        public void renderCrosshair(GuiGraphics p_282828_, CallbackInfo ci) {
            if(CameraLook.instance.isLookActive()&& Config.hideCrosshairValue)
                ci.cancel();
        }
}
