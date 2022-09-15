package VTTP.CLF_project_1.model;

import com.google.gson.Gson;

import lombok.Data;

@Data
public class Contacts {
    private String id;
    private String name;
    private int mobile;
    private String email;

    public static Contacts create(String json){
        Gson gson = new Gson();
        Contacts contact = gson.fromJson(json, Contacts.class);

        return contact;
    }
}
