package cn.mccraft.chinacraft.common.gui;

import cn.mccraft.chinacraft.common.ChinaCraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.lang.reflect.Constructor;

/**
 * Created by Mouse on 2017/1/28.
 */
public class GuiHandler implements IGuiHandler {
    public GuiHandler() {
        NetworkRegistry.INSTANCE.registerGuiHandler(ChinaCraft.getInstance(), this);
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        try {
            return EnumGuiType.values()[id].getContainerClass().newInstance();
        } catch (Exception e) {
            ChinaCraft.getLogger().error("Un-able to create a container with id " + id, e);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        try {
            Class<? extends GuiScreen> guiClass = EnumGuiType.values()[id].getGuiClass();
            for (Constructor<?> constructor : guiClass.getConstructors()) {
                if (constructor.getParameterCount() == 0)
                    return constructor.newInstance();
                else if (Container.class.isAssignableFrom(constructor.getParameterTypes()[0]))
                    return constructor.newInstance(EnumGuiType.values()[id].getContainerClass().newInstance());
            }
        } catch (Exception e) {
            ChinaCraft.getLogger().error("Un-able to create a gui with id " + id, e);
        }
        return null;
    }
}
