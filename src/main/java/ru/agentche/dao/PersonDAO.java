package ru.agentche.dao;

import org.springframework.stereotype.Component;
import ru.agentche.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 27.12.2022
 */
@Component
public class PersonDAO {
    private static int PERSON_ID;
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return people;
    }

        public Person show(int id) {
//        return people.stream()
//                .filter(person -> person.getId() == id)
//                .findAny()
//                .orElse(null);
            return null;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() + "','" + person.getAge() + "','" + person.getEmail() + "')";
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person updatePerson) {
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatePerson.getName());
//        personToBeUpdated.setAge(updatePerson.getAge());
//        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
    }
}