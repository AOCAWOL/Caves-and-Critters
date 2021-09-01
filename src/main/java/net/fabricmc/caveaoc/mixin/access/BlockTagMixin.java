package net.fabricmc.caveaoc.mixin.access;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockTags.class)
public class BlockTagMixin {

    @Invoker
    public static Tag.Named<Block> invokeBind(String string) {
        throw new Error("Mixin did not apply!");
    }
}
