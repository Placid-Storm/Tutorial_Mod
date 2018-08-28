package com.Placid_Storm.Tutorial.blocks;

import com.Placid_Storm.Tutorial.Main;
import com.Placid_Storm.Tutorial.init.ModBlocks;
import com.Placid_Storm.Tutorial.util.Reference;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class Iron_Furnace extends BlockBase {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyBool BURNING = PropertyBool.create("burning");

    public Iron_Furnace(String name, Material material)

    {

        super(name,material);

        setSoundType(SoundType.METAL);

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING, false));

    }



    @Override

    public Item getItemDropped(IBlockState state, Random rand, int fortune)

    {

        return null; //Item.getItemFromBlock(BlockInit.SINTERING_FURNACE);

    }



    @Override

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)

    {

        return null; //new ItemStack(BlockInit.SINTERING_FURNACE);

    }



    @Override

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)

    {

        if(!worldIn.isRemote)

        {

            playerIn.openGui(Main.instance, Reference.GUI_IRON_FURNACE, worldIn, pos.getX(), pos.getY(), pos.getZ());

        }



        return true;

    }



    @Override

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)

    {

        if (!worldIn.isRemote)

        {

            IBlockState north = worldIn.getBlockState(pos.north());

            IBlockState south = worldIn.getBlockState(pos.south());

            IBlockState west = worldIn.getBlockState(pos.west());

            IBlockState east = worldIn.getBlockState(pos.east());

            EnumFacing face = (EnumFacing)state.getValue(FACING);



            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;

            else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;

            else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.EAST;

            else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.WEST;

            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);

        }

    }



    public static void setState(boolean active, World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);

        //keepInventory = true;

        if (active)
        {
            worldIn.setBlockState(pos, ModBlocks.IRON_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, true), 3);
            worldIn.setBlockState(pos, ModBlocks.IRON_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, true), 3);
        }
        else
        {
            worldIn.setBlockState(pos, ModBlocks.IRON_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, false), 3);
            worldIn.setBlockState(pos, ModBlocks.IRON_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, false), 3);
        }

        //keepInventory = false;

        if(tileentity != null){
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }



    @Override

    public boolean hasTileEntity(IBlockState state)

    {

        return true;

    }



    @Override

    public TileEntity createTileEntity(World world, IBlockState state)

    {

        return new Tile_Entity_Iron_Furnace();

    }



    @Override

    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)

    {

        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());

    }



    @Override

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)

    {

        worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

    }



    @Override

    public EnumBlockRenderType getRenderType(IBlockState state)

    {

        return EnumBlockRenderType.MODEL;

    }



    @Override

    public IBlockState withRotation(IBlockState state, Rotation rot)

    {

        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));

    }



    @Override

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)

    {

        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));

    }



    @Override

    protected BlockStateContainer createBlockState()

    {

        return new BlockStateContainer(this, new IProperty[] {BURNING,FACING});

    }



    @Override

    public IBlockState getStateFromMeta(int meta)

    {

        EnumFacing facing = EnumFacing.getFront(meta);

        if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;

        return this.getDefaultState().withProperty(FACING, facing);

    }



    @Override

    public int getMetaFromState(IBlockState state)

    {

        return ((EnumFacing)state.getValue(FACING)).getIndex();

    }
}