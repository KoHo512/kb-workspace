package com.kb.product.dao;

import com.kb.product.util.DBUtil;
import com.kb.product.vo.Product;
import com.kb.product.vo.ProductDetail;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * TODO: 문제 5~8번 JDBC 기능을 구현하세요.
 * 상품 테이블에 접근하는 DAO 클래스
 */
public class ProductDao {
    public int insert(Product product) {
        // TODO 문제 5번 구현
        String sql = """
                INSERT INTO product (product_name, category_id, price, stock, manufacturer, created_at)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, product.getProductName());
            pstmt.setInt(2, product.getCategoryId());
            pstmt.setInt(3, product.getPrice());
            pstmt.setInt(4, product.getStock());
            pstmt.setString(5, product.getManufacturer());
            pstmt.setDate(6, Date.valueOf(product.getCreatedAt()));

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<Product> selectList(int count) {
        // TODO 문제 6번 구현
        List<Product> products = new ArrayList<>();

        String sql = """
                SELECT * FROM product
                ORDER BY price DESC LIMIT ?
                """;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setInt(1, count);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) products.add(mapProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    private Product mapProduct(ResultSet rs) throws SQLException {
        return Product.builder()
                .productId(rs.getInt("product_id"))
                .productName(rs.getString("product_name"))
                .categoryId(rs.getInt("category_id"))
                .price(rs.getInt("price"))
                .stock(rs.getInt("stock"))
                .manufacturer(rs.getString("manufacturer"))
                .createdAt(rs.getDate("created_at").toLocalDate())
                .build();
    }

    public Product selectOne(int productId) {
        // TODO 문제 7번 구현
        String sql = """
                SELECT * FROM product WHERE product_id = ?
                """;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setInt(1, productId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next())  return mapProduct(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ProductDetail getProductDetail(int productId) {
        // TODO 문제 8번 구현
        String sql = """
                SELECT p.product_id, p.product_name, c.category_id, c.category_name, p.price, p.stock, p.manufacturer, p.created_at
                FROM product p INNER JOIN category c ON p.category_id = c.category_id
                WHERE p.producT_id = ?
                """;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setInt(1, productId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next())  return mapProductDetail(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ProductDetail mapProductDetail(ResultSet rs) throws SQLException {
        return ProductDetail.builder()
                .productId(rs.getInt("product_id"))
                .productName(rs.getString("product_name"))
                .categoryId(rs.getInt("category_id"))
                .categoryName(rs.getString("category_name"))
                .price(rs.getInt("price"))
                .stock(rs.getInt("stock"))
                .manufacturer(rs.getString("manufacturer"))
                .createdAt(rs.getDate("created_at").toLocalDate())
                .build();
    }
}
