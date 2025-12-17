// add your own package

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;  
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistration {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, "YOUR OWN mod ID in mod.toml");
    
    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register(
        "test_block",
        () -> new Block(
            Block.Properties.of(Material.METAL)
                .strength(3.0f)
                .lightLevel(state -> 15)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
        )
    );
}

