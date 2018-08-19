package com.Placid_Storm.Tutorial.init;

import com.Placid_Storm.Tutorial.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block RUBY_BLOCK = new BlockBase("ruby_block", Material.IRON);
}
