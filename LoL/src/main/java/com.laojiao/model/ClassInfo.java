package com.laojiao.model;

public class ClassInfo {
    private Integer id;

    private String classTable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassTable() {
        return classTable;
    }

    public void setClassTable(String classTable) {
        this.classTable = classTable == null ? null : classTable.trim();
    }
}