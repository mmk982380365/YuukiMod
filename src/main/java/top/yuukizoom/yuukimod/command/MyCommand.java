package top.yuukizoom.yuukimod.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import top.yuukizoom.yuukimod.YuukiMod;

/**
 * Created by realdata on 2017/8/30.
 */
public class MyCommand extends CommandBase {

    @Override
    public String getName() {
        return "yuuki";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "yuuki test command";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        System.out.println(args);

        try {
            EntityPlayerMP player = getPlayer(server,sender,args[0]);
            player.addItemStackToInventory(new ItemStack(YuukiMod.myItem,10));
        } catch (CommandException exc) {
            System.out.println(exc);
        }

    }
}
