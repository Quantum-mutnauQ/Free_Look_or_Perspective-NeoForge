package quatum.freelookneoforge.KeyBinding;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.common.Mod;


import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class FreeLookKey {
    public static final KeyMapping.Category KEY_CATEGORY_FREELOOK = KeyMapping.Category.register(ResourceLocation.parse("freelook:freelook"));
    public static final String KEY_FREE_LOOK = "key.freelookneoforge.freelook";
    public static final String KEY_PERSPECTIVE_SWAP = "key.freelookneoforge.perspectiveswap";


    public static final KeyMapping FREELOOK_KAY = new KeyMapping(KEY_FREE_LOOK, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F6,KEY_CATEGORY_FREELOOK);
    public static final KeyMapping PERSPECTIVESWAP_KAY = new KeyMapping(KEY_PERSPECTIVE_SWAP, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F7,KEY_CATEGORY_FREELOOK);

}
