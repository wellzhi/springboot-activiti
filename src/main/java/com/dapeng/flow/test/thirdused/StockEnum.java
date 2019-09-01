package com.dapeng.flow.test.thirdused;

/**
 * 资产库存枚举类
 *
 * @author liuxz
 * @date 2019/08/30
 */
public enum StockEnum {
    /**
     * 地方、总部都无库存
     */
    NONE("地方和总部都无库存", 0),
    /**
     * 地方有库存
     */
    LOCAL("地方有库存", 1),
    /**
     * 总部有库存
     */
    HEAD("总部有库存", 2);

    private String name;
    private int index;

    private StockEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (StockEnum c : StockEnum.values()) {
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
        System.out.println(StockEnum.getName(0));
        System.out.println(StockEnum.getName(1));
        System.out.println(StockEnum.getName(2));
        System.out.println(StockEnum.NONE.index);
        System.out.println(StockEnum.LOCAL.index);
        System.out.println(StockEnum.HEAD.index);
    }
}
