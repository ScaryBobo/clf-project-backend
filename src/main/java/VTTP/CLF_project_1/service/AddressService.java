package VTTP.CLF_project_1.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTTP.CLF_project_1.model.Contacts;
import VTTP.CLF_project_1.repository.AddressBookRepository;

@Service
public class AddressService {

    @Autowired
    private AddressBookRepository addressBookRepo;

    public boolean addContact(Contacts contact){
        return addressBookRepo.insertNewContact(contact.getId(), contact.getName(), contact.getMobile(), contact.getEmail());
    }

    public Optional<String> checkDuplicateName (Contacts contact){
        return addressBookRepo.getContactByName(contact.getName());
    }
    
    public Optional<String> checkDuplicateEmail (Contacts contact){
        return addressBookRepo.getContactByEmail(contact.getEmail());
    }

    public Optional<Integer> checkDuplicateMobile (Contacts contact){
        return addressBookRepo.getContactByMobile(contact.getMobile());
    }

    public List<Contacts> getContactList (){
        return addressBookRepo.getContactList();
    }

}
