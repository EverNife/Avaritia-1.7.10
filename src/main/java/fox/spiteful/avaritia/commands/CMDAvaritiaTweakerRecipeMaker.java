package fox.spiteful.avaritia.commands;

import fox.spiteful.avaritia.gui.ContainerExtremeCrafting;
import fox.spiteful.avaritia.tile.inventory.InventoryDireCrafting;
import minetweaker.mc1710.item.MCItemStack;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

public class CMDAvaritiaTweakerRecipeMaker implements ICommand {

   private final List<String> aliases = new ArrayList<>();

   public CMDAvaritiaTweakerRecipeMaker() {
      this.aliases.add(this.getCommandName());
      this.aliases.add("atrm");
   }

   @Override
   public String getCommandName() {
      return "avaritiatweakerrecipemaker";
   }

   @Override
   public String getCommandUsage(ICommandSender icommandsender) {
      return this.getCommandName();
   }

   @Override
   public List getCommandAliases() {
      return this.aliases;
   }

   public void processCommand(ICommandSender sender, String[] args) {
      if (!sender.getEntityWorld().isRemote) return;
      new Thread(){
         @Override
         public void run() {
            try {
               Thread.sleep(3000);
               if (Minecraft.getMinecraft().thePlayer.openContainer != null
                       && Minecraft.getMinecraft().thePlayer.openContainer instanceof ContainerExtremeCrafting){
                  ContainerExtremeCrafting container = (ContainerExtremeCrafting) Minecraft.getMinecraft().thePlayer.openContainer;
                  InventoryDireCrafting inventoryDireCrafting = (InventoryDireCrafting) container.craftMatrix;
                  final String heldItemString;
                  ItemStack heldItem = Minecraft.getMinecraft().thePlayer.getHeldItem();
                  if (heldItem != null){
                     heldItemString = new MCItemStack(heldItem).toString();
                  }else {
                     heldItemString = "OUTPUT_ITEM";
                  }

                  StringBuilder stringBuilder = new StringBuilder("mods.avaritia.ExtremeCrafting.addShaped( " + heldItemString + ",");
                  stringBuilder.append("\n [");
                  for (int i = 0; i < 9 ; i++) {
                     stringBuilder.append("[");
                     for (int j = 0; j < 9 ; j++) {
                        ItemStack itemStack = inventoryDireCrafting.getStackInRowAndColumn(j,i);
                        if (itemStack != null){
                           MCItemStack mcItemStack = new MCItemStack(itemStack);
                           mcItemStack.toString();
                           stringBuilder.append(mcItemStack.toString() + ", ");
                        }else {
                           stringBuilder.append("null, ");
                        }
                     }
                     stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                     stringBuilder.append("],\n ");
                  }
                  stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
                  stringBuilder.append("]);");

                  StringSelection stringSelection = new StringSelection(stringBuilder.toString());
                  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                  clipboard.setContents(stringSelection, null);
                  sender.addChatMessage(new ChatComponentText("§7§o" + stringBuilder.toString()));
                  sender.addChatMessage(new ChatComponentText("§a§oThe code was copied to your clipboard!"));
                  Minecraft.getMinecraft().thePlayer.closeScreen();
                  return;
               }
               sender.addChatMessage(new ChatComponentText("§cNo ExtremeCraftingInventory found, doing nothing!"));
            }catch (Exception e){
               e.printStackTrace();
            }
         }
      }.start();
      sender.addChatMessage(new ChatComponentText("§aOpen an ExtremeCrafting Inventory in 3 seconds!"));
   }

   @Override
   public boolean canCommandSenderUseCommand(ICommandSender sender) {
      return true;
   }

   @Override
   public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring) {
      return null;
   }

   @Override
   public boolean isUsernameIndex(String[] astring, int i) {
      return false;
   }

   @Override
   public int compareTo(Object arg0) {
      return 0;
   }
}
