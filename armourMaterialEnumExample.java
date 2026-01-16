package ;  // whatever your package directory is

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

import // import your existing itemregistration

public enum ModArmorMaterial implements IArmorMaterial {  
    
    // ========== ARMOR MATERIALS ==========
    ARMOUR_MATERIAL("modid:texture_armour_example",            // the texture name it looks for before _layer1_ and _layer2_ so "texture_armour_example_layer1_" and "texture_armour_example_layer2_"  and Armour Material that has already been regitered NAME
        20,                                   // durabilityMultiplier can be anything     
        new int[]{3, 6, 8, 3},          // defence values for boots, leggings , chestplace , helmet  called slotProtections[] in minecraft
        10,                              //enchantment value
        SoundEvents.ARMOR_EQUIP_DIAMOND,   //sound
        2.0F,                    //toughness
        0.1F,      // knockback resistance           
        () -> Ingredient.of(ItemRegistration.MATERIAL_INGOT.get()));  // <-- Varies with each material  must have registred as an item
    // YOU Can add as many other Armour materials as you want with different values like this for example
 // RUBY("modid:texture_armour_ruby",            
       // 15,                                  
       // new int[]{10, 13, 18, 10},          
       // 5, 
      //  SoundEvents.ARMOR_EQUIP_IRON, 
       // 2.5F,                   
      //  0.5F,      // knockback resistance           
      //  () -> Ingredient.of(ItemRegistration.RUBY.get()));
  // TOPAZ("modid:texture_armour_topaz",            
       // 15,                                  
       // new int[]{11, 12, 19, 11},          
       // 9, 
      //  SoundEvents.ARMOR_EQUIP_IRON, 
       // 3.0F,       //F just means its a float nmbr              
      //  0.9F,      // knockback resistance           
      //  () -> Ingredient.of(ItemRegistration.TOPAZ.get()));
    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};    // keep this for each armour slot (its the base)  insted change the multipler of each armour if you want stronger armour durability
    
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    
    // Constructor - MUST MATCH enum name
    ModArmorMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness,float knockbackResistance, Supplier<Ingredient> repairIngredient) {        
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }
    //getters
    @Override  //@Override = "I'm REPLACING how SwordItem does this"
    public int getDurabilityForSlot(EquipmentSlotType slotType) {
        return HEALTH_PER_SLOT[slotType.getIndex()] * this.durabilityMultiplier;        // for durability  HEALTH_PER_SLOT = new int[]{13, 15, 16, 11}; * durability multiplier
    }
    
    @Override
    public int getDefenseForSlot(EquipmentSlotType slotType) {
        return this.slotProtections[slotType.getIndex()];        //each armour have different indexes so need to getIndex of each armourslot
    }
    
    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }
    
    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }
    
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
    
  
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public float getToughness() {
        return this.toughness;
    }
    
    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
