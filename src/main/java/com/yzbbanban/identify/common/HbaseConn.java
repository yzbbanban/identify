package com.yzbbanban.identify.common;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * Created by brander on 2018/6/5
 */
public class HbaseConn {
    private static final HbaseConn INSTANCE = new HbaseConn();
    private static Configuration configuration;
    private static Connection connection;

    private HbaseConn() {

        try {
            if (configuration == null) {
                configuration = HBaseConfiguration.create();
                configuration.set("hbase.zookeeper.quorum", "localhost:2181");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            try {
                connection = ConnectionFactory.createConnection(configuration);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static Connection getHBaseConn() {
        return INSTANCE.getConnection();
    }

    public static Table geTable(String tableName) throws IOException {
        return INSTANCE.getConnection().getTable(TableName.valueOf(tableName));
    }


}
