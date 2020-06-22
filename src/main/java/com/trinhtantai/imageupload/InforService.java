package com.trinhtantai.imageupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InforService {

    @Autowired
    private InforRepository inforRepository;

    @Autowired
    private PhotoRepository photoRepository;

    public void createUser(Infor user) {
        inforRepository.save(user);
    }
    public List<Infor> getAllInfor(){

        return inforRepository.findAll();
    }

    public int getLatestIdImage(){
       List<Photo> photos =  photoRepository.findAll();

       return photos.get(photos.size()-1).getImageId();

    }
}
