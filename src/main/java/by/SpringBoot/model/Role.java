package by.SpringBoot.model;


public enum Role {
    ADMIN, USER;


    public String getAuthority() {
        return name();
    }
}
