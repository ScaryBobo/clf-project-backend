package VTTP.CLF_project_1.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import VTTP.CLF_project_1.mapper.AddressBookRowMapper;
import VTTP.CLF_project_1.model.Contacts;

@Repository
public class AddressBookRepository {
    @Autowired
    private JdbcTemplate template;

    public boolean insertNewContact(String id, String name, Integer mobile, String email){
        final int rowcount = template.update("insert into address_book (id, name, mobile, email) values(?,?,?,?)", id, name, mobile,email);
        return rowcount > 0;
    }

    public Optional <String> getContactByEmail (String email){
        final SqlRowSet result = template.queryForRowSet(
            "select email from address_book where email like ?", email);
        if (!result.next()) return Optional.empty();

        return Optional.of(result.getString("email"));
    }

    public Optional <String> getContactByName (String name){
        final SqlRowSet result = template.queryForRowSet(
            "select name from address_book where name like ?", name);
        if (!result.next()) return Optional.empty();

        return Optional.of(result.getString("name"));
    }

    public Optional <Integer> getContactByMobile (Integer mobile){
        final SqlRowSet result = template.queryForRowSet(
            "select mobile from address_book where mobile like ?", mobile);
        if (!result.next()) return Optional.empty();

        return Optional.of(result.getInt("mobile"));
    }

    public List<Contacts> getContactList (){
        return template.query("select * from address_book", new AddressBookRowMapper());
    } 

}
