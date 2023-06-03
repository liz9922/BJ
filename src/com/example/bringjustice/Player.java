package com.example.bringjustice;

import org.sqlite.SQLiteConfig;
import sqlite.SQLite;
public class Player {
    private String playerName;
    private String password;
    private String captured;
    private String killed;
    SQLite sqLite = new SQLite();

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptured() {
        return captured;
    }

    public void setCaptured(int captured) {
        this.captured = String.valueOf(captured);
    }

    public String getKilled() {
        return killed;
    }

    public void setKilled(int killed) {
        this.killed = String.valueOf(killed);
    }
    public void kill(Terrorist terrorist) {
        SQLite.updateStatus(terrorist, "kill");
    }
}
