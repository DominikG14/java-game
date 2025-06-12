import os
import re

rod_names = [
    "LightningRod",
    "FlashCast",
    "EagleEye",
    "SureHook",
    "FarReach",
    "Horizon",
    "RapidAim",
    "TurboShot",
    "StormChaser",
    "FarFlyer",
    "LongSight",
    "Sniper"
]

rod_stats = {
    "LightningRod": {
        "MIN_DURABILITY": 12,
        "MAX_DURABILITY": 18,
        "MIN_REELSPEED": 20,
        "MAX_REELSPEED": 25,
        "MIN_ACCURACY": 5,
        "MAX_ACCURACY": 6,
        "MIN_RANGE": 4,
        "MAX_RANGE": 5,
        "MIN_GOLD": 10,
        "MAX_GOLD": 15,
    },
    "FlashCast": {
        "MIN_DURABILITY": 8,
        "MAX_DURABILITY": 12,
        "MIN_REELSPEED": 15,
        "MAX_REELSPEED": 18,
        "MIN_ACCURACY": 8,
        "MAX_ACCURACY": 10,
        "MIN_RANGE": 7,
        "MAX_RANGE": 8,
        "MIN_GOLD": 10,
        "MAX_GOLD": 12,
    },
    "EagleEye": {
        "MIN_DURABILITY": 10,
        "MAX_DURABILITY": 12,
        "MIN_REELSPEED": 4,
        "MAX_REELSPEED": 5,
        "MIN_ACCURACY": 20,
        "MAX_ACCURACY": 22,
        "MIN_RANGE": 8,
        "MAX_RANGE": 10,
        "MIN_GOLD": 8,
        "MAX_GOLD": 8,
    },
    "SureHook": {
        "MIN_DURABILITY": 7,
        "MAX_DURABILITY": 8,
        "MIN_REELSPEED": 6,
        "MAX_REELSPEED": 7,
        "MIN_ACCURACY": 17,
        "MAX_ACCURACY": 18,
        "MIN_RANGE": 10,
        "MAX_RANGE": 12,
        "MIN_GOLD": 15,
        "MAX_GOLD": 15,
    },
    "FarReach": {
        "MIN_DURABILITY": 12,
        "MAX_DURABILITY": 15,
        "MIN_REELSPEED": 7,
        "MAX_REELSPEED": 8,
        "MIN_ACCURACY": 7,
        "MAX_ACCURACY": 8,
        "MIN_RANGE": 25,
        "MAX_RANGE": 27,
        "MIN_GOLD": 10,
        "MAX_GOLD": 12,
    },
    "Horizon": {
        "MIN_DURABILITY": 8,
        "MAX_DURABILITY": 10,
        "MIN_REELSPEED": 10,
        "MAX_REELSPEED": 11,
        "MIN_ACCURACY": 10,
        "MAX_ACCURACY": 11,
        "MIN_RANGE": 20,
        "MAX_RANGE": 22,
        "MIN_GOLD": 7,
        "MAX_GOLD": 9,
    },
    "RapidAim": {
        "MIN_DURABILITY": 10,
        "MAX_DURABILITY": 12,
        "MIN_REELSPEED": 18,
        "MAX_REELSPEED": 20,
        "MIN_ACCURACY": 18,
        "MAX_ACCURACY": 20,
        "MIN_RANGE": 4,
        "MAX_RANGE": 5,
        "MIN_GOLD": 10,
        "MAX_GOLD": 11,
    },
    "TurboShot": {
        "MIN_DURABILITY": 7,
        "MAX_DURABILITY": 8,
        "MIN_REELSPEED": 15,
        "MAX_REELSPEED": 17,
        "MIN_ACCURACY": 15,
        "MAX_ACCURACY": 17,
        "MIN_RANGE": 10,
        "MAX_RANGE": 11,
        "MIN_GOLD": 14,
        "MAX_GOLD": 15,
    },
    "StormChaser": {
        "MIN_DURABILITY": 12,
        "MAX_DURABILITY": 14,
        "MIN_REELSPEED": 18,
        "MAX_REELSPEED": 20,
        "MIN_ACCURACY": 4,
        "MAX_ACCURACY": 5,
        "MIN_RANGE": 18,
        "MAX_RANGE": 20,
        "MIN_GOLD": 11,
        "MAX_GOLD": 13,
    },
    "FarFlyer": {
        "MIN_DURABILITY": 8,
        "MAX_DURABILITY": 9,
        "MIN_REELSPEED": 14,
        "MAX_REELSPEED": 15,
        "MIN_ACCURACY": 9,
        "MAX_ACCURACY": 10,
        "MIN_RANGE": 16,
        "MAX_RANGE": 17,
        "MIN_GOLD": 14,
        "MAX_GOLD": 16,
    },
    "LongSight": {
        "MIN_DURABILITY": 10,
        "MAX_DURABILITY": 12,
        "MIN_REELSPEED": 4,
        "MAX_REELSPEED": 5,
        "MIN_ACCURACY": 18,
        "MAX_ACCURACY": 20,
        "MIN_RANGE": 18,
        "MAX_RANGE": 20,
        "MIN_GOLD": 13,
        "MAX_GOLD": 14,
    },
    "Sniper": {
        "MIN_DURABILITY": 7,
        "MAX_DURABILITY": 8,
        "MIN_REELSPEED": 6,
        "MAX_REELSPEED": 7,
        "MIN_ACCURACY": 16,
        "MAX_ACCURACY": 18,
        "MIN_RANGE": 18,
        "MAX_RANGE": 20,
        "MIN_GOLD": 14,
        "MAX_GOLD": 15,
    },
}





def to_readable_name(camel_case):
    # Insert a space before each capital letter (except the first)
    return re.sub(r'(?<!^)(?=[A-Z])', ' ', camel_case)


template = """package fishingrods;

import java.util.Random;

public class {class_name} extends FishingRod {{
    static int MIN_DURABILITY = {MIN_DURABILITY};
    static int MAX_DURABILITY = {MAX_DURABILITY};

    static int MIN_REELSPEED = {MIN_REELSPEED};
    static int MAX_REELSPEED = {MAX_REELSPEED};

    static int MIN_ACCURACY = {MIN_ACCURACY};
    static int MAX_ACCURACY = {MAX_ACCURACY};

    static int MIN_RANGE = {MIN_RANGE};
    static int MAX_RANGE = {MAX_RANGE};

    static int MIN_GOLD = {MIN_GOLD};
    static int MAX_GOLD = {MAX_GOLD};

    public static void setDurabilityLimits(int min, int max){{
        MIN_DURABILITY = min;
        MAX_DURABILITY = max;
    }}

    public static void setReelSpeedLimits(int min, int max){{
        MIN_REELSPEED = min;
        MAX_REELSPEED = max;
    }}

    public static void setAccuracyLimits(int min, int max){{
        MIN_ACCURACY = min;
        MAX_ACCURACY = max;
    }}

    public static void setRangeLimits(int min, int max){{
        MIN_RANGE = min;
        MAX_RANGE = max;
    }}

    public static void setGoldLimits(int min, int max){{
        MIN_GOLD = min;
        MAX_GOLD = max;
    }}

    public {class_name}() {{
        FISHING_ROD_NAME = "{readable_name}";

        Random rand = new Random();
        durability = rand.nextInt((MAX_DURABILITY - MIN_DURABILITY) + 1) + MIN_DURABILITY;
        gold = rand.nextInt((MAX_GOLD - MIN_GOLD) + 1) + MIN_GOLD;
        reelSpeed = rand.nextInt((MAX_REELSPEED - MIN_REELSPEED) + 1) + MIN_REELSPEED;
        accuracy = rand.nextInt((MAX_ACCURACY - MIN_ACCURACY) + 1) + MIN_ACCURACY;
        range = rand.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;

        maxDurability = durability;
    }}
}}
"""


os.chdir(f'{os.getcwd()}/fishingrods')

for name in rod_names:
    filename = f"{name}.java"
    stats = rod_stats[name]
    with open(filename, "w") as f:
        f.write(template.format(
            class_name=name,
            readable_name=to_readable_name(name),

            MIN_DURABILITY=stats["MIN_DURABILITY"],
            MAX_DURABILITY=stats["MAX_DURABILITY"],

            MIN_REELSPEED=stats["MIN_REELSPEED"],
            MAX_REELSPEED=stats["MAX_REELSPEED"],

            MIN_ACCURACY=stats["MIN_ACCURACY"],
            MAX_ACCURACY=stats["MAX_ACCURACY"],

            MIN_RANGE=stats["MIN_RANGE"],
            MAX_RANGE=stats["MAX_RANGE"],

            MIN_GOLD=stats["MIN_GOLD"],
            MAX_GOLD=stats["MAX_GOLD"]

        ))

