package com.example.dto;

/**
 * Created by lopez on 2017/2/27.
 */
public class SchoolDto {

    private Integer schoolKey;

    private Integer fromIndex = 0;

    private  Integer toIndex = 10000;

    private  String id;

    private  String name;

    public Integer getSchoolKey() {
        return schoolKey;
    }

    public void setSchoolKey(Integer schoolKey) {
        this.schoolKey = schoolKey;
    }

    public Integer getFromIndex() {
        return fromIndex;
    }

    public void setFromIndex(Integer fromIndex) {
        this.fromIndex = fromIndex;
    }

    public Integer getToIndex() {
        return toIndex;
    }

    public void setToIndex(Integer toIndex) {
        this.toIndex = toIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
