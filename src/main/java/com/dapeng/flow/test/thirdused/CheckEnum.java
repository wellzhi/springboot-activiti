package com.dapeng.flow.test.thirdused;

/**
 * 审批枚举类
 *
 * @author liuxz
 * @date 2019/08/30
 */
public enum CheckEnum {
    /**
     * 审批同意
     */
    OK("同意", 1),
    /**
     * 审批拒绝
     */
    NO("拒绝", 0);

    private String name;
    private int index;

    private CheckEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (CheckEnum c : CheckEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        System.out.println(CheckEnum.getName(1));
        System.out.println(CheckEnum.getName(0));
        System.out.println(CheckEnum.OK.index);
        System.out.println(CheckEnum.NO.index);
    }
}
