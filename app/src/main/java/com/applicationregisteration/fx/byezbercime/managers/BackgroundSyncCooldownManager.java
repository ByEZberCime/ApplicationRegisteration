package com.applicationregisteration.fx.byezbercime.managers;

import java.util.HashMap;

public class BackgroundSyncCooldownManager {

    private HashMap<String,Long> backgroundSyncCooldowns;

    public BackgroundSyncCooldownManager() {
        this.backgroundSyncCooldowns = new HashMap<>();

    }

    public HashMap<String, Long> getBackgroundSyncCooldowns() {
        return backgroundSyncCooldowns;
    }

}
