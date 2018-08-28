package com.Placid_Storm.Tutorial.util.handlers;

import com.Placid_Storm.Tutorial.blocks.ContainerIronFurnace;
import com.Placid_Storm.Tutorial.blocks.Gui_Iron_Furnace;
import com.Placid_Storm.Tutorial.blocks.Tile_Entity_Iron_Furnace;
import com.Placid_Storm.Tutorial.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Reference.GUI_IRON_FURNACE) return new ContainerIronFurnace(player.inventory, (Tile_Entity_Iron_Furnace) world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Reference.GUI_IRON_FURNACE) return new Gui_Iron_Furnace(player.inventory, (Tile_Entity_Iron_Furnace)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }
}
