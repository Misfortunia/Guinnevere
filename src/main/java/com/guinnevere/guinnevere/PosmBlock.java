package com.guinnevere.guinnevere;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PosmBlock extends Block {

    protected static final VoxelShape SHAPE = Shapes.or(
            Block.box(6.999, 0.499, 6.999, 10.001, 2.501, 9.001),
            Block.box(9, 0.5, 6, 10, 2.5, 7),
            Block.box(9, -0.2, 9.4, 10, 1.8, 10.4),
            Block.box(7, 0.5, 6, 8, 2.5, 7),
            Block.box(7, -0.2, 9.4, 8, 1.8, 10.4),
            Block.box(5, 0.25, 7, 6, 2.25, 9),
            Block.box(9.75, 1.25, 7.5, 11.75, 2.25, 8.5),
            Block.box(5.5, 2.25, 7, 6.5, 3.25, 7),
            Block.box(7, 2.25, 8.5, 8, 3.25, 8.5),
            Block.box(6.5, 1.5, 7.5, 7.5, 2.5, 8.5)
    ).optimize(); // optimize shape for performance

    public PosmBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        // return shape
        return SHAPE;
    }
}