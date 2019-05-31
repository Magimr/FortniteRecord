package com.example.fortniterecord;

import java.util.List;

public class Profile {

    private String platformName;
    private String epicUserHandle;
    private Stats stats;
    private List<LifeTimeStats> lifeTimeStats;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getEpicUserHandle() {
        return epicUserHandle;
    }

    public void setEpicUserHandle(String epicUserHandle) {
        this.epicUserHandle = epicUserHandle;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<LifeTimeStats> getLifeTimeStats() {
        return lifeTimeStats;
    }

    public void setLifeTimeStats(List<LifeTimeStats> lifeTimeStats) {
        this.lifeTimeStats = lifeTimeStats;
    }
}
