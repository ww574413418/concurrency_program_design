package com.zc.concurrency_program_design.concurrency_program_design.dining_philosophers_problem;

/**
 * 将 left 和right 餐具组成一双
 * 解决可能会发生的死锁问题
 * @author Grubby
 * @date 2018/12/20
 */
public class TableWarePair {

    /**
     * 左边餐具
     */
    private final TableWare  leftTool;
    /**
     * 右边餐具
     */
    private final TableWare rightTool;

    public TableWarePair(TableWare leftTool, TableWare rightTool) {
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    public TableWare getLeftTool() {
        return leftTool;
    }

    public TableWare getRightTool() {
        return rightTool;
    }
}
