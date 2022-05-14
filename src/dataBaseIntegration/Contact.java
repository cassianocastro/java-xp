package dataBaseIntegration;

import java.util.Calendar;

/**
 *
 *
 */
public class Contact
{

    private final Long id;
    private final String name;
    private final String email;
    private final String address;
    private final Calendar birthDate;

    public Contact(Long id, String name, String email, String address, Calendar birthDate)
    {
        this.id        = id;
        this.name      = name;
        this.email     = email;
        this.address   = address;
        this.birthDate = birthDate;
    }

    public Long getID()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getAddress()
    {
        return this.address;
    }

    public Calendar getBirthDate()
    {
        return this.birthDate;
    }
}
