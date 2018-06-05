package com.yzbbanban.identify;

import com.yzbbanban.identify.common.HbaseConn;
import org.apache.hadoop.hbase.client.Connection;
import org.junit.Test;

/**
 * Created by brander on 2018/6/5
 */
public class TestHbaseConn {
    @Test
    public void getConnTest(){
        Connection connection= HbaseConn.getHBaseConn();
        System.out.println(connection.isClosed());
        HbaseConn.closeConn();
        System.out.println(connection.isClosed());
    }
}
