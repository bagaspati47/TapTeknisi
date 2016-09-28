package com.projekhalamanlangitblogspot.dokterpc2;


public class Stock {
    String name;
    String number;
    String photoId;
    String reputasi;

    public Stock(String name, String number, String photoId, String reputasi) {
        this.name = name;
        this.number = number;
        this.photoId = photoId;
        this.reputasi = reputasi;
    }

    public String getName() {
        return name;
    }

    //public void setName(String name) {
        //this.name = name;
    //}

    public String getNumber() {
        return number;
    }

    ///public void setNumber(String price) {
       // this.number = price;
   // }

    public String getPhotoId() {
        return photoId;
    }

    //public void setPhotoId(String photoId) {
     //   this.photoId = photoId;
   // }

    public String getReputasi() {
        return reputasi;
    }

    //public void setReputasi(String reputasi) {
        //this.reputasi = reputasi;
    //}
}
