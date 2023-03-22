package com.upupup.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.upupup.domain.UserInfo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

    public static final String dir="D:/JAVA/CHAT_ROOM_RECORDS/";
    public static final String doc=".txt";
    public static final SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String LINE_SEPERATOR=System.getProperty("line.separator");
    private static Integer mark=1;

    public static File getFile(String userId,String ID) {
        Integer id=Integer.parseInt(userId);
        Integer buddyId=Integer.parseInt(ID);
        if(id>buddyId){
            int temp=id;
            id=buddyId;
            buddyId=temp;
        }
        return new File(dir+id+"_"+buddyId+doc);
    }

    public static void write1st(File file){
        FileWriter writer=null;
        String msg="------"+file.getName()+"------"+LINE_SEPERATOR;
        try {
            writer=new FileWriter(file);
            writer.write(msg);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void appendToFile(String userId, JSONObject message) {
        File file=getFile(userId,message.getString("name"));
        FileWriter fw=null;
        String msg=message.toJSONString()+LINE_SEPERATOR;
        try {
            fw=new FileWriter(file,true);
            fw.write(message.toJSONString()+LINE_SEPERATOR);
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readFile(String userId, String buddy, String num) {
        File file=getFile(userId,buddy);
        RandomAccessFile rf=null;
        JSONObject rec=new JSONObject();
        JSONArray array=new JSONArray();
        List<JSONObject> list=new ArrayList<>();
        try {
            rf=new RandomAccessFile(file,"r");
            long ptr=rf.length()-2;
            rf.seek(ptr);
            String sep="";
            int i=0,j=0;
            boolean flag=false;
            while(i<Integer.parseInt(num)){
                if(rf.read()=='\n'){
                    i++;
                }
                if(ptr==0){
                    rf.close();
                    return null;
                }
                ptr--;
                rf.seek(ptr);
            }
            while(j<5){
                if(rf.read()=='\n'){
                    array.add(JSONObject.parseObject(new String(rf.readLine().getBytes("ISO-8859-1"), "utf-8")));
                    //rec.put(String.valueOf(j),JSONObject.parseObject(new String(rf.readLine().getBytes("ISO-8859-1"), "utf-8")));
                    j++;
                }
                if(ptr==0){
                    break;
                }
                ptr--;
                rf.seek(ptr);
            }
            rf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rec.put("buddy",buddy);
        JSONObject object=new JSONObject();
        object.put("mark",mark);
        array.add(object);
        mark=(mark+1)%10000;
        return array.toJSONString();
        //return JSONObject.toJSONString(rec);
    }

    public void deleteFile(String filepath) {

    }

    public static List<String> toStandardUser(List<UserInfo> list){
        List<String> stringList=new ArrayList<>();
        for (UserInfo userInfo : list) {
            stringList.add(userInfo.standardString());
        }
        return stringList;
    }
}
