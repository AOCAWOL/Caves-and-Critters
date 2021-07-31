package net.fabricmc.caveaoc.core;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("deprecation")
public class CACItems {
    public static List<Item> itemsList = new ArrayList<>();
    //------------------------------------------------------------------------
    public static final Item RAW_PERIDOT = createItem(new Item(new Item.Settings().group(ItemGroup.MISC)), "raw_peridot");

    public static final Item PERIDOT_CLUSTER = createItem(new BlockItem(CACBlocks.PERIDOT_CLUSTER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)), Registry.BLOCK.getId(CACBlocks.PERIDOT_CLUSTER));
    public static final Item LARGE_PERIDOT_BUD = createItem(new BlockItem(CACBlocks.LARGE_PERIDOT_BUD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)), Registry.BLOCK.getId(CACBlocks.LARGE_PERIDOT_BUD));
    public static final Item MEDIUM_PERIDOT_BUD = createItem(new BlockItem(CACBlocks.MEDIUM_PERIDOT_BUD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)), Registry.BLOCK.getId(CACBlocks.MEDIUM_PERIDOT_BUD));
    public static final Item SMALL_PERIDOT_BUD = createItem(new BlockItem(CACBlocks.SMALL_PERIDOT_BUD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)), Registry.BLOCK.getId(CACBlocks.SMALL_PERIDOT_BUD));
    public static final Item RAW_PERIDOT_BLOCK = createItem(new BlockItem(CACBlocks.RAW_PERIDOT_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)), Registry.BLOCK.getId(CACBlocks.RAW_PERIDOT_BLOCK));
    public static final Item RAW_BUDDING_PERIDOT_BLOCK = createItem(new BlockItem(CACBlocks.RAW_BUDDING_PERIDOT_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)), Registry.BLOCK.getId(CACBlocks.RAW_BUDDING_PERIDOT_BLOCK));

    //------------------------------------------------------------------------
    public static Item createItem(Item item, Identifier id) {
        if (id != null && !id.equals(new Identifier("minecraft:air"))) {
            Registry.register(Registry.ITEM, id, item);
//            item.setRegistryName(id); //Forge
            itemsList.add(item);
            return item;
        } else {
            return null;
        }
    }

    public static Item createItem(Item item, String id) {
        Registry.register(Registry.ITEM, new Identifier(CavesAndCrittersMain.MOD_ID, id), item);
//        item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        itemsList.add(item);
        return item;
    }

    public static void init() {
    }
}
