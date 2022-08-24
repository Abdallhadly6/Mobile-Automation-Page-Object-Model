package com.calc.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CalcTestListener implements ITestListener{

    public void OnTestFailure(ITestResult result){
        if(result.getThrowable() != null){
            StringWriter swr = new StringWriter();
            PrintWriter pwr = new PrintWriter(swr);
            result.getThrowable().printStackTrace(pwr);
            System.out.println(pwr.toString());


        }

    }
}
