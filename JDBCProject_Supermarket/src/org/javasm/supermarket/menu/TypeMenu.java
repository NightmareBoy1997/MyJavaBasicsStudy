package org.javasm.supermarket.menu;

import org.javasm.supermarket.bean.Type;
import org.javasm.supermarket.server.TypeService;
import org.javasm.supermarket.server.impl.TypeServiceImpl;
import org.javasm.supermarket.util.InputUtil;
import org.javasm.supermarket.util.QueryCacheUtil;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 14:20
 */
public class TypeMenu {
    private final static TypeService typeService = new TypeServiceImpl();


    /**
     * 类型管理菜单
     */
    public void menu() {
        try {
            String isGo;
            do {
                System.out.println("\n--->  << 类型管理 >> ");
                System.out.println("1.新增类型");
                System.out.println("2.修改类型");
                System.out.println("3.删除类型");
                System.out.println("4.类型层级查询");
                System.out.println("5.退 出");

                System.out.print("请选择要进行的操作： ");
                int inputNumber = InputUtil.nextInt("^[1-5]$");
                switch (inputNumber) {
                    case 1:
                        System.out.println("--> 1. 新增类型");
                        addTypeFun();
                        break;
                    case 2:
                        System.out.println("--> 2. 修改类型");
                        updateTypeFun();
                        break;
                    case 3:
                        System.out.println("--> 3. 删除类型");
                        deleteTypeFun();
                        break;
                    case 4:
                        System.out.println("--> 4. 类型层级查询");
                        showTypeByLevel();
                        break;
                    case 5:
                        System.out.println("<---  << 类型管理 >> ");
                        return;
                    default:
                        break;
                }
                System.out.print("是否继续进行类型管理操作？y/n: ");
                isGo = InputUtil.next("^[y|n|Y|N]$");
                System.out.println();
            } while ("y".equalsIgnoreCase(isGo));
        } finally {
            // 更新缓存库
            QueryCacheUtil.updateCache(Type.class);
        }
    }

    /**
     * 删除功能
     */
    private void deleteTypeFun() {
        typeService.findAllType();
        System.out.println("请输入要删除的类型id");
        int typeId = InputUtil.nextInt();

        if (typeService.deleteType(typeId)) {
            System.out.println("删除类型id <<" + typeId + ">> 成功");
        }
        // 更新缓存库
        QueryCacheUtil.updateCache(Type.class);
    }

    /**
     * 展示功能
     */
    private void showTypeByLevel() {
        System.out.println("类型信息展示如下： ");
        typeService.findAllType();
    }


    /**
     * 添加功能
     */
    private void addTypeFun() {
        System.out.println("请录入新的类型的名称:");
        String name = InputUtil.next();
        typeService.findAllType();
        System.out.println("请指定该<<" + name + ">>类型的父级类型:(作为1级类型 请给0)");
        int prentId = InputUtil.nextInt();
        Type type = new Type();
        type.setPrentId(prentId);
        type.setTypeName(name);
        final boolean succeed = typeService.addType(type);
        if (succeed) {
            System.out.println("新增<<" + name + ">> 类型成功");
        }
    }


    /**
     * 修改功能
     */
    private void updateTypeFun() {
        typeService.findAllType();
        String isGo ;
        do {
            System.out.print("请输入要修改的商品类型id： ");
            int id = InputUtil.nextInt();
            Type type = new Type();
            type.setId(id);

            System.out.println("\n1.修改类型名称");
            System.out.println("2.修改上级类型id");
            System.out.print("请选择要修改的信息(1-2): ");
            int i = InputUtil.nextInt("^[1|2]$");

            if (i == 1) {
                System.out.println("请输入新的商品类型名称：");
                String name = InputUtil.next();
                type.setTypeName(name);
            } else {
                System.out.println("请输入要关联的上级类型id：");
                Integer newPrentId = InputUtil.nextInt();
                type.setPrentId(newPrentId);
            }
            final boolean succeed = typeService.updateType(type);
            if (succeed) {
                System.out.println("修改类型成功");
            }
            System.out.print("是否继续进行修改操作？y/n: ");
            isGo = InputUtil.next("^[y|n|Y|N]$");
        } while ("y".equalsIgnoreCase(isGo));
    }


}