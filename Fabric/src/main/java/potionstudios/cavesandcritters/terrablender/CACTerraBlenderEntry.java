package potionstudios.cavesandcritters.terrablender;

import potionstudios.cavesandcritters.CavesAndCrittersFabric;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class CACTerraBlenderEntry implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        CavesAndCrittersFabric.init("TerraBlender Initializer");

        Regions.register(new CavesAndCrittersRegion());
    }
}