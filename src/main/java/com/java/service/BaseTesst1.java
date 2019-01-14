package com.java.service;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * Author: Boris
 * Date: 2019/1/9 13:53
 * Copyright (C), 2017-2018, 浙江执御信息技术有限公司
 * Description:
 */
public class BaseTesst1 {

    /**
     * "A221H024_0_001":"",
     * "A221H024_0_004" ->
     */
    @Test
    public void test1() {
        //String userTag = "{\"C120H002_7_003\":\"3\",\"C120H002_7_001\":\"1\",\"C120H002_4_025\":\"1\",\"B220H066_0_001\":\"0\",\"B220H034_0_001\":\"0.6\",\"C120H043_7_001\":\"8\",\"B220H034_0_002\":\"1.02\",\"C120H002_3_017\":\"1\",\"C120H043_7_002\":\"34\",\"B220H081_0_015\":\"3.0\",\"B220H081_0_014\":\"159.0\",\"C120H002_3_025\":\"3\",\"B220H081_0_011\":\"97.0\",\"B220H081_0_010\":\"7.0\",\"B220H081_0_013\":\"9.0\",\"B220H081_0_012\":\"5.0\",\"C120H012_3_006\":\"4\",\"B220H038_0_001\":\"0\",\"C120H010_7_001\":\"2\",\"C120H010_7_002\":\"81\",\"C120H011_6_001\":\"10\",\"C120H011_6_002\":\"1\",\"C120H024_6_003\":\"1\",\"C120H024_6_004\":\"6\",\"C120H043_7_006\":\"1\",\"B220H039_0_001\":\"0\",\"C120H043_7_007\":\"5\",\"C120H043_7_004\":\"59\",\"C120H043_7_008\":\"4\",\"C120H043_6_001\":\"2\",\"C120H043_6_002\":\"7\",\"C120H020_5_019\":\"10\",\"C120H043_6_004\":\"18\",\"C120H002_7_025\":\"5\",\"C120H002_7_024\":\"1\",\"C120H010_8_002\":\"4\",\"C120H020_5_020\":\"1\",\"C120H008_8_001\":\"1\",\"C120H011_6_006\":\"2\",\"C120H002_7_032\":\"62\",\"C120H011_6_007\":\"1\",\"C120H011_6_004\":\"15\",\"C120H024_2_003\":\"1\",\"B220H102_0_001\":\"1\",\"C120H002_7_017\":\"48\",\"C120H051_2_004\":\"2\",\"C120H009_6_001\":\"1\",\"C120H002_7_015\":\"3\",\"C120H009_6_003\":\"3\",\"C120H051_2_002\":\"1\",\"C120H051_2_001\":\"1\",\"C120H012_8_008\":\"1\",\"B220H081_0_002\":\"308.0\",\"B220H081_0_001\":\"238.0\",\"C120H012_8_007\":\"1\",\"C120H012_8_006\":\"3\",\"B220H081_0_006\":\"49.0\",\"B220H081_0_005\":\"11.0\",\"B220H081_0_004\":\"19.0\",\"C120H012_8_002\":\"1\",\"B220H081_0_003\":\"1.0\",\"B220H009_0_001\":\"28.0\",\"C120H012_8_001\":\"1\",\"C120H002_7_020\":\"3\",\"B220H081_0_009\":\"7.0\",\"C120H012_7_008\":\"23\",\"B220H081_0_008\":\"218.0\",\"C120H012_7_007\":\"6\",\"C120H012_7_006\":\"62\",\"B220H081_0_007\":\"10.0\",\"C120H012_7_005\":\"3\",\"C120H012_7_004\":\"6\",\"C120H012_7_002\":\"12\",\"C120H017_8_004\":\"1\",\"C120H012_7_001\":\"7\",\"A121H031_0_001\":\"\",\"C120H040_7_001\":\"2\",\"E220H091_0_001\":\"ar\",\"C120H008_6_009\":\"1\",\"C120H017_8_012\":\"2\",\"C120H007_6_014\":\"14\",\"C120H008_6_001\":\"5\",\"E220H088_0_001\":\"\",\"B220H020_0_001\":\"1.0\",\"C120H010_5_006\":\"1\",\"C120H020_7_009\":\"6\",\"C120H020_7_005\":\"1\",\"B220H082_0_003\":\"2.0\",\"B220H082_0_002\":\"311.0\",\"B220H082_0_005\":\"12.0\",\"C120H020_7_012\":\"4\",\"B220H082_0_004\":\"20.0\",\"C120H020_7_011\":\"99\",\"C120H043_8_002\":\"3\",\"B220H082_0_001\":\"246.0\",\"B220H022_0_001\":\"7.0\",\"C120H022_5_010\":\"1\",\"B220H082_0_007\":\"11.0\",\"B220H082_0_006\":\"49.0\",\"B220H082_0_009\":\"7.0\",\"B220H082_0_008\":\"221.0\",\"C120H012_2_006\":\"1\",\"C120H012_2_001\":\"2\",\"C120H003_7_001\":\"2\",\"C120H043_8_004\":\"1\",\"C120H003_7_003\":\"1\",\"C120H004_7_013\":\"1\",\"C120H003_7_002\":\"1\",\"C120H004_7_014\":\"11\",\"C120H003_7_005\":\"18\",\"C120H024_7_002\":\"9\",\"C120H012_3_001\":\"2\",\"C120H003_7_007\":\"1\",\"C120H024_7_003\":\"1\",\"C120H024_7_004\":\"8\",\"C120H019_7_006\":\"2\",\"C120H020_7_002\":\"4\",\"B220H013_0_001\":\"234.0\",\"C120H020_7_004\":\"2\",\"C120H020_7_003\":\"65\",\"C120H019_7_003\":\"10\",\"C120H003_7_010\":\"82\",\"C120H033_7_006\":\"4\",\"A121H002_0_002\":\"\",\"C120H001_7_001\":\"1\",\"C120H051_7_004\":\"100\",\"C120H051_7_003\":\"3\",\"C120H051_7_006\":\"14\",\"C120H051_7_002\":\"33\",\"C120H051_7_001\":\"92\",\"C120H022_7_010\":\"10\",\"C120H046_7_002\":\"2\",\"C120H020_3_003\":\"1\",\"B220H015_0_001\":\"29.0\",\"C120H020_3_002\":\"1\",\"B220H080_0_014\":\"6.0\",\"D220H010_0_001\":\"353\",\"C120H051_6_006\":\"1\",\"C120H051_6_004\":\"16\",\"B220H080_0_010\":\"3.0\",\"C120H051_6_002\":\"11\",\"C120H051_6_001\":\"17\",\"C120H046_6_002\":\"1\",\"A220H053_0_001\":\"71.02\",\"C120H015_8_001\":\"1\",\"C120H020_3_019\":\"11\",\"C120H003_1_010\":\"2\",\"C120H015_8_009\":\"2\",\"C120H039_7_010\":\"1\",\"C120H015_8_007\":\"3\",\"C120H010_6_006\":\"1\",\"B220H079_0_008\":\"1\",\"B220H077_0_008\":\"0.39\",\"C120H010_6_002\":\"6\",\"B220H079_0_007\":\"1\",\"C120H010_6_001\":\"1\",\"C120H020_5_002\":\"2\",\"C120H008_3_001\":\"4\",\"C120H001_7_035\":\"5\",\"C120H001_7_037\":\"28\",\"B121H031_0_002\":\"\",\"B220H080_0_008\":\"43.0\",\"C120H017_5_011\":\"11\",\"C120H020_5_011\":\"8\",\"C120H017_5_012\":\"4\",\"B220H080_0_002\":\"19.0\",\"B220H080_0_001\":\"64.0\",\"B220H080_0_007\":\"1.0\",\"B220H080_0_006\":\"4.0\",\"C120H010_3_006\":\"1\",\"B220H077_0_003\":\"0.36\",\"B220H077_0_002\":\"0.26\",\"C120H043_5_001\":\"1\",\"B220H079_0_001\":\"2\",\"B220H077_0_001\":\"0.14\",\"B220H077_0_007\":\"0.0\",\"B220H079_0_002\":\"1\",\"C120H043_5_002\":\"5\",\"B220H079_0_005\":\"1\",\"B220H077_0_005\":\"0.85\",\"B220H079_0_004\":\"2\",\"C120H043_5_004\":\"7\",\"B220H077_0_004\":\"0.2\",\"B220H021_0_001\":\"3.0\",\"C120H026_8_002\":\"1\",\"C120H001_7_028\":\"1\",\"C120H001_7_033\":\"3\",\"C120H017_6_011\":\"16\",\"C120H017_6_012\":\"6\",\"C120H007_5_014\":\"5\",\"C120H026_6_002\":\"3\",\"C120H010_7_006\":\"11\",\"C120H044_7_002\":\"9\",\"C120H007_7_016\":\"1\",\"C120H017_7_013\":\"2\",\"C120H017_7_012\":\"68\",\"C120H017_7_011\":\"73\",\"C120H022_6_010\":\"8\",\"C120H019_6_003\":\"3\",\"C120H007_7_014\":\"66\",\"C120H007_7_011\":\"1\",\"C120H011_5_007\":\"1\",\"C120H011_5_006\":\"1\",\"C120H015_5_009\":\"2\",\"C120H015_5_007\":\"5\",\"C120H003_8_010\":\"3\",\"C120H015_5_003\":\"1\",\"C120H011_7_011\":\"4\",\"C120H001_8_037\":\"1\",\"C120H015_5_001\":\"1\",\"C120H017_7_002\":\"2\",\"C120H011_7_004\":\"22\",\"A220H029_0_001\":\"83\",\"C120H011_7_003\":\"3\",\"C120H017_7_001\":\"1\",\"C120H011_7_006\":\"48\",\"C120H017_7_004\":\"13\",\"C120H017_7_003\":\"2\",\"C120H011_7_007\":\"9\",\"C120H017_7_005\":\"3\",\"C120H012_5_008\":\"1\",\"C120H051_1_002\":\"1\",\"C120H051_1_001\":\"1\",\"C120H008_5_001\":\"2\",\"C120H051_1_004\":\"2\",\"C120H002_6_025\":\"2\",\"C120H012_5_004\":\"1\",\"C120H002_6_024\":\"2\",\"C120H012_5_006\":\"2\",\"C120H011_7_001\":\"76\",\"C120H008_5_009\":\"1\",\"C120H011_7_002\":\"7\",\"A111H001_0_002\":\"-4812.5\",\"C120H024_3_003\":\"1\",\"C120H008_4_001\":\"1\",\"C120H003_2_010\":\"1\",\"C120H011_5_001\":\"6\",\"C120H002_6_032\":\"20\",\"C120H011_5_004\":\"9\",\"B220H018_0_001\":\"23.886666666666667\",\"C120H020_2_019\":\"6\",\"C120H002_6_017\":\"6\",\"C120H002_6_015\":\"1\",\"C120H009_7_003\":\"7\",\"C120H009_7_001\":\"2\",\"C120H002_6_020\":\"1\",\"C120H009_7_013\":\"2\",\"C120H026_7_002\":\"6\",\"B220H068_0_001\":\"1.0\",\"B220H019_0_001\":\"80.0\",\"A120H090_0_001\":\"\",\"C120H011_8_011\":\"1\",\"C120H026_5_002\":\"2\",\"A121H030_0_002\":\"753\",\"C120H024_5_004\":\"3\",\"B220H026_0_001\":\"1\",\"C120H007_8_014\":\"2\",\"C120H011_8_001\":\"3\",\"C120H019_5_003\":\"1\",\"B220H078_0_005\":\"2\",\"C120H008_7_001\":\"14\",\"C120H023_7_010\":\"1\",\"C120H008_7_009\":\"2\",\"C120H008_7_006\":\"3\",\"C120H036_7_013\":\"4\",\"C120H023_7_003\":\"2\",\"B220H012_0_001\":\"176.0\",\"A111H085_0_001\":\"0.5346666666666667\",\"C120H010_5_002\":\"3\",\"B220H082_0_013\":\"21.0\",\"B220H082_0_014\":\"159.0\",\"B220H082_0_015\":\"4.0\",\"B220H082_0_010\":\"8.0\",\"B220H082_0_011\":\"100.0\",\"C120H003_6_005\":\"3\",\"C120H048_7_008\":\"40\",\"C120H020_7_020\":\"12\",\"B220H082_0_012\":\"6.0\",\"C120H002_8_020\":\"1\",\"C120H020_7_019\":\"119\",\"C120H002_5_032\":\"14\",\"C120H003_6_010\":\"4\",\"C120H020_7_018\":\"2\",\"A220H054_0_001\":\"354\",\"C120H048_5_008\":\"5\",\"C120H002_8_025\":\"1\",\"C120H002_8_032\":\"1\",\"C120H004_8_013\":\"1\",\"B220H017_0_001\":\"71.66\",\"C120H048_6_008\":\"6\",\"C120H020_8_003\":\"2\",\"B220H016_0_001\":\"3.0\",\"C120H051_3_001\":\"2\",\"C120H051_3_002\":\"2\",\"C120H003_5_010\":\"5\",\"C120H020_6_020\":\"2\",\"C120H002_8_003\":\"1\",\"C120H051_3_004\":\"3\",\"C120H051_5_002\":\"1\",\"C120H051_5_001\":\"11\",\"C120H051_5_004\":\"10\",\"C120H051_5_006\":\"1\",\"C120H020_6_019\":\"24\",\"C120H020_8_011\":\"2\",\"C120H003_5_005\":\"2\",\"C120H002_2_025\":\"2\",\"C120H001_5_037\":\"3\",\"C120H020_6_011\":\"23\",\"C120H020_8_019\":\"2\",\"C120H015_7_009\":\"60\",\"C120H015_7_007\":\"97\",\"C120H015_7_001\":\"23\",\"C120H015_7_002\":\"6\",\"C120H012_6_004\":\"2\",\"C120H012_6_005\":\"1\",\"C120H012_6_006\":\"9\",\"C120H012_6_007\":\"1\",\"C120H012_6_008\":\"3\",\"C120H015_7_003\":\"23\",\"E220H089_0_001\":\"1440x2560\",\"C120H020_6_002\":\"2\",\"C120H044_6_002\":\"4\",\"C120H051_8_006\":\"2\",\"B220H010_0_001\":\"1141.4799999999998\",\"C120H051_8_001\":\"11\",\"C120H025_7_004\":\"1\",\"C120H033_6_006\":\"1\",\"C120H025_7_003\":\"4\",\"C120H051_8_004\":\"18\",\"C120H051_8_002\":\"9\",\"A120H089_0_005\":\"\",\"C120H001_6_037\":\"4\",\"B220H014_0_001\":\"40.76714285714286\",\"C120H007_7_003\":\"1\",\"C120H012_6_001\":\"4\",\"C120H007_7_004\":\"2\",\"C120H003_3_010\":\"6\",\"C120H015_6_009\":\"8\",\"C120H015_6_007\":\"9\",\"B220H011_0_001\":\"1691.0\",\"C120H015_6_003\":\"8\",\"C120H015_6_001\":\"2\"}";
        String userTag = "{\"B220H066_0_001\":\"585\",\"B220H034_0_001\":\"0.0\",\"B220H034_0_002\":\"0.0\",\"A111H008_0_008\":\"\",\"B220H038_0_001\":\"592\",\"B220H039_0_001\":\"585\",\"A220H029_0_001\":\"769\",\"B220H018_0_001\":\"23.903\",\"B220H102_0_001\":\"49\",\"E220H093_0_001\":\"\",\"B220H009_0_001\":\"55.0\",\"A121H031_0_001\":\"\",\"E220H091_0_001\":\"ar\",\"B220H068_0_001\":\"0.99\",\"E220H088_0_001\":\"\",\"B220H019_0_001\":\"267.0\",\"A120H090_0_001\":\"\",\"A121H030_0_002\":\"679\",\"B220H026_0_001\":\"176\",\"B220H022_0_001\":\"5.0\",\"B220H078_0_008\":\"3\",\"B220H078_0_007\":\"1\",\"B220H078_0_005\":\"2\",\"B220H078_0_004\":\"1\",\"B220H078_0_001\":\"1\",\"B220H078_0_002\":\"1\",\"B220H013_0_001\":\"647.0\",\"A220H054_0_001\":\"93\",\"A121H002_0_002\":\"\",\"B220H015_0_001\":\"5.0\",\"D220H010_0_001\":\"25\",\"A220H090_0_001\":\"663\",\"B220H017_0_001\":\"478.05999999999995\",\"B220H016_0_001\":\"20.0\",\"A220H053_0_001\":\"28.39\",\"A121H013_0_005\":\"\",\"E220H092_0_001\":\"\",\"B220H079_0_008\":\"3\",\"B220H077_0_008\":\"0.07\",\"B220H079_0_007\":\"1\",\"B121H031_0_002\":\"\",\"B220H027_0_001\":\"67\",\"E220H089_0_001\":\"1080x1920\",\"B220H077_0_003\":\"0.08\",\"B220H077_0_002\":\"0.16\",\"B220H079_0_001\":\"1\",\"B220H077_0_001\":\"0.06\",\"B220H077_0_007\":\"0.26\",\"B220H079_0_002\":\"1\",\"B220H077_0_006\":\"0.05\",\"B220H079_0_005\":\"3\",\"B220H077_0_005\":\"0.85\",\"B220H010_0_001\":\"18935.63\",\"B220H079_0_004\":\"3\",\"B220H077_0_004\":\"0.53\",\"B220H021_0_001\":\"137.0\",\"A120H089_0_002\":\"\",\"B220H014_0_001\":\"344.28418181818176\",\"B220H011_0_001\":\"1898.0\"}";
        Map<String, String> userTagMap = JSON.parseObject(userTag, Map.class);
        System.out.println("标签个数：" + userTagMap.size());
        long start = System.currentTimeMillis();
        Map<String, Object> objectMap = new HashMap<>();
        for (Map.Entry<String, String> entry : userTagMap.entrySet()) {
            String tagId = entry.getKey();
            if (tagId.startsWith("E")) {
                continue;
            }
            Object value;
            char tagType = tagId.charAt(1);
            if ('1' == tagType) {
               value = true;
            }else {
                String tagValue = entry.getValue();
                if (tagValue.contains(".")) {
                    objectMap.put(tagId, Float.valueOf(tagValue));
                    value = Float.valueOf(tagValue);
                }else {
                    objectMap.put(tagId, Integer.valueOf(tagValue));
                    value = Integer.valueOf(tagValue);
                }
            }
            objectMap.put(tagId, value);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end-start));

    }

    @Test
    public void test2() {
        System.out.println( "2".equals("2"));
        System.out.println( 2 > 3);

        System.out.println(3 > '2');

        System.out.println((int)'2');


        Map<String, Object> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("keytrue", true);
        map.put("key4", Integer.valueOf("4"));
        map.put("key5.3", Float.valueOf("5.3"));
        System.out.println(map);

        Object obj = new HashSet<>();
        System.out.println("obj 类型：" +(obj instanceof Set) );


        List<String> list = new ArrayList<>();
        list.add("1232");
        System.out.println(list.subList(1, list.size()));
    }
}