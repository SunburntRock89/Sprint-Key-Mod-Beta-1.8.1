// Written by SunburntRock89 <https://github.com/SunburntRock89> <SunburntRock89#6617>

package net.minecraft.src;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.Minecraft;

public class mod_sprintKey extends BaseMod {
	public String Version() {
		return "Sprint Key Mod v1.0 for Minecraft Beta 1.8.1 by SunburntRock89";
	}
	
	private KeyBinding sprintKey = new KeyBinding("Sprint", 29);
	
	public mod_sprintKey() {
		ModLoader.RegisterKey(this, sprintKey, true);
		ModLoader.AddLocalization("Sprint", "Sprint");
		ModLoader.SetInGameHook(this, true, false);
	}
	
	public static Minecraft getMinecraft() {
		return ModLoader.getMinecraftInstance();
	}
	
	public static boolean isMoving(Entity entity) {
        return entity == getMinecraft().thePlayer ? ((getMinecraft().thePlayer.moveForward != 0 || getMinecraft().thePlayer.moveStrafing != 0)) : (entity.motionX != 0 || entity.motionZ != 0);
    }
	
	public boolean OnTickInGame(Minecraft minecraft) {
		EntityPlayerSP player = minecraft.thePlayer;
		boolean moving = this.isMoving(minecraft.thePlayer);
		// Do the sprint-a-majig;
		if (Keyboard.isKeyDown(this.sprintKey.keyCode)) {
			player.func_35113_c(true);
		} 
		if (moving == false) {
			player.func_35113_c(false);
		}
		return true;
	}
	
}
