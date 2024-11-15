package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Administrator;

/**
 * administratorsテーブルを操作するリポジトリクラス
 */
@Repository
public class AdministratorRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs,i) -> {
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mail_address"));
        administrator.setPassword(rs.getString("password"));
        return administrator;
    };

    /**
     * 管理者情報を追加する
     * 
     * @param administrator　管理者情報
     */
    public void insert(Administrator administrator) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);

        if(administrator.getId() == null) {
            String sql = "INSERT INTO administrators( name,mail_address,password) VALUES(:name,:mailAddress,:password)";
            template.update(sql, param);
        } else {
            System.out.println("データがありません");
        } 
    }

    /**
     * メールアドレスとパスワードから管理者情報を取得する
     * 
     * @param mailAddress 
     * @param password
     * @return　検索された管理者情報
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
        String sql = "SELECT * FROM administrators WHERE mail_address=:mailAddress AND password=:password";
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress)
        .addValue("password", password);
        
        try {
            Administrator administrator = template.queryForObject(sql, param, ADMINISTRATOR_ROW_MAPPER);
            return administrator;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
