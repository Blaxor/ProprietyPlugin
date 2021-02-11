package ro.deiutzblaxo.ProprietyPlugin.Player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import ro.deiutzblaxo.ProprietyPlugin.Land.Land;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Convertor;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector2;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;

import java.util.List;

public class LocalPlayerData implements LocalPlayer {

    protected Land land;
    protected List<Land> adminLands;
    protected final Player player;
    protected double money;

    /**
     *
     * @param player The {@link Player}
     */
    public LocalPlayerData(Player player){
    this. player = player;
    }
    /**
     *
     * @param player The {@link Player}
     * @param land  The {@link Land} that player own
     */
    public LocalPlayerData(Player player, Land land){

        this.player = player;
        this.land = land;
    }

    /**
     *
     * @param player The {@link Player}
     * @param land The {@link Land} that player own
     * @param adminLands The {@link Land}s in what player is admin
     */

    public LocalPlayerData(Player player , Land land , List<Land> adminLands){
        this.player = player;
        this.land = land;
        this.adminLands = adminLands;
    }


    /**
     * @return The {@link Land} where is owner
     */
    @Override
    public Land getLand() {
        return land;
    }

    /**
     * @return {@link Land}s where is administrator
     */
    @Override
    public List<Land> getAdministratorLand() {
        return adminLands;
    }

    /**
     * @param land the {@link Land} where is owner
     * @return succes
     */
    @Override
    public boolean setLand(Land land) {
        this.land = land;
        return true;
    }

    /**
     * @param adminLands the {@link Land}s where is administrator
     * @return succes
     */
    @Override
    public boolean setAdministratorLand(List<Land> adminLands) {

        this.adminLands = adminLands;
        return true;
    }

    /**
     * @return the {@link Player} instance
     */
    @Override
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the {@link Vector3} from the {@link Location}
     */
    @Override
    public Vector3 getLocation3D() {
        return Convertor.LocationToVector3(player.getLocation());
    }

    /**
     * @return the {@link Vector2} from the {@link Location}
     */
    @Override
    public Vector2 getLocation2D() {
        return Convertor.LocationToVector2(player.getLocation());
    }

    /**
     * @return Money of the player
     */
    @Override
    public double getMoney() {
        return money;
    }

    /**
     * @param money setting the money of the player
     * @return
     */
    @Override
    public boolean setMoney(double money) {
        this.money = money;
        return true;
    }
}
