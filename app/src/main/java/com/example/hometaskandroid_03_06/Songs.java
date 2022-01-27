package com.example.hometaskandroid_03_06;

public class Songs {
    private int idCount=0;
    private final String nameOfSinger;
    private final String nameOfSong;
    private final String lengthOfSong;

    public Songs(int ii, String nameOfSong, String nameOfSinger, String lengthOfSong) {
        idCount=ii;
        this.nameOfSong = nameOfSong;
        this.nameOfSinger = nameOfSinger;
        this.lengthOfSong = lengthOfSong;
    }

    public String getIdCount() {
        return String.valueOf(idCount);
    }

    public String getLengthOfSong() {
        return lengthOfSong;
    }

    public String getNameOfSinger() {
        return nameOfSinger;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }
}
