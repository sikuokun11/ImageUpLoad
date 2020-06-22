package com.trinhtantai.imageupload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InforRepository extends JpaRepository<Infor,String> {
    Infor findInforByName(String name);
}
