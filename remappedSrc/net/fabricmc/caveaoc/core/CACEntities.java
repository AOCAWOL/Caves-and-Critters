package net.fabricmc.caveaoc.core;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.*;


@SuppressWarnings("deprecation")
public class CACEntities {
    public static Set<EntityType<?>> entities = new HashSet<>();

//    public static final EntityType<BYGBoatEntity> BOAT = createEntity("boat", EntityType.Builder.<BYGBoatEntity>create(BYGBoatEntity::new, SpawnGroup.MISC).setDimensions(1.375F, 0.5625F).build(BYG.MOD_ID + ":boat"));

    public static <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), entityType);
//        entityType.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        entities.add(entityType);
        return entityType;
    }

    public static void init() {
    }
}
