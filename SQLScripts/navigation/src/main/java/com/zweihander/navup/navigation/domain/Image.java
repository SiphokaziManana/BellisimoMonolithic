package com.zweihander.navup.navigation.domain;

import javax.persistence.*;

/**
 * Created by siphokazi on 2017/09/17.
 */
@Entity
@Table( name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, nullable = false, length = 50, name = "uuid")
    private String uuid;

    @Column(nullable = false, length = 100, name = "name")
    private String name;

    @Column( name = "contentType")
    private String contentType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
