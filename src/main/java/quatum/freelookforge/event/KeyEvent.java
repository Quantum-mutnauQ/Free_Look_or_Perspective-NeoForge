package quatum.freelookforge.event;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import quatum.freelookforge.CameraLook;
import quatum.freelookforge.FreeLookForge;
import quatum.freelookforge.KeyBinding.FreeLookKey;

public class KeyEvent {
    @Mod.EventBusSubscriber(modid = FreeLookForge.MODID,value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvent{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(FreeLookKey.FREELOOK_KAY);
        }
    }
    @Mod.EventBusSubscriber(modid = FreeLookForge.MODID,value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
                CameraLook.instance.setActive(FreeLookKey.FREELOOK_KAY.isDown());
        }
        @SubscribeEvent
        public static void onInput(InputEvent event) {
            CameraLook cameraLook = CameraLook.instance;
            cameraLook.setSyncAttack(Minecraft.getInstance().options.keyAttack.isDown());
            cameraLook.setSyncPickItem(Minecraft.getInstance().options.keyPickItem.isDown());
            cameraLook.setSyncUse(Minecraft.getInstance().options.keyUse.isDown());

            CameraType type =Minecraft.getInstance().options.getCameraType();
                if(cameraLook.shouldSync(type)&&cameraLook.isCamaraMode(type)){
                    LocalPlayer LP = Minecraft.getInstance().player;
                    if(Minecraft.getInstance().options.getCameraType() == CameraType.THIRD_PERSON_FRONT){
                        LP.setXRot(cameraLook.getXRot()*-1);
                        LP.setYRot(cameraLook.getYRot()-180);
                    }else {
                        LP.setXRot(cameraLook.getXRot());
                        LP.setYRot(cameraLook.getYRot());
                    }
            }
        }
    }

}
