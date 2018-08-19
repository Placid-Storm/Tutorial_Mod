package com.Placid_Storm.Tutorial.items.tools;

import com.Placid_Storm.Tutorial.Main;
import com.Placid_Storm.Tutorial.init.ModItems;
import com.Placid_Storm.Tutorial.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {
    public ToolAxe(String name, Item.ToolMaterial material){

        super(material, 8.0F, -3.0F);
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
