package com.hjx.system.JsonToExcel;

import cn.hutool.json.JSONException;
import org.apache.poi.hssf.usermodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class JsonToExcel {
    public static void buildEXCELDATA(OutputStream output, String json, String[] properties) throws JSONException {
        buildEXCELDATA(output, json, properties, properties);
    }

    public static void buildEXCELDATA(OutputStream output, String json, String[] properties, String[] columnsNames) throws JSONException {
        HSSFWorkbook libro = new HSSFWorkbook();


        HSSFSheet ssf = libro.createSheet();
        HSSFRow header = ssf.createRow(0);
        JSONArray array = new JSONArray(json);


        int e;
        for (e = 0; e < columnsNames.length; ++e) {
            String object = columnsNames[e];
            HSSFCell row = header.createCell(e);
            HSSFRichTextString j = new HSSFRichTextString(object);
            row.setCellValue(j);
        }

        for (e = 0; e < array.length(); ++e) {
            JSONObject var16 = array.getJSONObject(e);
            HSSFRow var17 = ssf.createRow(e + 1);

            for (int var18 = 0; var18 < properties.length; ++var18) {
                String string = properties[var18];
                HSSFCell cell = var17.createCell(var18);
                try {

                    HSSFRichTextString text = new HSSFRichTextString(var16.get(string).toString());
                    System.out.println("====" + text);
                    cell.setCellValue(text);
                } catch (Exception var15) {
                    var15.printStackTrace();
                }

            }
        }
        try {
            libro.write(output);
        } catch (Exception var15) {
            var15.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            //文件位置
            FileInputStream fis = new FileInputStream("xx\\file-utf8.json");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            BufferedReader bufferedReader = new BufferedReader(isr);

            String line = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            //要存储的文件位置
            FileOutputStream xlsStream = new FileOutputStream("xx\\7777.xls");

            /**
             * 需要存储的字段
             * json格式
             *  {
             *        "id": "438",
             *        "name": "小明",
             *        "createTime": 1594112146000
             *   }
             */
            JsonToExcel.buildEXCELDATA(xlsStream, stringBuffer.toString(), new String[]{"id", "createTime", "name"});
            xlsStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
