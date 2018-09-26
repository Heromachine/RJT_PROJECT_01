package com.example.jessi.rjt_project_01.data.models;

public class ModelLogIn {

    private String msg;
    private String id;
    private String fName;
    private String lname;
    private String email;
    private String mobile;
    private String appapikey;

    public ModelLogIn() {
    }

    public ModelLogIn(String msg, String id, String fName, String lname, String email, String mobile, String appapikey) {
        this.msg = msg;
        this.id = id;
        this.fName = fName;
        this.lname = lname;
        this.email = email;
        this.mobile = mobile;
        this.appapikey = appapikey;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAppapikey() {
        return appapikey;
    }

    public void setAppapikey(String appapikey) {
        this.appapikey = appapikey;
    }
}
