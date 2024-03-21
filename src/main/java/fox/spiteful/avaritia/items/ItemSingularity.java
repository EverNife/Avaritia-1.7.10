package fox.spiteful.avaritia.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.Avaritia;
import fox.spiteful.avaritia.LudicrousText;
import fox.spiteful.avaritia.render.IHaloRenderItem;

public class ItemSingularity extends Item implements IHaloRenderItem {

    public static final String[] types = new String[] { "iron", "gold", "lapis", "redstone", "quartz", "copper", "tin",
            "lead", "silver", "nickel", "enderium", "clay" };
    public static final int[] colors = new int[] { 0xBFBFBF, 0xE8EF23, 0x5a82e2, 0xDF0000, 0xeeebe6, 0xE47200, 0xA5C7DE,
            0x444072, 0xF9F9F9, 0xDEE187, 0x47736d, 0x8890AD };
    public static final int[] colors2 = new int[] { 0x7F7F7F, 0xdba213, 0x224baf, 0x900000, 0x94867d, 0x89511A,
            0x9BA9B2, 0x3E3D4E, 0xD5D5D5, 0xC4C698, 0x1a3732, 0x666B7F };
    public static IIcon background;
    public static IIcon foreground;
    private final ISingularityType[] singularityTypes = new ISingularityType[]{
        new DefSingularityType("iron", 0x7F7F7F, 0xBFBFBF, EnumRarity.epic),
        new DefSingularityType("gold", 0xdba213, 0xE8EF23, EnumRarity.epic),
        new DefSingularityType("lapis", 0x224baf, 0x5a82e2, EnumRarity.epic),
        new DefSingularityType("redstone", 0x900000, 0xDF0000, EnumRarity.epic),
        new DefSingularityType("quartz", 0x94867d, 0xeeebe6, EnumRarity.epic),
        new DefSingularityType("copper", 0x89511A, 0xE47200, EnumRarity.epic),
        new DefSingularityType("tin", 0x9BA9B2, 0xA5C7DE, EnumRarity.epic),
        new DefSingularityType("lead", 0x3E3D4E, 0x444072, EnumRarity.epic),
        new DefSingularityType("silver", 0xD5D5D5, 0xF9F9F9, EnumRarity.epic),
        new DefSingularityType("nickel", 0xC4C698, 0xDEE187, EnumRarity.epic),
        new DefSingularityType("clay", 0x666B7F, 0x8890AD, EnumRarity.epic),

        /*
                  new DefSingularityType("cosmic", 0x351254, 0xc639ed, LudicrousItems.cosmic),
                  new DefSingularityType("mobium", 0x2f6b2c, 0xba5759, EnumRarity.epic),
                  new DefSingularityType("restonia_crystal", 0xbd0000, 0xff0000, EnumRarity.epic),
                  new DefSingularityType("palis_crystal", 0x0013a6, 0x142fff, EnumRarity.epic),
                  new DefSingularityType("diamatine_crystal", 0x0078db, 0x5eb6ff, EnumRarity.epic),
                  new DefSingularityType("void_crystal", 0x000000, 0x404040, EnumRarity.epic),
                  new DefSingularityType("emeradic_crystal", 0x0c9100, 0x11c900, EnumRarity.epic),
                  new DefSingularityType("enoric_crystal", 0xc7c7c7, 0xffffff, EnumRarity.epic),
                  new DefSingularityType("honey", 0xff8c00, 0xffb700, EnumRarity.epic),
                  new DefSingularityType("apatite", 0x0059ff, 0x0095ff, EnumRarity.epic),
        */
        new SingularityTypeCosmic("infinity", LudicrousItems.cosmic),

        new DefSingularityType("dirt", 0x663807, 0x945f2b, EnumRarity.epic),
        new DefSingularityType("stone", 0x534d54, 0x837d85, EnumRarity.epic),
        new DefSingularityType("coal", 0x1a1a1a, 0x3d3d3d, EnumRarity.epic),
        new DefSingularityType("diamond", 0x009e74, 0x24d4a5, EnumRarity.epic),
        new DefSingularityType("emerald", 0x1eb516, 0x27ed1c, EnumRarity.epic),
        new DefSingularityType("thaumium", 0x502c63, 0x8b62a1, EnumRarity.epic),
        new DefSingularityType("void_metal", 0x230136, 0x500e75, EnumRarity.epic),
        new DefSingularityType("draconium", 0x510b78, 0x8616c4, EnumRarity.epic),
        new DefSingularityType("awakened_draconium", 0xeb5200, 0xed8d07, EnumRarity.epic),
        new DefSingularityType("obsidian", 0x301159, 0x8d329c, EnumRarity.epic),
        new DefSingularityType("osmium", 0x5c777d, 0x8fb0c9, EnumRarity.epic),
        new DefSingularityType("glowstone", 0xb59100, 0xf5cb25, EnumRarity.epic),
        new DefSingularityType("steel", 0x595853, 0x828282, EnumRarity.epic),
        new DefSingularityType("certus_quartz_crystal", 0x86b3a3, 0xaee8d3, EnumRarity.epic),
        new DefSingularityType("fluix_crystal", 0xa1272d, 0x512c70, EnumRarity.epic),
        new DefSingularityType("manasteel", 0x0079d6, 0x3abcd6, EnumRarity.epic),
        new DefSingularityType("terrasteel", 0x00a30e, 0x1bcf2a, EnumRarity.epic),
        new DefSingularityType("elementium", 0xd10069, 0xe83a77, EnumRarity.epic),
        new DefSingularityType("gaia", 0x754c5b, 0xa37485, EnumRarity.epic),
        new DefSingularityType("platinum", 0x266fff, 0x6b91db, EnumRarity.epic),
        new DefSingularityType("mithril", 0x23478c, 0x465f8f, EnumRarity.epic),
        new DefSingularityType("electrum", 0xbaab20, 0xd1c232, EnumRarity.epic),
        new DefSingularityType("invar", 0x8f8c75, 0x96958d, EnumRarity.epic),
        new DefSingularityType("signalum", 0xed2000, 0xed4300, EnumRarity.epic),
        new DefSingularityType("lumium", 0xc9b05b, 0xffe17a, EnumRarity.epic),
        new DefSingularityType("enderium", 0x194f2c, 0x389458, EnumRarity.epic),
        new DefSingularityType("sulfur", 0xfff830, 0xfaf45a, EnumRarity.epic),
        new DefSingularityType("uranium", 0x4d751b, 0x75b524, EnumRarity.epic),
        new DefSingularityType("cyanite", 0x194273, 0x3c6ba3, EnumRarity.epic),
        new DefSingularityType("plutonium", 0x4c5663, 0x919191, EnumRarity.epic),
        new DefSingularityType("ludicrite", 0xad0546, 0xde1846, EnumRarity.epic),
        new DefSingularityType("rubber", 0x943100, 0x9c3705, EnumRarity.epic),
        new DefSingularityType("silicon", 0x634b47, 0xb3b3b3, EnumRarity.epic),
        new DefSingularityType("electrical_steel", 0x616b75, 0x979ea6, EnumRarity.epic),
        new DefSingularityType("energetic_alloy", 0xff7b00, 0xffc400, EnumRarity.epic),
        new DefSingularityType("vibrant_alloy", 0xa3cc00, 0xb8e019, EnumRarity.epic),
        new DefSingularityType("redstone_alloy", 0x8c1d1d, 0xbf1111, EnumRarity.epic),
        new DefSingularityType("conductive_iron", 0xb85151, 0xc98f8f, EnumRarity.epic),
        new DefSingularityType("pulsating_iron", 0x00b371, 0x32bf71, EnumRarity.epic),
        new DefSingularityType("dark_steel", 0x131314, 0x2b2b2b, EnumRarity.epic),
        new DefSingularityType("soularium", 0x421e0d, 0x54301f, EnumRarity.epic),
        new DefSingularityType("bedrockium", 0x080706, 0x303030, EnumRarity.epic),
        new DefSingularityType("unstable", 0x000000, 0xffffff, EnumRarity.epic),
        new DefSingularityType("manyullyn", 0x2b124a, 0x4f00b0, EnumRarity.epic),
        new DefSingularityType("pig_iron", 0xf774bc, 0xff99d1, EnumRarity.epic),
        new DefSingularityType("sakuradite", 0xbc028d, 0xfc0fc0, EnumRarity.epic),
        new DefSingularityType("forth", 0x3366cc, 0x00ffff, EnumRarity.epic),
    };

    public ItemSingularity() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setUnlocalizedName("avaritia_singularity");
        this.setTextureName("avaritia:singularity");
        this.setCreativeTab(Avaritia.tab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getColorFromItemStack(ItemStack itemstack, int renderpass) {
        int meta = getSafeMeta(itemstack.getItemDamage());
        if (renderpass == 0) return singularityTypes[meta].getColorBackground();
        else return singularityTypes[meta].getColorForeground();
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = getSafeMeta(stack.getItemDamage());
        return "item.singularity_" + singularityTypes[meta].getType();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < singularityTypes.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir) {
        foreground = ir.registerIcon("avaritia:singularity");
        background = ir.registerIcon("avaritia:singularity2");
    }

    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        if (pass == 0) {
            return background;
        }
        return foreground;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        int meta = getSafeMeta(stack.getItemDamage());
        return singularityTypes[meta].getRarity();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean wut) {

        int meta = item.getItemDamage();
        if (meta == 11) {
            // tooltip.add(EnumChatFormatting.DARK_GRAY +""+ EnumChatFormatting.ITALIC +
            // StatCollector.translateToLocal("tooltip.claybalance.desc"));
            tooltip.add(LudicrousText.makeFabulous("SELO DE QUALIDADE FINALCRAFT"));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean drawHalo(ItemStack stack) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getHaloTexture(ItemStack stack) {
        return ((ItemResource) LudicrousItems.resource).halo[0];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getHaloSize(ItemStack stack) {
        if(stack.getItemDamage() == 11)
            return 15;
        return 4;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean drawPulseEffect(ItemStack stack) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getHaloColour(ItemStack stack) {
        return 0xFF000000;
    }

    private int getSafeMeta(int originalMeta) {
        int meta = originalMeta;
        if (meta >= singularityTypes.length) meta = 0;
        return meta;
    }

    private interface ISingularityType{
        public int getColorForeground();
        public int getColorBackground();
        public String getType();
        public EnumRarity getRarity();
    }

    private class DefSingularityType implements ISingularityType{
        final String type;
        final int colorForeground;
        final int colorBackground;
        final EnumRarity rarity;

        DefSingularityType(String type, int colorBackground, int colorForeground, EnumRarity rarity) {
            this.type = type;
            this.colorForeground = colorForeground;
            this.colorBackground = colorBackground;
            this.rarity = rarity;
        }

        public int getColorForeground() {
            return colorForeground;
        }

        public int getColorBackground() {
            return colorBackground;
        }

        public String getType() {
            return type;
        }

        @Override
        public EnumRarity getRarity() {
            return rarity;
        }
    }

    private class SingularityTypeCosmic implements ISingularityType {
        final String type;
        final EnumRarity rarity;
        int contadorDeTick1 = 0;
        int contadorDeTick2 = 0;
        int indexColor1 = 0;
        int indexColor2 = 0;

        public SingularityTypeCosmic(String type, EnumRarity rarity) {
            this.type = type;
            this.rarity = rarity;
        }

        public int getColorForeground() {
            contadorDeTick1++;
            if (contadorDeTick1 == 15){
                contadorDeTick1 = 0;
                indexColor1++;
                if (indexColor1 == singularityTypes.length) indexColor1 = 0;
                if (singularityTypes[indexColor1] instanceof SingularityTypeCosmic) indexColor1++;
            }
            return singularityTypes[indexColor1].getColorForeground();
        }

        public int getColorBackground() {
            contadorDeTick2++;
            if (contadorDeTick2 == 25){
                contadorDeTick2 = 0;
                indexColor2++;
                if (indexColor2 == singularityTypes.length) indexColor2 = 0;
                if (singularityTypes[indexColor2] instanceof SingularityTypeCosmic) indexColor2++;
            }
            return singularityTypes[indexColor2].getColorBackground();
        }

        @Override
        public String getType() {
            return this.type;
        }

        @Override
        public EnumRarity getRarity() {
            return this.rarity;
        }
    }
}
