package net.fabricmc.caveaoc.core;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.caveaoc.common.properties.items.CACToolMaterials;
import net.fabricmc.caveaoc.common.properties.items.DaggerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.intellij.lang.annotations.Identifier;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("deprecation")
public class CACItems {
    public static List<Item> itemsList = new ArrayList<>();
    //------------------------------------------------------------------------
    public static final Item RAW_PERIDOT = createItem(new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)), "raw_peridot");
    public static final Item REFINED_PERIDOT = createItem(new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)), "refined_peridot");

    public static final Item SMALL_PERIDOT_BUD = createItem(new BlockItem(CACBlocks.SMALL_PERIDOT_BUD, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.SMALL_PERIDOT_BUD));
    public static final Item MEDIUM_PERIDOT_BUD = createItem(new BlockItem(CACBlocks.MEDIUM_PERIDOT_BUD, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.MEDIUM_PERIDOT_BUD));
    public static final Item LARGE_PERIDOT_BUD = createItem(new BlockItem(CACBlocks.LARGE_PERIDOT_BUD, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.LARGE_PERIDOT_BUD));
    public static final Item PERIDOT_CLUSTER = createItem(new BlockItem(CACBlocks.PERIDOT_CLUSTER, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.PERIDOT_CLUSTER));
    public static final Item RAW_PERIDOT_BLOCK = createItem(new BlockItem(CACBlocks.RAW_PERIDOT_BLOCK, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.RAW_PERIDOT_BLOCK));
    public static final Item RAW_BUDDING_PERIDOT_BLOCK = createItem(new BlockItem(CACBlocks.RAW_BUDDING_PERIDOT_BLOCK, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.RAW_BUDDING_PERIDOT_BLOCK));

    public static final Item PERIDOT_DAGGER = createItem(new DaggerItem(CACToolMaterials.PERIDOT, 3, -0.5f, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)), "peridot_dagger");

    public static final Item PILLOW_LAVA = createItem(new BlockItem(CACBlocks.PILLOW_LAVA, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.PILLOW_LAVA));
    public static final Item DEEP_CRUMBLY_STONE = createItem(new BlockItem(CACBlocks.DEEP_CRUMBLY_STONE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.DEEP_CRUMBLY_STONE));
    public static final Item MAGMATIC_VENT = createItem(new BlockItem(CACBlocks.MAGMATIC_VENT, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.MAGMATIC_VENT));

    public static final Item CRUMBLY_STONE = createItem(new BlockItem(CACBlocks.CRUMBLY_STONE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.CRUMBLY_STONE));
    public static final Item ROOTED_CRUMBLY_STONE = createItem(new BlockItem(CACBlocks.ROOTED_CRUMBLY_STONE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.ROOTED_CRUMBLY_STONE));
    public static final Item HANGING_CRUMBLY_ROOTS = createItem(new BlockItem(CACBlocks.HANGING_CRUMBLY_ROOTS, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.HANGING_CRUMBLY_ROOTS));
    public static final Item CRUMBLY_ROSE = createItem(new BlockItem(CACBlocks.CRUMBLY_ROSE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.CRUMBLY_ROSE));
    public static final Item PRIM_SPECTRAL_VINES = createItem(new BlockItem(CACBlocks.PRIM_SPECTRAL_VINES, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.PRIM_SPECTRAL_VINES));

    public static final Item LURKWOOD_LOG = createItem(new BlockItem(CACBlocks.LURKWOOD_LOG, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.LURKWOOD_LOG));
    public static final Item LURKWOOD_WOOD = createItem(new BlockItem(CACBlocks.LURKWOOD_WOOD, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.LURKWOOD_WOOD));
    public static final Item STRIPPED_LURKWOOD_LOG = createItem(new BlockItem(CACBlocks.STRIPPED_LURKWOOD_LOG, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.STRIPPED_LURKWOOD_LOG));
    public static final Item STRIPPED_LURKWOOD_WOOD = createItem(new BlockItem(CACBlocks.STRIPPED_LURKWOOD_WOOD, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.STRIPPED_LURKWOOD_WOOD));
    public static final Item LURKWOOD_PLANKS = createItem(new BlockItem(CACBlocks.LURKWOOD_PLANKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), Registry.BLOCK.getKey(CACBlocks.LURKWOOD_PLANKS));
    public static final Item LURKWOOD_SAPLING = createItem(new BlockItem(CACBlocks.LURKWOOD_SAPLING, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.LURKWOOD_SAPLING));
    public static final Item LURKWOOD_LEAVES = createItem(new BlockItem(CACBlocks.LURKWOOD_LEAVES, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), Registry.BLOCK.getKey(CACBlocks.LURKWOOD_LEAVES));
    public static final Item LURK_FRUIT = createItem(new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(Foods.APPLE)), "lurk_fruit");

    //------------------------------------------------------------------------

    public static Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
            Registry.register(Registry.ITEM, id, item);
//            item.setRegistryName(id); //Forge
            itemsList.add(item);
            return item;
        } else {
            return null;
        }
    }

    public static Item createItem(Item item, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), item);
//        item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        itemsList.add(item);
        return item;
    }

    public static void init() {
    }
}
