package lesson_14.cont;

import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
@Getter

public class ContactWithOther extends Contact {

    private Collection<Contact> linkedContact;

    public ContactWithOther() {
        this.linkedContact = new HashSet<>();
    }


}
