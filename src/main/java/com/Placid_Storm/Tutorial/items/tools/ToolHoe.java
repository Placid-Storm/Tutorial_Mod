package com.Placid_Storm.Tutorial.items.tools;

import com.Placid_Storm.Tutorial.Main;
import com.Placid_Storm.Tutorial.init.ModItems;
import com.Placid_Storm.Tutorial.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel {
    public ToolHoe(String name, Item.ToolMaterial material){

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
