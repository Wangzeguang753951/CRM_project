package com.wzg.ssh.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/10.
 */
public class MD5UtilTest {

    @Test
    public void test(){
        System.out.println(MD5Util.getMd5("123456"));
    }

}