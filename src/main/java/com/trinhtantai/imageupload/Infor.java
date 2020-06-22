package com.trinhtantai.imageupload;


import javax.persistence.*;
import java.lang.reflect.GenericArrayType;
import java.util.List;

@Entity
@Table(name = "user")
public class Infor {

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(name = "user_name")
    private String name;



    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "infor",cascade = CascadeType.ALL)
    private List<Photo> photos;

    private  String photo;

    public Infor(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



}
