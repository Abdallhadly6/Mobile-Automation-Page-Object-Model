package com.calc.testcases;

import com.calc.base.Base;
import com.calc.pages.CalcOperationsPage;
import org.testng.annotations.Test;

public class CalcOperations extends Base {

    CalcOperationsPage calcOperationsPage;

    @Test
    public void multiply(){
        calcOperationsPage = new CalcOperationsPage();
        calcOperationsPage.clickButtons();
    }
}
