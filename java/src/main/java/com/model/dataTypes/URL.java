package com.model.dataTypes;

public class URL {

    String protokoll;
    String subdomain;
    String domainName;

    public URL(String protokoll, String subdomain, String domainName){
        this.protokoll = protokoll;
        this.subdomain = subdomain;
        this.domainName = domainName;
    }

    public String getProtokoll() {
        return protokoll;
    }

    public void setProtokoll(String protokoll) {
        this.protokoll = protokoll;
    }

    public String getSubdomian() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public String getDomainname() {
        return domainName;
    }

    public void setDomainname(String domainName) {
        this.domainName = domainName;
    }

}
