package com.Placid_Storm.Tutorial.init;

import com.Placid_Storm.Tutorial.blocks.BlockBase;
import com.Placid_Storm.Tutorial.blocks.RubyBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block RUBY_BLOCK = new RubyBlock("ruby_block", Material.IRON);
}