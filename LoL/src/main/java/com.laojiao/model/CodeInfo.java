package com.laojiao.model;

public class CodeInfo {
    private Integer id;

    private String codeTable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeTable() {
        return codeTable;
    }

    public void setCodeTable(String codeTable) {
        this.codeTable = codeTable == null ? null : codeTable.trim();
    }
}