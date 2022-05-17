package potionstudios.cavesandcritters.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import potionstudios.cavesandcritters.CavesAndCritters;
import potionstudios.cavesandcritters.reg.BlockRegistryObject;
import potionstudios.cavesandcritters.reg.RegistrationProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


@SuppressWarnings("deprecation")
public class CACBlocks {
    public static final RegistrationProvider<Block> PROVIDER = RegistrationProvider.get(Registry.BLOCK_REGISTRY, CavesAndCritters.MOD_ID);
    public static List<BlockRegistryObject<Block>> flowerPotBlocks = new ArrayList<>();

    public static final BlockRegistryObject<Block> PERIDOT_CLUSTER = createPeridotClusterBlock(13, 7, 3, SoundType.AMETHYST_CLUSTER, "peridot_cluster");
    public static final BlockRegistryObject<Block> LARGE_PERIDOT_BUD = createPeridotBudBlock(10, 5, 3, SoundType.LARGE_AMETHYST_BUD, "large_peridot_bud");
    public static final BlockRegistryObject<Block> MEDIUM_PERIDOT_BUD = createPeridotBudBlock(8, 4, 3, SoundType.MEDIUM_AMETHYST_BUD, "medium_peridot_bud");
    public static final BlockRegistryObject<Block> SMALL_PERIDOT_BUD = createPeridotBudBlock(5, 3, 4, SoundType.SMALL_AMETHYST_BUD, "small_peridot_bud");

    public static final BlockRegistryObject<Block> PILLOW_LAVA = createPillowLavaBlock(8, SoundType.NETHERRACK, "pillow_lava");
    public static final BlockRegistryObject<Block> RAW_PERIDOT_BLOCK = createPeridotBlock(5, SoundType.AMETHYST_CLUSTER, "raw_peridot_block");
    public static final BlockRegistryObject<Block> RAW_BUDDING_PERIDOT_BLOCK = createBuddingPeridotBlock(5, SoundType.AMETHYST_CLUSTER, "raw_budding_peridot_block");
    public static final BlockRegistryObject<Block> DEEP_CRUMBLY_STONE = createCrumblyStoneBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.DEEPSLATE, "deep_crumbly_stone");
    public static final BlockRegistryObject<Block> MAGMATIC_VENT = createMagmaticVentBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.DEEPSLATE, "magmatic_vent");

    public static final BlockRegistryObject<Block> CRUMBLY_STONE = createCrumblyStoneBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.STONE, "crumbly_stone");
    public static final BlockRegistryObject<Block> ROOTED_CRUMBLY_STONE = createRootedCrumblyStoneBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.STONE, "rooted_crumbly_stone");
    public static final BlockRegistryObject<Block> HANGING_CRUMBLY_ROOTS = createHangingCrumblyRootsBlock(SoundType.ROOTED_DIRT, MaterialColor.TERRACOTTA_GREEN, "hanging_crumbly_roots");
    public static final BlockRegistryObject<Block> CRUMBLY_ROSE = createCrumblyRoseBlock(SoundType.GRASS, MaterialColor.TERRACOTTA_MAGENTA, "crumbly_rose");
    public static final BlockRegistryObject<Block> PRIM_SPECTRAL_VINES = createPrimSpectralVinesBlock(10, SoundType.CAVE_VINES, MaterialColor.TERRACOTTA_WHITE, "prim_spectral_vines");
    public static final BlockRegistryObject<Block> PRIM_SPECTRAL_VINES_PLANT = createPrimSpectralVinesPlantBlock(10, SoundType.CAVE_VINES, MaterialColor.TERRACOTTA_WHITE, "prim_spectral_vines_plant");

    public static final BlockRegistryObject<Block> LURKWOOD_LOG = createLogBlock(MaterialColor.GRASS, MaterialColor.WOOD, SoundType.WOOD, "lurkwood_log");
    public static final BlockRegistryObject<Block> LURKWOOD_WOOD = createLogBlock(MaterialColor.GRASS, MaterialColor.GRASS, SoundType.WOOD, "lurkwood_wood");
    public static final BlockRegistryObject<Block> STRIPPED_LURKWOOD_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, SoundType.WOOD, "stripped_lurkwood_log");
    public static final BlockRegistryObject<Block> STRIPPED_LURKWOOD_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, SoundType.WOOD, "stripped_lurkwood_wood");
    public static final BlockRegistryObject<Block> LURKWOOD_PLANKS = createPlanksBlock(MaterialColor.WOOD, SoundType.WOOD, "lurkwood_planks");

    public static final BlockRegistryObject<Block> LURKWOOD_SAPLING = createSaplingBlock(MaterialColor.PLANT, SoundType.AZALEA, "lurkwood_sapling");
    public static final BlockRegistryObject<Block> LURKWOOD_LEAVES = createLeavesBlock(MaterialColor.TERRACOTTA_GREEN, SoundType.AZALEA_LEAVES, "lurkwood_leaves");

    //------------------------------------------------------------------------
    static BlockRegistryObject<Block> createLogBlock(MaterialColor materialColor, MaterialColor materialColor2, SoundType sound, String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (blockState) -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? materialColor : materialColor2).sound(sound).strength(2.0f)), id);

    }

    static BlockRegistryObject<Block> createPlanksBlock(MaterialColor materialColor, SoundType sound, String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.WOOD, materialColor).sound(sound).strength(2.0f, 3.0f)), id);

    }

    static BlockRegistryObject<Block> createSaplingBlock(MaterialColor materialColor, SoundType sound, String id) {
        return createBlock(() -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 5, BlockBehaviour.Properties.of(Material.PLANT, materialColor).sound(sound).noCollission().instabreak()), id);

    }

    static BlockRegistryObject<Block> createLeavesBlock(MaterialColor materialColor, SoundType sound, String id) {
        return createBlock(() -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, materialColor).sound(sound).randomTicks().noOcclusion().isValidSpawn(CACBlocks::ocelotOrParrot).isSuffocating(CACBlocks::never).isViewBlocking(CACBlocks::never)), id);

    }


    static BlockRegistryObject<Block> createPeridotBudBlock(int light, int height, int xzOffset, SoundType sound, String id) {
        return createBlock(() -> new AmethystClusterBlock(height, xzOffset, BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).noOcclusion().sound(sound).randomTicks().strength(1.5f).lightLevel((state) -> light)), id);

    }

    static BlockRegistryObject<Block> createPeridotClusterBlock(int light, int height, int xzOffset, SoundType sound, String id) {
        return createBlock(() -> new PeridotClusterBlock(height, xzOffset, BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).noOcclusion().sound(sound).randomTicks().strength(1.5f).lightLevel((state) -> light)), id);

    }

    static BlockRegistryObject<Block> createPeridotBlock(int light, SoundType sound, String id) {
        return createBlock(() -> new AmethystBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).requiresCorrectToolForDrops().sound(sound).strength(1.5f).lightLevel((state) -> light)), id);

    }

    static BlockRegistryObject<Block> createBuddingPeridotBlock(int light, SoundType sound, String id) {
        return createBlock(() -> new BuddingPeridotBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).requiresCorrectToolForDrops().sound(sound).randomTicks().strength(1.5f).lightLevel((state) -> light)), id);

    }

    static BlockRegistryObject<Block> createPillowLavaBlock(int light, SoundType sound, String id) {
        return createBlock(() -> new PillowLavaBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().sound(sound).strength(1.5f).lightLevel((state) -> light)), id);

    }

    static BlockRegistryObject<Block> createCrumblyStoneBlock(SoundType sound, MaterialColor materialColor, String id) {
        return createBlock(() -> new CrumblyBlock(BlockBehaviour.Properties.of(Material.STONE, materialColor).requiresCorrectToolForDrops().sound(sound).strength(1.5f)), id);

    }

    static BlockRegistryObject<Block> createMagmaticVentBlock(SoundType sound, MaterialColor materialColor, String id) {
        return createBlock(() -> new MagmaticVentBlock(BlockBehaviour.Properties.of(Material.STONE, materialColor).requiresCorrectToolForDrops().sound(sound).strength(1.5f)), id);

    }

    static BlockRegistryObject<Block> createHangingCrumblyRootsBlock(SoundType sound, MaterialColor materialColor, String id) {
        return createBlock(() -> new HangingCrumblyRoots(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, materialColor).noCollission().instabreak().sound(sound)), id);

    }

    static BlockRegistryObject<Block> createRootedCrumblyStoneBlock(SoundType sound, MaterialColor materialColor, String id) {
        return createBlock(() -> new RootedCrumblyStoneBlock(BlockBehaviour.Properties.of(Material.STONE, materialColor).requiresCorrectToolForDrops().sound(sound).strength(1.5f)), id);

    }

    static BlockRegistryObject<Block> createCrumblyRoseBlock(SoundType sound, MaterialColor materialColor, String id) {
        return createBlock(() -> new CrumblyRoseBlock(MobEffects.REGENERATION, 5, BlockBehaviour.Properties.of(Material.PLANT, materialColor).noCollission().instabreak().sound(sound)), id);

    }

    static BlockRegistryObject<Block> createPrimSpectralVinesBlock(int light, SoundType sound, MaterialColor materialColor, String id) {
        return createBlock(() -> new PrimSpectralVinesBlock(BlockBehaviour.Properties.of(Material.PLANT, materialColor).randomTicks().noCollission().instabreak().sound(sound).lightLevel((state) -> light)), id);

    }

    static BlockRegistryObject<Block> createPrimSpectralVinesPlantBlock(int light, SoundType sound, MaterialColor materialColor, String id) {
        return createBlock(() -> new PrimSpectralVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT, materialColor).randomTicks().noCollission().instabreak().sound(sound).lightLevel((state) -> light)), id);

    }

    private static Boolean ocelotOrParrot(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    public static void bootstrap() {
    }

    public static <B extends Block> BlockRegistryObject<B> createBlock(Supplier<? extends B> block, String id) {
        final var ro = PROVIDER.<B>register(id, block);
        return BlockRegistryObject.wrap(ro);
    }
}
