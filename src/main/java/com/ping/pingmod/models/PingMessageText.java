package com.ping.pingmod.models;

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;

public class PingMessageText {
    TextComponentString pingTextComponent;

    private Style getPingTextStyle() {
        Style style = new Style();

        //Ninguem merece
        //style.setColor(TextFormatting.DARK_BLUE);

        return style;
    }

    public PingMessageText(String pingText) {
        this.pingTextComponent = new TextComponentString("");

        this.pingTextComponent.setStyle(getPingTextStyle());
        this.pingTextComponent.appendText(pingText);
    }

    public TextComponentString getPingTextComponent() { return this.pingTextComponent; }
}
