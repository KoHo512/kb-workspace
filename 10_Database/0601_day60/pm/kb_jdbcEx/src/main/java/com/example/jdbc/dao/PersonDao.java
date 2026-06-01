package com.example.jdbc.dao;

import com.example.jdbc.common.DBUtil;
import com.example.jdbc.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * person 테이블 CRUD를 담당하는 DAO입니다.
 * 실습 핵심: Statement보다 PreparedStatement를 우선 사용합니다.
 */
public class PersonDao {
    private final DBUtil dbUtil;

    public PersonDao(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public int insert(Person person) throws SQLException {
        String sql = "INSERT INTO person(id, name) VALUES(?, ?)";
        try (Connection con = dbUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, person.getId());
            pstmt.setString(2, person.getName());
            return pstmt.executeUpdate();
        }
    }

    public Optional<Person> findById(int id) throws SQLException {
        String sql = "SELECT id, name FROM person WHERE id = ?";
        try (Connection con = dbUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapToPerson(rs));
                }
                return Optional.empty();
            }
        }
    }

    public List<Person> findAll() throws SQLException {
        String sql = "SELECT id, name FROM person ORDER BY id";
        List<Person> people = new ArrayList<>();
        try (Connection con = dbUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                people.add(mapToPerson(rs));
            }
            return people;
        }
    }

    private Person mapToPerson(ResultSet rs) throws SQLException {
        return new Person(rs.getInt("id"), rs.getString("name"));
    }
}
