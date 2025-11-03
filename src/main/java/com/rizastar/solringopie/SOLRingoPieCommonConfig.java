package com.rizastar.solringopie;

public final class SOLRingoPieCommonConfig {

    public static Double[] thresholds = {2.0, 5.0, 7.0, 10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 40.0, 45.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0};

    public static String[] benefitsUnparsed = {
            "effect,speed,0",
            "attribute,generic.max_health,1",
            "attribute,generic.max_health,1;effect,haste,0",
            "attribute,generic.max_health,1;effect,strength,0",
            "attribute,generic.max_health,1;attribute,generic.armor_toughness,2",
            "attribute,generic.max_health,1;effect,regeneration,0",
            "attribute,generic.max_health,1;effect,speed,1",
            "attribute,generic.max_health,1;effect,strength,0",
            "attribute,generic.max_health,1;effect,luck,0",
            "attribute,generic.max_health,1;attribute,generic.knockback_resistance,1",
            "attribute,generic.max_health,1;effect,speed,2",
            "attribute,generic.max_health,1;attribute,generic.armor_toughness,2",
            "attribute,generic.max_health,1;effect,haste,1",
            "attribute,generic.max_health,1;effect,strength,1",
            "attribute,generic.max_health,1;attribute,generic.armor_toughness,2",
            "attribute,generic.max_health,1;effect,strength,2",
            "attribute,generic.max_health,1;effect,luck,1"
    };

    public static void setThresholds(Double[] thresholds) {
        SOLRingoPieCommonConfig.thresholds = thresholds;
    }

    public static void setBenefitsUnparsed(String[] benefitsUnparsed) {
        SOLRingoPieCommonConfig.benefitsUnparsed = benefitsUnparsed;
    }

    public static String[] getBenefitsUnparsed() {
        return benefitsUnparsed;
    }

    public static Double[] getThresholds() {
        return thresholds;
    }
}
