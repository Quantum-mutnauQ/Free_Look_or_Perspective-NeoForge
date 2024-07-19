package quatum.freelookneoforge.event;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import quatum.freelookneoforge.CameraLook;
import quatum.freelookneoforge.FreeLookneoForge;
import quatum.freelookneoforge.KeyBinding.FreeLookKey;


public class KeyEvent {
    @EventBusSubscriber(modid = FreeLookneoForge.MODID,value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvent{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(FreeLookKey.FREELOOK_KAY);
            event.register(FreeLookKey.PERSPECTIVESWAP_KAY);
        }
    }
    @EventBusSubscriber(modid = FreeLookneoForge.MODID,value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onInput(InputEvent.Key event) {
            KeyEvent.onInput();
        }

    }
    public static void onInput(){
        CameraLook cameraLook = CameraLook.instance;
        cameraLook.setSwapActive(FreeLookKey.PERSPECTIVESWAP_KAY.isDown());
        cameraLook.setLookActive(FreeLookKey.FREELOOK_KAY.isDown());
        cameraLook.setSyncAttack(Minecraft.getInstance().options.keyAttack.isDown());
        cameraLook.setSyncPickItem(Minecraft.getInstance().options.keyPickItem.isDown());
        cameraLook.setSyncUse(Minecraft.getInstance().options.keyUse.isDown());
        CameraType type =Minecraft.getInstance().options.getCameraType();

        cameraLook.SwapPerspective();
        if(cameraLook.shouldSync(type)&&cameraLook.isCamaraMode(type)){
            LocalPlayer LP = Minecraft.getInstance().player;
            if(Minecraft.getInstance().options.getCameraType() == CameraType.THIRD_PERSON_FRONT){
                LP.setXRot(cameraLook.convertToAngle(cameraLook.getXRot())*-1);
                LP.setYRot(cameraLook.getYRot()-180);
            }else {
                LP.setXRot(cameraLook.convertToAngle(cameraLook.getXRot()));
                LP.setYRot(cameraLook.getYRot());
            }
        }
        cameraLook.SwapPerspectiveBack();
        cameraLook.SwitchPerspectiveBack();

    }
}
