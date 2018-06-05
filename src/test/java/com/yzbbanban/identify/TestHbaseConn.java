package com.yzbbanban.identify;

import com.yzbbanban.identify.common.HbaseConn;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Table;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by brander on 2018/6/5
 */
public class TestHbaseConn {
    @Test
    public void getConnTest() {
        Connection connection = HbaseConn.getHBaseConn();
        System.out.println(connection.isClosed());
        HbaseConn.closeConn();
        System.out.println(connection.isClosed());
    }


    @Test
    public void getTableTest() {
        try {
            Table table = HbaseConn.geTable("US_POTULATION");
            System.out.println(table.getName().getNameAsString());
            table.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
