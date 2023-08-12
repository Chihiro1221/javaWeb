package com.study.dao.impl;

import com.study.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行数据库的insert/update/delete操作
     *
     * @return -1表示更新失败，否则表示影响的行数
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return -1;
    }

    /**
     * 返回单个数据
     * @param type 实体类型
     * @param sql sql语句
     * @param args sql参数
     * @return
     * @param <T>
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ...args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /**
     * 返回多条数据
     * @param type 实体类型
     * @param sql sql语句
     * @param args sql参数
     * @return
     * @param <T>
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }
}
