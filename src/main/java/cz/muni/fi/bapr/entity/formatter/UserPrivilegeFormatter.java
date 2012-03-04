package cz.muni.fi.bapr.entity.formatter;

import cz.muni.fi.bapr.entity.UserPrivilege;
import cz.muni.fi.bapr.service.UserPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class UserPrivilegeFormatter implements Formatter<UserPrivilege> {

    @Autowired
    private UserPrivilegeService userPrivilegeService;


    @Override
    public UserPrivilege parse(String text, Locale locale) throws ParseException {
        return userPrivilegeService.find(Long.valueOf(text));
    }

    @Override
    public String print(UserPrivilege object, Locale locale) {
        return String.valueOf(object.getId());
    }
}
