package VTTP.CLF_project_1.model;

import lombok.Data;

@Data
public class ResponseObj{
    private String message;
    private int responseCode;
    private String data = "{}";
}