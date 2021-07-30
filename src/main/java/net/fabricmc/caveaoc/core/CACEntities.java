package net.fabricmc.caveaoc.core;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.DirtPathBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SuppressWarnings("deprecation")
public class CACEntities {
    public static Set<EntityType<?>> entities = new HashSet<>();

//    public static final EntityType<BYGBoatEntity> BOAT = createEntity("boat", EntityType.Builder.<BYGBoatEntity>create(BYGBoatEntity::new, SpawnGroup.MISC).setDimensions(1.375F, 0.5625F).build(BYG.MOD_ID + ":boat"));

    public static <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(CavesAndCrittersMain.MOD_ID, id), entityType);
//        entityType.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        entities.add(entityType);
        return entityType;
    }

    public static void init() {
    }
}
