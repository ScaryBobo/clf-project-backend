package VTTP.CLF_project_1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import VTTP.CLF_project_1.model.Contacts;
import VTTP.CLF_project_1.model.ResponseObj;
import VTTP.CLF_project_1.service.AddressService;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressBookRESTController {

    @Autowired
    private AddressService contactSvc;

    Contacts newContact;
    ResponseObj resp;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Logger logger = Logger.getLogger(AddressBookRESTController.class.getName());

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postContacts (@RequestBody String payload){
        logger.info("payload: %s".formatted(payload));

        try {
            newContact = Contacts.create(payload);
            contactSvc.addContact(newContact);
        } catch (Exception e) {
            resp = new ResponseObj();
            resp.setResponseCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson(resp));
        }

        resp = new ResponseObj();
        resp.setResponseCode(201);
        resp.setMessage(newContact.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(gson.toJson(resp));
    }

    @GetMapping(path = "/getContacts")
    public ResponseEntity<List<Contacts>> getContactLists(){
        List <Contacts> contactList;
        contactList = contactSvc.getContactList();

        return ResponseEntity.accepted().body(contactList);
    }
    
}
