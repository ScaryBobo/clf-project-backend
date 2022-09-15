package VTTP.CLF_project_1.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import VTTP.CLF_project_1.model.Contacts;

public class AddressBookRowMapper implements RowMapper<Contacts> {
    

    public Contacts mapRow (ResultSet rs, int rowNum) throws SQLException{
        Contacts contact = new Contacts();
        contact.setId(rs.getString("id"));
        contact.setName(rs.getString("name"));
        contact.setEmail(rs.getString("email"));
        contact.setMobile(rs.getInt("mobile"));
        return contact;
    }

}
