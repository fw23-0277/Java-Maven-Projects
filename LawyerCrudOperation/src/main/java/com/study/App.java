package com.study;

import com.study.ui.UIMain;
import com.study.utility.DBUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DBUtils.createLawyerTable();
        UIMain.displayUIMenu();
    }
}
