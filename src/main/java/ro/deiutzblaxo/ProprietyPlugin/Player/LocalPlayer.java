package ro.deiutzblaxo.ProprietyPlugin.Player;

import org.bukkit.entity.Player;
import ro.deiutzblaxo.ProprietyPlugin.Land.Land;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector2;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;

import java.util.List;

public interface LocalPlayer  {

    /**
     *
     * @return The {@link Land} where is owner
     */
    Land getLand();

    /**
     *
     * @return {@link Land}s where is administrator
     */
    List<Land> getAdministratorLand();

    /**
     *
     * @param land the {@link Land} where is owner
     * @return succes
     */
    boolean setLand(Land land);

    /**
     *
     * @param adminLands the {@link Land}s where is administrator
     * @return succes
     */
    boolean setAdministratorLand(List<Land> adminLands);

    /**
     *
     * @return the {@link Player} instance
     */
    Player getPlayer();

    /**
     *
     * @return the {@link Vector3} from the {@link org.bukkit.Location}
     */
    Vector3 getLocation3D();

    /**
     *
     * @return the {@link Vector2} from the {@link org.bukkit.Location}
     */
    Vector2 getLocation2D();

    /**
     *
     * @return Money of the player
     */
    double getMoney();

    /**
     *
     * @param money setting the money of the player
     * @return
     */
    boolean setMoney(double money);


}
