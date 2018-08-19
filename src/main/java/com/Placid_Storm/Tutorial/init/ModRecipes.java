package com.Placid_Storm.Tutorial.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){
        GameRegistry.addSmelting(ModBlocks.RUBY_BLOCK, new ItemStack(ModItems.RUBY, 9),1.5F);

    }
}
