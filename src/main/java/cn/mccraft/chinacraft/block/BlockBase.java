package cn.mccraft.chinacraft.block;

import cn.mccraft.chinacraft.init.CCCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Base block of ChinaCraft.
 * Extend this block in your own blocks.
 * ChinaCraft基础方块类，请在你的自定义方块中继承该类。
 */
public class BlockBase extends Block{

    public BlockBase(Material materialIn) {
        super(materialIn);
        setCreativeTab(CCCreativeTabs.tabCore);
    }
}
