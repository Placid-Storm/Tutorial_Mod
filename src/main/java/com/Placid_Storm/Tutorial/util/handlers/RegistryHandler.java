package com.Placid_Storm.Tutorial.util.handlers;

import com.Placid_Storm.Tutorial.init.ModBlocks;
import com.Placid_Storm.Tutorial.init.ModItems;
import com.Placid_Storm.Tutorial.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

//Subscribe Event to register all the items.
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){

        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

//Subscribe Event to register all the items.
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event){

        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }
//Subscribe Event to assign models if the item has a model.
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for(Item item: ModItems.ITEMS){
            if(item instanceof IHasModel){
                ((IHasModel)item).registerModels();
            }
        }
        for(Block block: ModBlocks.BLOCKS){
            if(block instanceof IHasModel){
                ((IHasModel)block).registerModels();
            }
        }
    }
}
