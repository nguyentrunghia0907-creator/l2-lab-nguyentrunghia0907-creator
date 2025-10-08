package com.poly.lab5.service;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    public String getString(String name, String defaultValue) {
        String v = request.getParameter(name);
        if(v == null || v.isEmpty()){
            return defaultValue;
        }else{
            return v.trim();
        }
    }

    public int getInt (String name, int defaultValue) {
        String v = request.getParameter(name);
        if(v == null || v.isEmpty()){
            return defaultValue;
        }
        try {
            return Integer.parseInt(v.trim());
        }catch(NumberFormatException e){
            return defaultValue;
        }
    }

    public double getDouble (String name, double defaultValue) {
        String v = request.getParameter(name);
        if(v == null || v.isEmpty()){
            return defaultValue;
        }
        try {
            return Double.parseDouble(v.trim());
        }catch(NumberFormatException e){
            return defaultValue;
        }
    }

    public boolean getBoolean (String name, boolean defaultValue) {
        String v = request.getParameter(name);
        if(v == null){
            return defaultValue;
        }
        v = v.trim().toLowerCase();
        if(v.equals("true") || v.equals("1") || v.equals("yes") || v.equals("y")){
            return true;
        }else if(v.equals("false") || v.equals("0") || v.equals("no") || v.equals("n")){
            return false;
        }else{
            return defaultValue;
        }
    }

    public Date getDate (String name, String pattern) {
        String v = request.getParameter(name);
        if(v == null || v.isEmpty()){
            return null;
        }

        try{
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            return sdf.parse(v.trim());
        }catch (ParseException e){
            throw new RuntimeException("Bad date format, expected: " + pattern);
        }
    }

    public File save(MultipartFile file, String path){
        if(file == null || path == null){
            return null;
        }

        ServletContext ctx = request.getServletContext();
        String realPath = ctx.getRealPath(path);
        File dir = new File(realPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String orig = file.getOriginalFilename(); // "avatar.png"
        String ext = "";
        if (orig != null && orig.contains(".")) {
            ext = orig.substring(orig.lastIndexOf(".") + 1);
        }
        String name = UUID.randomUUID() + "." + ext;
        File saved = new File(realPath, name);
        try {
            file.transferTo(saved);
        }catch(Exception e){
            throw new RuntimeException("Cannot save file", e);
        }
        return saved;
    }
}
