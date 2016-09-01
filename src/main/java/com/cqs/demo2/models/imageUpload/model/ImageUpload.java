package com.cqs.demo2.models.imageUpload.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

/**
 * Created by li on 2015/9/14.
 */
@Table
@Entity
@Component
public class ImageUpload {
    private String id;
    private String url;
    private String applyId;
    private String name;

    private List<String> attributes ;

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(length = 32, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(length = 32)
    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    @Column(length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn
    @ElementCollection(fetch = FetchType.EAGER)
    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("属性:[");
        if( null != attributes) {
            for (String attr : attributes){
                tmp.append(", " + attr);
            }
            tmp.append("]");
        }
        return tmp.toString();
    }
}
