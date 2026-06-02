package com.example.jdbc.dao;

import com.example.jdbc.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * PersonDao
 * ------------------------------------------------------------
 * person 테이블의 CRUD SQL을 담당합니다.
 */
public class PersonDao implements GenericDao<Person, Integer> {

    @Override
    public Integer insert(Connection con, Person person) throws Exception {
        String sql = "INSERT INTO person(name) VALUES(?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, person.getName());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

            throw new SQLException("person insert 후 생성된 id를 가져오지 못했습니다.");
        }
    }

    @Override
    public Optional<Person> findById(Connection con, Integer id) throws Exception {
        String sql = "SELECT id, name FROM person WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapToPerson(rs));
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Person> findAll(Connection con) throws Exception {
        String sql = "SELECT id, name FROM person ORDER BY id DESC";
        List<Person> people = new ArrayList<>();

        try (
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                people.add(mapToPerson(rs));
            }
        }

        return people;
    }

    @Override
    public int update(Connection con, Person person) throws Exception {
        String sql = "UPDATE person SET name = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, person.getName());
            pstmt.setInt(2, person.getId());

            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(Connection con, Integer id) throws Exception {
        String sql = "DELETE FROM person WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            return pstmt.executeUpdate();
        }
    }

    private Person mapToPerson(ResultSet rs) throws SQLException {
        return Person.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build();
    }
}
