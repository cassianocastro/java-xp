/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseIntegration;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 *
 */
public class ContactFormatter
{

    public String formatDataFrom(Contact contact)
    {
        String dateFormatted = this.formatBirthDate(contact.getBirthDate());

        return String.format(
            "\n\nID: %d"
            + "\nName: %s"
            + "\nE-mail: %s"
            + "\nAddress: %s"
            + "\nBirth Date: %s",
            contact.getID(),
            contact.getName(),
            contact.getEmail(),
            contact.getAddress(),
            dateFormatted
        );
    }

    private String formatBirthDate(Calendar date)
    {
        return new SimpleDateFormat("dd/MM/yyyy").format(date.getTime());
    }
}
