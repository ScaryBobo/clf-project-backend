package VTTP.CLF_project_1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import VTTP.CLF_project_1.model.Contacts;
import VTTP.CLF_project_1.service.AddressService;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressSvc;

    @Test
    void insertNewContact(){
        Contacts contact = new Contacts();
        contact.setId("12345678");
        contact.setName("leslie");
        contact.setEmail("leslie@gmail.com");
        contact.setMobile(93847622);

        addressSvc.addContact(contact);
    }

    @Test
    void getAllContacts(){
        System.out.println(addressSvc.getContactList().toString());
    }
}
