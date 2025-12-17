// add your own package
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistration {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, "YOUR MOD ID in mod.toml");
    
    public static final RegistryObject<Item> TEST_BLOCK_ITEM = ITEMS.register(
        "test_block",
        () -> new BlockItem(
            BlockRegistration.TEST_BLOCK.get(),
            new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)
        )
    );
}
