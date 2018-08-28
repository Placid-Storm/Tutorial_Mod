package com.Placid_Storm.Tutorial.util.handlers;

import com.Placid_Storm.Tutorial.blocks.Tile_Entity_Iron_Furnace;
import com.Placid_Storm.Tutorial.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(Tile_Entity_Iron_Furnace.class, new ResourceLocation(Reference.MOD_ID + ":iron_furnace"));
    }
}
