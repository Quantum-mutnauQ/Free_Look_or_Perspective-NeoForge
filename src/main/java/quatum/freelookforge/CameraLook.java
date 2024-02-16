package quatum.freelookforge;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;

public class CameraLook {
    public static final CameraLook instance = new CameraLook();

    float xRot, yRot;
    boolean first = true;
    boolean active = false;
    boolean SyncUse=true;
    boolean SyncPickItem=true;
    boolean SyncAttack=true;
    boolean last=false;
    CameraType lastCameraType;
    public void setSyncUse(boolean value){this.SyncUse = value;}
    public void setSyncPickItem(boolean value){this.SyncPickItem = value;}
    public void setSyncAttack(boolean value){this.SyncAttack = value;}
    public boolean shouldSync(CameraType cameraType){
        if(((this.SyncUse && Config.RotateKeyUseValue)||(this.SyncPickItem&&Config.RotatePickItemValue)||(this.SyncAttack&&Config.RotateAttackValue)) && this.active){
            if (cameraType == CameraType.FIRST_PERSON)
                return Config.RotateFirstPersonValue;
            if (cameraType == CameraType.THIRD_PERSON_FRONT)
                return Config.RotateThirdPersonFrontValue;
            if (cameraType ==CameraType.THIRD_PERSON_BACK)
                return Config.RotateThirdPersonBackValue;
        }
        return false;
    }
    public boolean isCamaraMode(CameraType cameraType ){
        if(cameraType == CameraType.FIRST_PERSON){
            if(Config.ModeFirstPersonValue==0){
                return true;
            }
        }
        if(cameraType == CameraType.THIRD_PERSON_FRONT){
            if(Config.ModeThirdPersonFrontValue==0){
                return true;
            }
        }
        if(cameraType == CameraType.THIRD_PERSON_BACK){
            if(Config.ModeThirdPersonBackValue==0){
                return true;
            }
        }
        return false;
    }
    public void setActive(boolean vale){this.active = vale;}
    public boolean isActive(){return this.active;}
    public float getYRot(){
        return this.yRot;
    }
    public float getXRot(){
        return this.xRot;
    }
    public void onPlayerTurn(LocalPlayer player, double XRot, double YRot){
        CameraType cameraType = Minecraft.getInstance().options.getCameraType();
        if(this.active && this.isCamaraMode(cameraType)) {
            if(this.first){
                this.lastCameraType =cameraType;
                if(Config.AutoSwitchPerspectiveValue != SwitchPerspective.OFF){
                    switch (Config.AutoSwitchPerspectiveValue){
                        case FirstPerson:
                            Minecraft.getInstance().options.setCameraType(CameraType.FIRST_PERSON);
                            cameraType = CameraType.FIRST_PERSON;
                            break;
                        case ThirdPersonBack:
                            Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_BACK);
                            cameraType = CameraType.THIRD_PERSON_BACK;
                            break;
                        case ThirdPersonFront:
                            Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_FRONT);
                            cameraType = CameraType.THIRD_PERSON_FRONT;
                            break;
                    }
                }
                if(cameraType == CameraType.THIRD_PERSON_FRONT) {
                    this.yRot = player.getYRot() - 180;
                    this.xRot = player.getXRot()*-1;
                }
                else{
                    this.yRot= player.getYRot();
                    this.xRot = player.getXRot();
                }
                this.first = false;
                this.last = true;
            }
            this.yRot += (float) XRot * 0.15F;
            this.xRot += (float) YRot * 0.15F;
            this.xRot = Mth.clamp(this.xRot, -90, 90);
        }else{
            this.first=true;
            player.turn(XRot,YRot);
        }

    }
    public void SwitchPerspectiveBack(){
        if(Config.AutoSwitchPerspectiveValue != SwitchPerspective.OFF && Config.AutoSwitchPerspeciveBackValue && !this.active && this.last){
            this.last=false;
            Minecraft.getInstance().options.setCameraType(CameraType.valueOf(String.valueOf(this.lastCameraType)));
        }
    }

}
