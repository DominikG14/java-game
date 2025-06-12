import os
import re

fish_names = [
    "Carp",
    "Cod",
    "Mackerel",
    "Pike",
    "Salmon",
    "Tuna"
]

fish_stats = {
    "Carp": {
        "MIN_REELSPEED": 2,
        "MAX_REELSPEED": 4,
        "MIN_ACCURACY": 3,
        "MAX_ACCURACY": 5,
        "MIN_RANGE": 12,
        "MAX_RANGE": 15,  # Prioritize Range
        "MIN_NUMBER": 1,
        "MAX_NUMBER": 2,
        "MIN_PROBABILITY": 40,
        "MAX_PROBABILITY": 80,
        "MIN_GOLD": 10,
        "MAX_GOLD": 15,
    },
    "Cod": {
        "MIN_REELSPEED": 12,
        "MAX_REELSPEED": 14,  # Prioritize Reel Speed
        "MIN_ACCURACY": 10,
        "MAX_ACCURACY": 13,   # Prioritize Accuracy
        "MIN_RANGE": 3,
        "MAX_RANGE": 5,
        "MIN_NUMBER": 1,
        "MAX_NUMBER": 2,
        "MIN_PROBABILITY": 50,
        "MAX_PROBABILITY": 75,
        "MIN_GOLD": 8,
        "MAX_GOLD": 12,
    },
    "Mackerel": {
        "MIN_REELSPEED": 14,
        "MAX_REELSPEED": 17,  # High Reel Speed
        "MIN_ACCURACY": 5,
        "MAX_ACCURACY": 7,
        "MIN_RANGE": 4,
        "MAX_RANGE": 6,
        "MIN_NUMBER": 1,
        "MAX_NUMBER": 3,
        "MIN_PROBABILITY": 35,
        "MAX_PROBABILITY": 70,
        "MIN_GOLD": 7,
        "MAX_GOLD": 11,
    },
    "Pike": {
        "MIN_REELSPEED": 6,
        "MAX_REELSPEED": 8,
        "MIN_ACCURACY": 14,
        "MAX_ACCURACY": 16,  # High Accuracy
        "MIN_RANGE": 11,
        "MAX_RANGE": 14,     # High Range
        "MIN_NUMBER": 1,
        "MAX_NUMBER": 1,
        "MIN_PROBABILITY": 25,
        "MAX_PROBABILITY": 55,
        "MIN_GOLD": 18,
        "MAX_GOLD": 24,
    },
    "Salmon": {
        "MIN_REELSPEED": 13,
        "MAX_REELSPEED": 16,  # High Reel Speed
        "MIN_ACCURACY": 7,
        "MAX_ACCURACY": 9,
        "MIN_RANGE": 13,
        "MAX_RANGE": 16,      # High Range
        "MIN_NUMBER": 1,
        "MAX_NUMBER": 2,
        "MIN_PROBABILITY": 35,
        "MAX_PROBABILITY": 65,
        "MIN_GOLD": 12,
        "MAX_GOLD": 16,
    },
    "Tuna": {
        "MIN_REELSPEED": 4,
        "MAX_REELSPEED": 6,
        "MIN_ACCURACY": 6,
        "MAX_ACCURACY": 9,
        "MIN_RANGE": 15,
        "MAX_RANGE": 18,      # Very High Range
        "MIN_NUMBER": 1,
        "MAX_NUMBER": 1,
        "MIN_PROBABILITY": 20,
        "MAX_PROBABILITY": 40,
        "MIN_GOLD": 20,
        "MAX_GOLD": 30,
    }
}

# Automatically fill in stats for other fish if not already present (optional defaults)
default_stats = fish_stats["Carp"]
for fish in fish_names:
    if fish not in fish_stats:
        fish_stats[fish] = default_stats.copy()

def to_readable_name(camel_case):
    return re.sub(r'(?<!^)(?=[A-Z])', ' ', camel_case)

template = """package fish;

import java.util.Random;

public class {class_name} extends Fish {{
    static int MIN_REELSPEED = {MIN_REELSPEED};
    static int MAX_REELSPEED = {MAX_REELSPEED};

    static int MIN_ACCURACY = {MIN_ACCURACY};
    static int MAX_ACCURACY = {MAX_ACCURACY};

    static int MIN_RANGE = {MIN_RANGE};
    static int MAX_RANGE = {MAX_RANGE}; 

    static int MIN_NUMBER = {MIN_NUMBER};
    static int MAX_NUMBER = {MAX_NUMBER};

    static int MIN_PROBABILITY = {MIN_PROBABILITY};
    static int MAX_PROBABILITY = {MAX_PROBABILITY};

    static int MIN_GOLD = {MIN_GOLD};
    static int MAX_GOLD = {MAX_GOLD};

    public {class_name}(){{
        FISH_NAME = "{readable_name}";

        Random rand = new Random();
        number = rand.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
        probability = rand.nextInt((MAX_PROBABILITY - MIN_PROBABILITY) + 1) + MIN_PROBABILITY;
        reelSpeed = rand.nextInt((MAX_REELSPEED - MIN_REELSPEED) + 1) + MIN_REELSPEED;
        accuracy = rand.nextInt((MAX_ACCURACY - MIN_ACCURACY) + 1) + MIN_ACCURACY;
        range = rand.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
        gold = rand.nextInt((MAX_GOLD - MIN_GOLD) + 1) + MIN_GOLD;
    }}
}}
"""

# Set target directory
output_dir = os.path.join(os.getcwd(), 'fish')
os.makedirs(output_dir, exist_ok=True)
os.chdir(output_dir)

# Generate files
for name in fish_names:
    filename = f"{name}.java"
    stats = fish_stats[name]
    with open(filename, "w") as f:
        f.write(template.format(
            class_name=name,
            readable_name=to_readable_name(name),

            MIN_REELSPEED=stats["MIN_REELSPEED"],
            MAX_REELSPEED=stats["MAX_REELSPEED"],

            MIN_ACCURACY=stats["MIN_ACCURACY"],
            MAX_ACCURACY=stats["MAX_ACCURACY"],

            MIN_RANGE=stats["MIN_RANGE"],
            MAX_RANGE=stats["MAX_RANGE"],

            MIN_NUMBER=stats["MIN_NUMBER"],
            MAX_NUMBER=stats["MAX_NUMBER"],

            MIN_PROBABILITY=stats["MIN_PROBABILITY"],
            MAX_PROBABILITY=stats["MAX_PROBABILITY"],

            MIN_GOLD=stats["MIN_GOLD"],
            MAX_GOLD=stats["MAX_GOLD"]
        ))
