package com.nolo.nolo;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
public class Service implements Serializable {

    public Integer id;
    public String name;
    public String description;
    public String image;
}
