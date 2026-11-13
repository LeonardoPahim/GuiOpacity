# GuiOpacity

A client-side mod for Minecraft 1.7.10 (GT New Horizons) that reduces the dark overlay drawn behind inventories and other GUIs.

> **Status: WIP.** It doesn't remove the overlay on most machines yet.

## Install

1. Download the jar from the Releases page.
2. Put it in your instance's `mods` folder.
3. Start the game once to generate `config/guiopacity.cfg`.

## Config

Edit `backgroundOpacity` in `config/guiopacity.cfg`, then restart the game.

- `1.0`: vanilla overlay
- `0.5`: half as dark (default)
- `0.0`: no overlay

## Manual Build

```
./gradlew build
```

The jar is written to `build/libs/`. Use the one without a `-dev` or `-sources` suffix.

## License

MIT
