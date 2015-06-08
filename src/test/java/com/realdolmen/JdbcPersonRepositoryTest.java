package com.realdolmen;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import static org.junit.Assert.assertEquals;


public class JdbcPersonRepositoryTest {

    @Before
    public void initializeDataSets() throws Exception    {
        //1. create DBUnit connection
        Connection jdbc = DriverManager.getConnection("jdbc:mysql://localhost:3306/testJBUnit", "root", "");
        IDatabaseConnection databaseConnection = new DatabaseConnection(jdbc);

        //2. Load dataset "people.xml' (create it first)
        IDataSet peopleDataSet = new FlatXmlDataSetBuilder().build(new File("people.xml"));

        //3. Execute CLEAR_INSERT operation using 1 and 2
        DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, peopleDataSet);
        //4. Prepare "fixture" for PersonRepository (al voornamelijk gedaan in de code zelf)
    }

    //Step 4 (voor de duidelijkheid in de methode zelf gezet)
    //private PersonRepository repository = new JdbcPersonRepository();


    @Test
    public void testPersonCanBeFoundById() throws Exception {
        PersonRepository repository = new JdbcPersonRepository();
        Person person = repository.find(1);
        assertEquals("Jimi", person.getFirstName());
        assertEquals("Hendrix", person.getLastName());
    }

    @Test
    @Ignore
    public void testWhatHappensWhenTheresNoPersonWithThisId() throws Exception {
        try {
            PersonRepository repository = new JdbcPersonRepository();
            Person person = repository.find(5);
            Assert.fail();
        } catch(RepositoryException e)  {
            assertEquals("Unable to execute statement", e.getMessage());
        }

    }
}