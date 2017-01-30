package cn.mccraft.chinacraft.util.loader.annotation;

public @interface RegItem {
    /**
     * The params to build registryName and unlocalizedName.
     * @see cn.mccraft.chinacraft.util.NameBuilder
     */
    String[] value();

    /**
     * All {@link net.minecraftforge.oredict.OreDictionary} values to be registered.
     */
    String[] oreDict() default {};

    /**
     * Add prefix on value
     * Example: wandIron -> itemWandIron
     */
    String prefix() default "item";
}