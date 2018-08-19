package com.Placid_Storm.Tutorial.init;

import com.Placid_Storm.Tutorial.items.ItemBase;
import com.Placid_Storm.Tutorial.items.tools.*;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Materials
    public static final ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby",2,250,8.0F,3.0F,22);

    //Items
    public static final Item RUBY = new ItemBase("ruby");
    public static final Item OBSIDIAN_INGOT = new ItemBase("obsidian_ingot");

    //Tools
    public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", MATERIAL_RUBY);
    public static final ItemSpade RUBY_SHOVEL = new ToolSpade("ruby_shovel",MATERIAL_RUBY);
    public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", MATERIAL_RUBY);
    public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", MATERIAL_RUBY);
    public static final ItemHoe RUBY_HOE = new ToolHoe("ruby_hoe", MATERIAL_RUBY);
}
