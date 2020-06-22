package com.trinhtantai.imageupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InforController {

    @Autowired
    InforService inforService;


    @RequestMapping("/")
    public  String  register(){
        return "infor";
    }
    @RequestMapping("/list")
    public  String  Listing(Model model){
        model.addAttribute("userlist",inforService.getAllInfor());
        for(Infor infor :inforService.getAllInfor()){
            System.out.println(infor.getName());

        }
        return "listing";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name, @RequestParam("photo") MultipartFile photo , @RequestParam("filecv") MultipartFile filecv, ModelMap model) {



        Infor infor = new Infor();


        if(photo.isEmpty() ||  filecv.isEmpty()){
            return "infor";
        }

        infor.setPhoto(photo.getOriginalFilename().toLowerCase());
        infor.setName(name);

        Photo image = new Photo();
        int series = inforService.getLatestIdImage() +1;
        image.setImageName(photo.getOriginalFilename().toLowerCase());
        image.setImagePath(series+"_"+photo.getOriginalFilename().toLowerCase());
        image.setInfor(infor);
        List<Photo> listphotos = new ArrayList<>();
        listphotos.add(image);
        infor.setPhotos(listphotos);
        inforService.createUser(infor);
        Path path = Paths.get("uploads/");
        try{
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream,path.resolve(series+"_"+photo.getOriginalFilename().toLowerCase()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(photo.getOriginalFilename().toUpperCase());
            infor.setPhoto(photo.getOriginalFilename().toLowerCase());
            //
            inputStream = filecv.getInputStream();
            Files.copy(inputStream,path.resolve(filecv.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            model.addAttribute("INFOR",infor);
            model.addAttribute("FILE_NAME",filecv.getOriginalFilename());
            model.addAttribute("FILE_TYPE",filecv.getContentType());
            model.addAttribute("FILE_SIZE",filecv.getSize());


        }catch (Exception e){
            e.printStackTrace();
        }

        return "view-infor";

    }
}
