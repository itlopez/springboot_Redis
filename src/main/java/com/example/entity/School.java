package com.example.entity;

import java.io.Serializable;

/**
 * Created by lopez on 2017/2/27.
 */
public class School implements Serializable {

    private String id;

    private String name;

    private String orgNo;

    private Integer status;

    private Integer type;

    private Integer schoolKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSchoolKey() {
        return schoolKey;
    }

    public void setSchoolKey(Integer schoolKey) {
        this.schoolKey = schoolKey;
    }

    @Override
    public String toString() {
        return "School{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", orgNo='" + orgNo + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", schoolKey=" + schoolKey +
                '}';
    }
}
