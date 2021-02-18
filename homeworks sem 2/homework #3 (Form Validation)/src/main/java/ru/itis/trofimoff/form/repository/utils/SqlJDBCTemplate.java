package ru.itis.trofimoff.form.repository.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlJDBCTemplate {

    protected DataBaseConnector dataSource;

    public SqlJDBCTemplate(DataBaseConnector dataSource){
        this.dataSource = dataSource;
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object ... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> result = null;
        try{
            connection = this.dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            int position = 1;
            for (Object arg : args) {
                preparedStatement.setObject(position, arg);
                position++;
            }
            if (sql.contains("UPDATE") || sql.contains("update") ||sql.toLowerCase().contains("delete")||sql.toLowerCase().contains("insert")) {
                preparedStatement.executeUpdate();
            } else{
                resultSet = preparedStatement.executeQuery();
                if (resultSet != null) {
                    result = new ArrayList<>();
                    while (resultSet.next()) {
                        result.add(rowMapper.mapRow(resultSet));
                    }
                }
            }
            return result;
        } catch (SQLException ex){
            throw new IllegalStateException(ex);
        } finally {
            if (resultSet!=null){
                try{
                    resultSet.close();
                } catch (SQLException ex){
                    //ignore
                }
            }
            if (preparedStatement!=null){
                try{
                    preparedStatement.close();
                } catch (SQLException ex){
                    //ignore
                }
            }
            if (connection!=null){
                try{
                    connection.close();
                } catch (SQLException ex){
                    //ignore
                }
            }
        }
    }
}