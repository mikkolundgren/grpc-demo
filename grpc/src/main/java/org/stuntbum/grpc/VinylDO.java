package org.stuntbum.grpc;

public class VinylDO {

    private String album;
    private String artist;
    private String year;

    public VinylDO() {}

    public VinylDO(String album, String artist, String year) {
        this.album = album;
        this.artist = artist;
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
