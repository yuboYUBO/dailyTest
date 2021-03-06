//package com.java.hbase.test;
//
//import com.java.hbase.HBaseUtil;
//import org.apache.hadoop.hbase.HColumnDescriptor;
//import org.apache.hadoop.hbase.HTableDescriptor;
//import org.apache.hadoop.hbase.KeyValue;
//import org.apache.hadoop.hbase.TableName;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.util.Bytes;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Author: Boris
// * Date: 2018/8/31 13:55
// * Copyright (C), 2017-2018,
// * Description:
// */
//public class HbaseTest2 {
//    /**
//     * 配置ss
//     */
//    private static Connection connection = null;
//    private static Table table = null;
//
//    static {
//        try {
//            connection = HBaseUtil.getConnection();
//            table = connection.getTable(TableName.valueOf("dept_test"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public static void main(String[] args) throws Exception{
//        //insertData();
//
//        //insertOtherData();
//
//        //scanDataStep1();
//
//        scanDataStep2();
//
//
//    }
//
//        /**
//         * 创建数据库表dept，并增加列族info和subdept
//         *
//         * @throws Exception
//         */
//        private static void createTable() throws Exception {
//            // 创建表管理类
//            HBaseAdmin admin = new HBaseAdmin(HBaseUtil.getConfig()); // hbase表管理
//            // 创建表描述类
//            TableName tableName = TableName.valueOf("dept_test"); // 表名称
//            HTableDescriptor desc = new HTableDescriptor(tableName);
//            // 创建列族的描述类
//            HColumnDescriptor family = new HColumnDescriptor("info"); // 列族
//            // 将列族添加到表中
//            desc.addFamily(family);
//            HColumnDescriptor family2 = new HColumnDescriptor("subdept"); // 列族
//            // 将列族添加到表中
//            desc.addFamily(family2);
//            // 创建表
//            admin.createTable(desc); // 创建表
//            System.out.println("创建表成功！");
//            close();
//        }
//
//        /**
//         * 向hbase中插入前三行网络部、开发部、测试部的相关数据，
//         * 即加入表中的前三条数据
//         *
//         * @throws Exception
//         */
//        @SuppressWarnings({ "deprecation", "resource" })
//        public static void insertData() throws Exception {
//            table.setWriteBufferSize(534534534);
//            List<Put> arrayList = new ArrayList<Put>();
//
//            Put put = new Put(Bytes.toBytes("0_1"));
//            put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("网络部"));
//            put.add(Bytes.toBytes("subdept"), Bytes.toBytes("subdept1"), Bytes.toBytes("1_1"));
//            put.add(Bytes.toBytes("subdept"), Bytes.toBytes("subdept2"), Bytes.toBytes("1_2"));
//            arrayList.add(put);
//
//            Put put1 = new Put(Bytes.toBytes("1_1"));
//            put1.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("开发部"));
//            put1.add(Bytes.toBytes("info"), Bytes.toBytes("f_pid"), Bytes.toBytes("0_1"));
//
//            Put put2 = new Put(Bytes.toBytes("1_2"));
//            put2.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("测试部"));
//            put2.add(Bytes.toBytes("info"), Bytes.toBytes("f_pid"), Bytes.toBytes("0_1"));
//
//            for (int i = 1; i <= 100; i++) {
//
//                put1.add(Bytes.toBytes("subdept"), Bytes.toBytes("subdept"+i), Bytes.toBytes("2_"+i));
//                put2.add(Bytes.toBytes("subdept"), Bytes.toBytes("subdept"+i), Bytes.toBytes("3_"+i));
//            }
//            arrayList.add(put1);
//            arrayList.add(put2);
//            //插入数据
//            table.put(arrayList);
//            //提交
//            System.out.println("数据插入成功！");
//            close();
//        }
//
//        /**
//         * 向hbase中插入开发部、测试部下的所有子部门数据
//         * @throws Exception
//         */
//
//        public static void insertOtherData() throws Exception {
//            //table.setWriteBufferSize(534534534);
//            ArrayList<Put> arrayList = new ArrayList<Put>();
//            for (int i = 1; i <= 100; i++) {
//                Put put_development = new Put(Bytes.toBytes("2_"+i));
//                put_development.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("开发"+i+"组"));
//                put_development.add(Bytes.toBytes("info"), Bytes.toBytes("f_pid"), Bytes.toBytes("1_1"));
//                arrayList.add(put_development);
//
//                Put put_test = new Put(Bytes.toBytes("3_"+i));
//                put_test.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("测试"+i+"组"));
//                put_test.add(Bytes.toBytes("info"), Bytes.toBytes("f_pid"), Bytes.toBytes("1_2"));
//                arrayList.add(put_test);
//            }
//
//            //插入数据
//            table.put(arrayList);
//            //提交
//            System.out.println("插入其他数据成功！");
//            close();
//        }
//
//        /**
//         * 查询所有一级部门(没有上级部门的部门)
//         * @throws Exception
//         */
//        public static void scanDataStep1() throws Exception {
//
//            // 创建全表扫描的scan
//            Scan scan = new Scan();
//            System.out.println("查询到的所有一级部门如下：");
//            // 打印结果集
//            ResultScanner scanner = table.getScanner(scan);
//            for (Result result : scanner) {
//                if (result.getValue(Bytes.toBytes("info"), Bytes.toBytes("f_pid")) == null) {
//                    for (KeyValue kv : result.raw()) {
//                        System.out.print(new String(kv.getRow()) + " ");
//                        System.out.print(new String(kv.getFamily()) + ":");
//                        System.out.print(new String(kv.getQualifier()) + " = ");
//                        System.out.print(new String(kv.getValue()));
//                        System.out.print(" timestamp = " + kv.getTimestamp() + "\n");
//                    }
//                }
//            }
//            close();
//        }
//
//        /**
//         * 已知rowkey，查询该部门的所有(直接)子部门信息 rowkey=1_1
//         * @throws Exception
//         */
//        public static void scanDataStep2() throws Exception {
//            Get g = new Get("1_1".getBytes());
//            g.addFamily("subdept".getBytes());
//            // 打印结果集
//            Result result = table.get(g);
//            for (KeyValue kv : result.raw()) {
//                Get g1 = new Get(kv.getValue());
//                Result result1 = table.get(g1);
//                for (KeyValue kv1 : result1.raw()) {
//                    System.out.print(new String(kv1.getRow()) + " ");
//                    System.out.print(new String(kv1.getFamily()) + ":");
//                    System.out.print(new String(kv1.getQualifier()) + " = ");
//                    System.out.print(new String(kv1.getValue()));
//                    System.out.print(" timestamp = " + kv1.getTimestamp() + "\n");
//                }
//            }
//            close();
//        }
//
//        /**
//         * 已知rowkey，向该部门增加一个子部门
//         * rowkey:0_1
//         * 增加的部门名：我增加的部门
//         * @throws Exception
//         */
//        public static void scanDataStep3() throws Exception {
//            //新增一个部门
//            Put put = new Put(Bytes.toBytes("4_1"));
//            put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("我增加的部门"));
//            put.add(Bytes.toBytes("info"), Bytes.toBytes("f_pid"), Bytes.toBytes("0_1"));
//            //插入数据
//            table.put(put);
//            //提交
//            //table.flushCommits();
//
//            //更新网络部
//            Put put1 = new Put(Bytes.toBytes("0_1"));
//            put1.add(Bytes.toBytes("subdept"), Bytes.toBytes("subdept3"), Bytes.toBytes("4_1"));
//            //插入数据
//            table.put(put1);
//            //提交
//            //table.flushCommits();
//            close();
//        }
//
//        /**
//         * 已知rowkey（且该部门存在子部门），删除该部门信息，该部门所有(直接)子部门被调整到其他部门中
//         * @throws Exception
//         */
//
//        public static void scanDataStep4() throws Exception {
//            /**
//             * 向部门"我增加的部门"添加两个子部门"
//             */
//            //table.setAutoFlushTo(false);
//            //table.setWriteBufferSize(534534534);
//            ArrayList<Put> arrayList = new ArrayList<Put>();
//            Put put1 = new Put(Bytes.toBytes("5_1"));
//            put1.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("新增子部门1"));
//            put1.add(Bytes.toBytes("info"), Bytes.toBytes("f_pid"), Bytes.toBytes("4_1"));
//            Put put2 = new Put(Bytes.toBytes("5_2"));
//            put2.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("新增子部门2"));
//            put2.add(Bytes.toBytes("info"), Bytes.toBytes("f_pid"), Bytes.toBytes("4_1"));
//
//            arrayList.add(put1);
//            arrayList.add(put2);
//            //插入数据
//            table.put(arrayList);
//            //提交
//            //table.flushCommits();
//
//            /**
//             * 目的：删除"我增加的部门"的部门信息，该部门所有(直接)子部门被调整到其他部门中
//             * 使用策略：更新部门名就可以了，也就是说一个部门可能有多个rowkey
//             */
//            Put put = new Put(Bytes.toBytes("4_1"));
//            put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("开发部"));
//            //插入数据
//            table.put(put);
//            //提交
//           // table.flushCommits();
//            close();
//        }
//
//        public static void close() throws Exception {
//            table.close();
//            HBaseUtil.close();
//        }
//
//
//}
