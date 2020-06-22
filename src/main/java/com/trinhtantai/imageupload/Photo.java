package com.trinhtantai.imageupload;


import javax.persistence.*;

@Entity
@Table(name = "photo")
public class Photo {
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Infor getInfor() {
        return infor;
    }

    public void setInfor(Infor infor) {
        this.infor = infor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Infor infor;


}
