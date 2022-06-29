package xyz.eyyuepguelen.islandnpc;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.commands.TraitCommands;
import net.citizensnpcs.trait.LookClose;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.eyyuepguelen.islandnpc.configurations.Data;
import xyz.eyyuepguelen.islandnpc.events.CreateIslandNPC;
import xyz.eyyuepguelen.islandnpc.hooks.ASkyBlock;
import xyz.eyyuepguelen.islandnpc.hooks.BentoBox;

import java.util.UUID;

public final class IslandNPC extends JavaPlugin {
    private static Data data;
    public static IslandNPC instance;
    @Override
    public void onEnable() {
        instance = this;
        data = new Data(this);
        data.save();
        if(getServer().getPluginManager().getPlugin("ASkyBlock") != null) {
            System.out.println("ASkyBlock Entegre edildi");
            getServer().getPluginManager().registerEvents(new ASkyBlock(), this);
        } else if(getServer().getPluginManager().getPlugin("BentoBox") != null) {
            System.out.println("BentoBox Entegre edildi");
            getServer().getPluginManager().registerEvents(new BentoBox(), this);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void createIslandNPC(UUID uuid, Location location) {
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, "IslandNPC");
        Location newLoc = location;
        newLoc.add(-0.5, 5, 2.5);
        npc.spawn(newLoc);
        LookClose lookClose = new LookClose();
        lookClose.setRange(32);
        lookClose.setRealisticLooking(true);
        lookClose.linkToNPC(npc);

        getData().set(uuid + ".npcId", npc.getId());
        getData().set(uuid + ".npcLocation", npc.getStoredLocation());
        getData().set(uuid + ".islandLocation", location);
        getData().save();
        Bukkit.getServer().getPluginManager().callEvent(new CreateIslandNPC(Bukkit.getPlayer(uuid), location));
    }
    public void deleteIslandNPC(UUID uuid) {
        int npcId = Integer.parseInt(getData().getString(uuid + ".npcId"));

        NPC npc = CitizensAPI.getNPCRegistry().getById(npcId);
        npc.destroy();
        getData().set(String.valueOf(uuid), null);
        getData().save();
    }

    public static Data getData() {
        return data;
    }

    public static IslandNPC getInstance() {
        return instance;
    }
}
