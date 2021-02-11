package ro.deiutzblaxo.ProprietyPlugin.EventHandler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import ro.deiutzblaxo.ProprietyPlugin.Land.LAND_FLAGS;
import ro.deiutzblaxo.ProprietyPlugin.Land.Land;
import ro.deiutzblaxo.ProprietyPlugin.Main.Main;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Convertor;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;

public class BuildEvent implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getPlayer().isOp())
            return;

        Land land = Main.landService.findLandByOwner(event.getPlayer());

        if (land != null) {

            if (!land.getFlags().contains(LAND_FLAGS.PLACE)) {
                event.setCancelled(false);
                event.getPlayer().sendMessage("The flag is disabled (PLACE)");
                return;
            }

            for (Vector3 vec : land.getSize().getAllNodes()) {
                if (Convertor.LocationToVector3(event.getBlock().getLocation()).distance(vec) < 1) {
                    event.getPlayer().sendMessage("Is  in prot");
                    event.setCancelled(false);
                    return;
                }
            }
        }
        event.setCancelled(true);
        event.getPlayer().sendMessage("Is in not in prot");
        return;


    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().isOp())
            return;

        Land land = Main.landService.findLandByOwner(event.getPlayer());

        if (land != null) {

            if (!land.getFlags().contains(LAND_FLAGS.BREAK)) {
                event.setCancelled(false);
                event.getPlayer().sendMessage("The flag is disabled (BREAK)");
                return;
            }

            for (Vector3 vec : land.getSize().getAllNodes()) {
                if (Convertor.LocationToVector3(event.getBlock().getLocation()).distance(vec) < 1) {
                    event.getPlayer().sendMessage("Is  in prot");
                    event.setCancelled(false);
                    return;
                }
            }
        }
        event.setCancelled(true);
        event.getPlayer().sendMessage("Is in not in prot");
        return;
    }


}
