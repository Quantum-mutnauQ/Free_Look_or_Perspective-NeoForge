package quatum.freelookforge;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = FreeLookForge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue hideCrosshair = BUILDER.comment("Hide the crosshair when free Look is active")
            .define("HideCrosshair",true);
    private static final ForgeConfigSpec.BooleanValue RotateFirstPerson = BUILDER.comment("Rotate player when interaktion")
            .define("RotateFirstPerson",true);
    private static final ForgeConfigSpec.BooleanValue RotateThirdPersonFront = BUILDER.comment("Rotate camera when interaktion")
            .define("RotateThirdPersonFront",false);
    private static final ForgeConfigSpec.BooleanValue RotateThirdPersonBack = BUILDER.comment("Rotate player when interaktion")
            .define("RotateThirdPersonBack",true);
    private static final ForgeConfigSpec.BooleanValue RotateKeyUse = BUILDER.comment("Rotate player when enable on the kay - normal left klick")
            .define("RotateKeyUse",true);
    private static final ForgeConfigSpec.BooleanValue RotatePickItem = BUILDER.comment("Rotate player when enable on the kay- normal middle klick")
            .define("RotatePickItem",true);
    private static final ForgeConfigSpec.BooleanValue RotateAttack = BUILDER.comment("Rotate player when enable on the kay- normal left klick")
            .define("RotateAttack",true);
    private static final ForgeConfigSpec.IntValue ModeFirstPerson = BUILDER.comment("Mode 0 = Move camera, 1 = Move head")
            .defineInRange("ModeFirstPerson",0,0,1);
    private static final ForgeConfigSpec.IntValue ModeThirdPersonFront = BUILDER.comment("Mode 0 = Move camera, 1 = Move head")
        .defineInRange("ModeThirdPersonFront",1,0,1);
    private static final ForgeConfigSpec.IntValue ModeThirdPersonBack = BUILDER.comment("Mode 0 = Move camera, 1 = Move head")
            .defineInRange("ModeThirdPersonBack",0,0,1);
    private static final ForgeConfigSpec.EnumValue AutoSwitchPerspective = BUILDER.comment("Automatic switches perspective wenn free look trigger")
            .defineEnum("AutoSwitchPerspective",SwitchPerspective.OFF);
    private static final ForgeConfigSpec.BooleanValue AutoSwitchPerspeciveBack = BUILDER.comment("Automatic switches perspective back wenn free look trigger stops")
            .define("AutoSwitchPerspeciveBack",true);
    private static final ForgeConfigSpec.EnumValue AutoSwapPerspective = BUILDER.comment("Automatic switches perspective wenn the Swab perspective is pressed")
            .defineEnum("AutoSwapPerspective",SwitchPerspective.OFF);
    private static final ForgeConfigSpec.BooleanValue AutoSwapPerspeciveBack = BUILDER.comment("Automatic switches perspective back wenn the Swab perspective not pressed eny more pressed")
            .define("AutoSwapPerspeciveBack",true);
    private static final ForgeConfigSpec.BooleanValue UpSideDown= BUILDER.comment("Automatic switches perspective back wenn the Swab perspective not pressed eny more pressed")
            .define("UpSideDownEnabled",false);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean hideCrosshairValue=true;
    public static boolean RotateFirstPersonValue=true;
    public static boolean RotateThirdPersonFrontValue=false;
    public static boolean RotateThirdPersonBackValue=true;
    public static boolean RotateKeyUseValue=true;
    public static boolean RotatePickItemValue=true;
    public static boolean RotateAttackValue=true;
    public static int ModeFirstPersonValue=0;
    public static int ModeThirdPersonFrontValue=1;
    public static int ModeThirdPersonBackValue=0;
    public static SwitchPerspective AutoSwitchPerspectiveValue=SwitchPerspective.OFF;
    public static boolean AutoSwitchPerspeciveBackValue=true;
    public static SwitchPerspective AutoSwapPerspectiveValue=SwitchPerspective.OFF;
    public static boolean AutoSwapPerspeciveBackValue=true;
    public static boolean UpSideDownValue=false;
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        hideCrosshairValue=hideCrosshair.get();
        RotateFirstPersonValue = RotateFirstPerson.get();
        RotateThirdPersonFrontValue = RotateThirdPersonFront.get();
        RotateThirdPersonBackValue = RotateThirdPersonBack.get();
        RotateKeyUseValue=RotateKeyUse.get();
        RotatePickItemValue=RotatePickItem.get();
        RotateAttackValue=RotateAttack.get();
        ModeFirstPersonValue=ModeFirstPerson.get();
        ModeThirdPersonFrontValue=ModeThirdPersonFront.get();
        ModeThirdPersonBackValue=ModeThirdPersonBack.get();
        AutoSwitchPerspectiveValue= (SwitchPerspective) AutoSwitchPerspective.get();
        AutoSwitchPerspeciveBackValue=AutoSwitchPerspeciveBack.get();
        AutoSwapPerspectiveValue= (SwitchPerspective) AutoSwapPerspective.get();
        AutoSwapPerspeciveBackValue=AutoSwapPerspeciveBack.get();
        UpSideDownValue=UpSideDown.get();
    }
}
