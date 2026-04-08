
# HBM Doors

HBM Doors is a stripped-down fork of [HBM's Nuclear Tech Modernized](https://github.com/Raptor324/HBM-Modernized) that focuses exclusively on the mod's door system.

This mod will stay on github and I will not post it elsewhere, as the license dictates you are welcome to post it anywhere else as long as you provide credit to me.

---

## What is this?

The goal was simple: extract just the doors from HBM Modernized and ship them as a standalone mod. Getting there was not so simple. After many failed attempts at cleanly separating the door logic from the rest of the codebase, the approach taken was to include the full HBM Modernized source but disable the non-door systems — structure generation, ore generation, recipes, and the core mod features are all blocked.

The mod still technically contains HBM Modernized's other blocks, items, and entities, but they serve no real purpose here. They cannot be obtained in survival through normal means, and even if obtained via commands or a mod like JEI, their underlying logic likely does not function correctly.

---

## Changes from HBM Modernized

**Explosion immunity** — Doors are now fully immune to explosions. A reinforced vault door caving to a single creeper never made much sense, so all doors now survive any explosion regardless of its source.

**Screwdriver not yet implemented** — The original mod includes a screwdriver item that lets you change door skins. The alternate skins are fairly limited, but the screwdriver will be added in a future update.

**Crafting not possible** — Since all recipes were removed, you are unable to craft the doors in this mod. (if it was even possible in HBM Modernized)

---

---

## Doors

You can find images of the doors here [HBM Wiki](https://ntm-alcateredition.fandom.com/wiki/Doors)
Although they may not contain the right textures as what you will see in game due to the absence of the screwdriver and the ability to change the texture

---

## Installation

**Requirements:**
- Minecraft 1.20.1
- Forge 1.20.1
- [Cloth Config API 11.1.136+](https://www.curseforge.com/minecraft/mc-mods/cloth-config/files?version=1.20)

**Steps:**
1. Download the latest release from [Releases](../../releases)
2. Install Cloth Config API for Minecraft 1.20.1
3. Place both `.jar` files in your `mods` folder
4. Launch Minecraft with Forge 1.20.1

---

## Known Issues

This mod inherits the instability of a pre-alpha codebase. Bugs, crashes, and mod incompatibilities are all possible. Use it at your own discretion and avoid using it in worlds you care about.

---

## Contributing

All issues and pull requests are welcome. If you find a bug, report it — there is a real chance it gets fixed.

---

## Credits

**The Bobcat** — author of the original HBM's Nuclear Tech Mod

**Raptor324** — author of HBM's Nuclear Tech Modernized, the project this mod is based on