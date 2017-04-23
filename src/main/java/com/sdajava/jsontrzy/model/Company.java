package com.sdajava.jsontrzy.model;

public class Company {

    private Object name;
    private Object catchPhrase;
    private Object bs;

    public Company(Object name, Object catchPhrase, Object bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "\n\tname = " + name +
                ", \n\tcatchPhrase = " + catchPhrase +
                ", \n\tbs = " + bs;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(Object catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public Object getBs() {
        return bs;
    }

    public void setBs(Object bs) {
        this.bs = bs;
    }
}
