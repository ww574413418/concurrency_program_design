package com.zc.concurrency_program_design.concurrency_program_design.dining_philosophers_problem;

/**
 * 餐具类
 * @author Grubby
 * @date 2018/12/20
 */
public class TableWare {

    private final String toolName;

    public TableWare(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String toString() {
        return "TableWare{" +
                "toolName='" + toolName + '\'' +
                '}';
    }
}
