package com.Placid_Storm.Tutorial.items.tools;

import com.Placid_Storm.Tutorial.Main;
import com.Placid_Storm.Tutorial.init.ModItems;
import com.Placid_Storm.Tutorial.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {
    public ToolPickaxe(String name, Item.ToolMaterial material){

        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {

        Main.proxy.registerItemRenderer(this, 0,"inventory");
    }
}
