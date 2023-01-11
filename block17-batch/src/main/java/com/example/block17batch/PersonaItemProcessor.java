package com.example.block17batch;

import org.springframework.batch.item.ItemProcessor;

public class PersonaItemProcessor implements ItemProcessor<Persona, Persona> {

    //Here we're taking the personas from the reader and then we change the original string into an uppercase version
    //That just shows us how data can be manipulated between the reading and the writing
    @Override
    public Persona process(Persona persona) throws Exception {
        final String firstName = persona.getFirstName().toUpperCase();
        final String lastName = persona.getLastName().toUpperCase();

        final Persona upperPerson = new Persona(firstName, lastName);
        return upperPerson;
    }
}
