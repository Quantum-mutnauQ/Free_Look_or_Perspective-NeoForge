package quatum.freelookforge.mixin;

import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import quatum.freelookforge.CameraLook;

@Mixin(Camera.class)
public abstract class CameraMixin {
    @Shadow
    private float xRot;
    @Shadow
    private float yRot;
    @Shadow @Final
    private  Quaternionf rotation;
    @Shadow @Final
    private Vector3f forwards;
    @Shadow @Final
    private Vector3f up;
    @Shadow @Final
    private Vector3f left;

    @Shadow public abstract void reset();
    @Inject(method = "setup",at = @At("HEAD"))
    private void setUp(BlockGetter p_90576_, Entity p_90577_, boolean p_90578_, boolean p_90579_, float p_90580_, CallbackInfo ci){

    }

    @Inject(method = "setRotation",at = @At("HEAD"),cancellable = true)
    private void onSetup(float p_90573_, float p_90574_, CallbackInfo ci) {
        CameraType cameraType = Minecraft.getInstance().options.getCameraType();
        CameraLook controller = CameraLook.instance;
        if (CameraLook.instance.isLookActive() && controller.isCamaraMode(cameraType)) {
            p_90574_ = (float) controller.getXRot();
            p_90573_=(float) controller.getYRot();
        }
        if(CameraLook.instance.isLookActive() && !controller.isCamaraMode(cameraType)&& !CameraLook.instance.shouldSync(cameraType)){
            ci.cancel(); return;}
        this.xRot = p_90574_;
        this.yRot = p_90573_;
        this.rotation.rotationYXZ(-p_90573_ * ((float)Math.PI / 180F), p_90574_ * ((float)Math.PI / 180F), 0.0F);
        this.forwards.set(0.0F, 0.0F, 1.0F).rotate(this.rotation);
        this.up.set(0.0F, 1.0F, 0.0F).rotate(this.rotation);
        this.left.set(1.0F, 0.0F, 0.0F).rotate(this.rotation);
        ci.cancel();
    }
}
