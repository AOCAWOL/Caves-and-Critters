package potionstudios.cavesandcritters.common.items;

import net.minecraft.core.Registry;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import potionstudios.cavesandcritters.CavesAndCritters;
import potionstudios.cavesandcritters.common.blocks.CACBlocks;
import potionstudios.cavesandcritters.platform.ModPlatform;
import potionstudios.cavesandcritters.reg.RegistrationProvider;
import potionstudios.cavesandcritters.reg.RegistryObject;

import java.util.function.Supplier;


public class CACItems {
    public static final RegistrationProvider<Item> PROVIDER = RegistrationProvider.get(Registry.ITEM_REGISTRY, CavesAndCritters.MOD_ID);


    //------------------------------------------------------------------------
    public static final RegistryObject<Item> RAW_PERIDOT = createItem(() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)), "raw_peridot");
    public static final RegistryObject<Item> REFINED_PERIDOT = createItem(() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)), "refined_peridot");

    public static final RegistryObject<Item> SMALL_PERIDOT_BUD = createItem(CACBlocks.SMALL_PERIDOT_BUD);
    public static final RegistryObject<Item> MEDIUM_PERIDOT_BUD = createItem(CACBlocks.MEDIUM_PERIDOT_BUD);
    public static final RegistryObject<Item> LARGE_PERIDOT_BUD = createItem(CACBlocks.LARGE_PERIDOT_BUD);
    public static final RegistryObject<Item> PERIDOT_CLUSTER = createItem(CACBlocks.PERIDOT_CLUSTER);
    public static final RegistryObject<Item> RAW_PERIDOT_BLOCK = createItem(CACBlocks.RAW_PERIDOT_BLOCK);
    public static final RegistryObject<Item> RAW_BUDDING_PERIDOT_BLOCK = createItem(CACBlocks.RAW_BUDDING_PERIDOT_BLOCK);

    public static final RegistryObject<Item> PERIDOT_DAGGER = createItem(() -> new DaggerItem(CACToolMaterials.PERIDOT, 3, -0.5f, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)), "peridot_dagger");

    public static final RegistryObject<Item> PILLOW_LAVA = createItem(CACBlocks.PILLOW_LAVA);
    public static final RegistryObject<Item> DEEP_CRUMBLY_STONE = createItem(CACBlocks.DEEP_CRUMBLY_STONE);
    public static final RegistryObject<Item> MAGMATIC_VENT = createItem(CACBlocks.MAGMATIC_VENT);

    public static final RegistryObject<Item> CRUMBLY_STONE = createItem(CACBlocks.CRUMBLY_STONE);
    public static final RegistryObject<Item> ROOTED_CRUMBLY_STONE = createItem(CACBlocks.ROOTED_CRUMBLY_STONE);
    public static final RegistryObject<Item> HANGING_CRUMBLY_ROOTS = createItem(CACBlocks.HANGING_CRUMBLY_ROOTS);
    public static final RegistryObject<Item> CRUMBLY_ROSE = createItem(CACBlocks.CRUMBLY_ROSE);
    public static final RegistryObject<Item> PRIM_SPECTRAL_VINES = createItem(CACBlocks.PRIM_SPECTRAL_VINES);

    public static final RegistryObject<Item> LURKWOOD_LOG = createItem(CACBlocks.LURKWOOD_LOG);
    public static final RegistryObject<Item> LURKWOOD_WOOD = createItem(CACBlocks.LURKWOOD_WOOD);
    public static final RegistryObject<Item> STRIPPED_LURKWOOD_LOG = createItem(CACBlocks.STRIPPED_LURKWOOD_LOG);
    public static final RegistryObject<Item> STRIPPED_LURKWOOD_WOOD = createItem(CACBlocks.STRIPPED_LURKWOOD_WOOD);
    public static final RegistryObject<Item> LURKWOOD_PLANKS = createItem(CACBlocks.LURKWOOD_PLANKS);
    public static final RegistryObject<Item> LURKWOOD_SAPLING = createItem(CACBlocks.LURKWOOD_SAPLING);
    public static final RegistryObject<Item> LURKWOOD_LEAVES = createItem(CACBlocks.LURKWOOD_LEAVES);
    public static final RegistryObject<Item> LURK_FRUIT = createItem(() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(Foods.APPLE)), "lurk_fruit");

    //------------------------------------------------------------------------

    public static RegistryObject<Item> createItem(RegistryObject<? extends Block> block) {
        return createItem(() -> new BlockItem(block.get(), new Item.Properties().tab(ModPlatform.INSTANCE.creativeTab())), block);
    }

    public static <T extends Item> RegistryObject<T> createItem(Supplier<? extends T> item, RegistryObject<? extends Block> block) {
        return createItem(item, block.getId().getPath());
    }

    public static <T extends Item> RegistryObject<T> createItem(Supplier<? extends T> item, String id) {
        return PROVIDER.register(id, item);
    }


    public static void bootstrap() {
    }
}
