package com.yzbbanban.identify;

import com.yzbbanban.identify.common.HBaseUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;


/**
 * Created by brander on 2018/6/6
 */
public class HBaseUtilTest {

    @Test
    public void createTable() {
        HBaseUtil.createTable("FileBanTable", new String[]{"fileInfo", "saveInfo"});
    }

    @Test
    public void addFileDetails() {
        HBaseUtil.putRow("FileBanTable", "rowkey1", "fileInfo", "name", "file1.txt");
        HBaseUtil.putRow("FileBanTable", "rowkey1", "fileInfo", "type", "txt");
        HBaseUtil.putRow("FileBanTable", "rowkey1", "fileInfo", "size", "1024");
        HBaseUtil.putRow("FileBanTable", "rowkey1", "saveInfo", "creator", "jixin");
        HBaseUtil.putRow("FileBanTable", "rowkey2", "fileInfo", "name", "file2.jpg");
        HBaseUtil.putRow("FileBanTable", "rowkey2", "fileInfo", "type", "jpg");
        HBaseUtil.putRow("FileBanTable", "rowkey2", "fileInfo", "size", "1024");
        HBaseUtil.putRow("FileBanTable", "rowkey2", "saveInfo", "creator", "jixin");

    }

    @Test
    public void getFileDetails() {
        Result result = HBaseUtil.getRow("FileBanTable", "rowkey1");
        if (result != null) {
            System.out.println("rowkey=" + Bytes.toString(result.getRow()));
            System.out.println("fileName=" + Bytes
                    .toString(result.getValue(Bytes.toBytes("fileInfo"), Bytes.toBytes("name"))));
        }
    }

    @Test
    public void scanFileDetails() {
        ResultScanner scanner = HBaseUtil.getScanner("FileBanTable", "rowkey2", "rowkey2");
        if (scanner != null) {
            scanner.forEach(result -> {
                System.out.println("rowkey=" + Bytes.toString(result.getRow()));
                System.out.println("fileName=" + Bytes
                        .toString(result.getValue(Bytes.toBytes("fileInfo"), Bytes.toBytes("name"))));
            });
            scanner.close();
        }
    }

    @Test
    public void deleteRow() {
        HBaseUtil.deleteRow("FileBanTable", "rowkey1");
    }

    @Test
    public void deleteTable() {
        HBaseUtil.deleteTable("FileBanTable");
    }
}
