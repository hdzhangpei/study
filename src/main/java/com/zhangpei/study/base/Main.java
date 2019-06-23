package com.zhangpei.study.base;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final String SQL_TEMPLATE_DEFINE = "groupName{0};groupOrder{1};key{2};id:{3}";
    private static final String SQL_DEFINE = "order:{0};define:{1};template_defile_id{2}";
    private static final String SQL_DEFINE_VALUE = "defineId:{0},key:{1}, value:{2}";

    private static final Integer TEMPLATE_ID = 1;
    private static Integer id = 0;

    private static List<String> list_template_define = null;
    private static List<String> list_define = null;
    private static List<String> list_define_value = null;

    private static final String FILE_PATH = "C:\\Users\\hdzhangpei\\Desktop\\";
    private static final String FILE_INPUT_NAME = "dataSource.txt";
    private static final String FILE_OUTPUT_NAME = "sql{0}.txt";

    public static void main(String[] args) throws IOException {

        // 获取数据：key：group信息；value：group数据
        Map<String, List<String>> map = getDatasByTextFile();

        // 批量生成sql语句
        batchGenerateSql(map);

        // 导出数据
        exportData2File();

    }

    private static void exportData2File() throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd--HH:mm");
//        FileWriter fw = new FileWriter(FILE_PATH + MessageFormat.format(FILE_OUTPUT_NAME, sdf.format(new Date())));
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH + FILE_OUTPUT_NAME));
        try {

            if (!CollectionUtils.isEmpty(list_template_define)) {
                for (String s : list_template_define) {
                    writer.write(s);
                    writer.newLine();
                }
            }

            if (!CollectionUtils.isEmpty(list_define)) {
                for (String s : list_define) {
                    writer.write(s);
                    writer.newLine();
                }
            }

            if (!CollectionUtils.isEmpty(list_define_value)) {
                for (String s : list_define_value) {
                    writer.write(s);
                    writer.newLine();
                }
            }

            writer.flush();
        } finally {
            writer.close();
        }
    }

    private static void batchGenerateSql(Map<String, List<String>> map) {
        list_template_define = new ArrayList<>();
        list_define = new ArrayList<>();
        list_define_value = new ArrayList<>();

        for (String group : map.keySet()) {
            String[] groupInfo = group.split("\\|");
            String groupName = groupInfo[1];
            String groupOrder = groupInfo[2];

            for (String row : map.get(group)) {
                String[] strs = row.split("\\|");
                String order = strs[0];
                String key = strs[1];
                String define = strs[2];
                list_template_define.add(MessageFormat.format(SQL_TEMPLATE_DEFINE, groupName, groupOrder, key, id));
                list_define.add(MessageFormat.format(SQL_DEFINE, order, define, id));

                if (strs.length > 3) {
                    for (String strDefineValue : strs[3].split(";")) {
                        String[] defineValues = strDefineValue.split(":");
                        String showKey = defineValues[0];
                        String value = defineValues[1];
                        list_define_value.add(MessageFormat.format(SQL_DEFINE_VALUE, id, showKey, value));
                    }
                }

                id++;
            }


        }

    }

    private static Map<String, List<String>> getDatasByTextFile() throws IOException {
        Map<String, List<String>> resultMap = new HashMap<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(FILE_PATH + FILE_INPUT_NAME)));

            String str = null;
            String key = null;
            List<String> list = null;
            while ((str = reader.readLine()) != null) {
                if (StringUtils.isBlank(str)) {
                    continue;
                }

                if (str.trim().startsWith("group")) {
                    key = str;
                    list = new ArrayList<>();
                    continue;
                }

                if (StringUtils.isBlank(key) || StringUtils.isBlank(str)) {
                    continue;
                }

                list.add(str);
                resultMap.put(key, list);
            }
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        return resultMap;
    }
}
