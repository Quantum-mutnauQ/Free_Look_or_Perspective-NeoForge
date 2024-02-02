package quatum.freelookforge.KeyBinding;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.apache.commons.codec.language.bm.Lang;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class FreeLookKey {
    public static final String KEY_CATEGORY_FREELOOK = "key.category.freelook";
    public static final String KEY_FREE_LOOK = "key.freelookforge.freelook";

    public static final KeyMapping FREELOOK_KAY = new KeyMapping(KEY_FREE_LOOK, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F6,KEY_CATEGORY_FREELOOK);

}
