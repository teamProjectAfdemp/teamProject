package com.teamproject.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.Cookie;

public class CookieHandler {

    private static HashMap<Integer, String> idCookieMap = new HashMap<>();

    // retrieve the JSESSIONID cookie from the request cookies list
    public static String getCookie(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("JSESSIONID")) {
                return cookie.getValue();
            }
        }
        return null;
    }

    // validate existing cookie
    public static boolean validateCookie(Cookie[] cookies) {
        String cookie = getCookie(cookies);
        System.out.println(cookie);
        return (cookie != null) ? idCookieMap.containsValue(cookie) : false;
    }

    public static boolean validateCookie(int userId, Cookie[] cookies) {
        String cookie = getCookie(cookies);
        return (cookie == null) ? false : checkCookie(userId, cookie);
    }

    // after succesfull login check cookie and add it if does not exists
    // or match it with the existing one
    public static boolean checkCookie(int id, String cookieValue) {
        if (idCookieMap.containsKey(id)) {
            return (idCookieMap.get(id).equals(cookieValue));
        } else {
            idCookieMap.put(id, cookieValue);
            return true;
        }
    }

    // remove cookie from the list if it exists (sign out)
    public static boolean removeCookie(Cookie[] cookies) {
        String cookie = getCookie(cookies);
        if (cookie == null) {
            return false;
        }
        Iterator it = idCookieMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getValue().equals(cookie)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
