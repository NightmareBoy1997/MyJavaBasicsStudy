package org.javasm.supermarket.menu;

import org.javasm.supermarket.bean.Member;
import org.javasm.supermarket.server.MemberService;
import org.javasm.supermarket.server.impl.MemberServiceImpl;
import org.javasm.supermarket.util.CacheUtil;
import org.javasm.supermarket.util.FileUploadingUtil;
import org.javasm.supermarket.util.InputUtil;
import org.javasm.supermarket.util.LimitUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.menu
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-19 17:20
 */
public class MemberMenu {
    private static final MemberService memberService = new MemberServiceImpl();


    public static void main(String[] args) {
        new MemberMenu().menu();
    }


    public void menu() {
        String isGo;
        try {
            do {
                System.out.println("\n--->  << 会员管理 >>");
                System.out.println("1. 添加会员信息");
                System.out.println("2. 修改会员信息");
                System.out.println("3. 删除会员信息");
                System.out.println("4. 查询会员信息");
                System.out.println("5. 会员余额充值");
                System.out.println("6. 退   出");
                System.out.print("请选择要进行的操作：");

                int number = InputUtil.nextInt("^[1-6]$");
                switch (number) {
                    case 1:
                        System.out.println("--> 1. 添加会员信息");
                        addMemberFunction();
                        break;
                    case 2:
                        updateMemberFunction();
                        System.out.println("--> 2. 修改会员信息");
                        break;
                    case 3:
                        System.out.println("--> 3. 删除会员信息");
                        deleteMemberFunction();
                        break;
                    case 4:
                        System.out.println("--> 4. 查询会员信息");
                        showMemberLimitFunction();
                        break;
                    case 5:
                        System.out.println("--> 5. 会员余额充值");
                        rechargeAmount();
                        break;
                    case 6:
                        System.out.println("<---  << 会员管理 >>");
                        return;
                }

                System.out.print("是否继续进行会员管理？y/n: ");
                isGo = InputUtil.next("^[y|n|Y|N]$");
            } while ("y".equalsIgnoreCase(isGo));
        } finally {
            // 更新缓存库
            CacheUtil.updateCache(Member.class);
        }
    }

    private void rechargeAmount() {
        System.out.print("请输入要充值的会员id： ");
        int memberId = InputUtil.nextInt();
        final List<Member> allMember = memberService.findAllMember().stream().filter(m->m.getId().equals(memberId)).collect(Collectors.toList());
        if(allMember.isEmpty()){
            System.out.println("不存在此会员！");
            return;
        }
        Member member = allMember.get(0);
        System.out.print("请输入充值的金额： ");
        Double money = InputUtil.nextDouble();
        BigDecimal balance = member.getBalance().add(new BigDecimal(money.toString()) ) ;
        member.setBalance(balance);
        memberService.updateMember(member);
        System.out.println("充值成功！");
    }

    private void updateMemberFunction() {
        updateAndDeleteFunction("修改");
    }

    private void deleteMemberFunction() {
        updateAndDeleteFunction("删除");
    }


    private void updateAndDeleteFunction(String function) {
        final int size = 3;
        final List<Member> allMember = memberService.findAllMember();

        int total = LimitUtil.getTotal(allMember, size);
        int page = 1;
        int inputNumber;

        flag:
        while (true) {
            System.out.println("第 << " + page + " >> 页会员信息如下：");
            memberService.selectMemberByPage(page, size).stream().forEach(System.out::println);;

            inputNumber = LimitUtil.selectLimitFunction(page, total);

            switch (inputNumber) {
                case 1:
                    System.out.println("请输入要操作的会员id: ");
                    int id = InputUtil.nextInt();
                    final List<Member> idMember = allMember.stream().filter(m -> m.getId().equals(id)).collect(Collectors.toList());
                    if (idMember.isEmpty()) {
                        System.out.println("输入的会员id不存在! ");
                        break;
                    }
                    Member member = idMember.get(0);
                    if ("删除".equals(function)) {
                        memberService.addAndDeleteMember(idMember.get(0));
                        System.out.println("删除 << " + member.getName() + " >> 成功");
                    }
                    if ("修改".equals(function)) {
                        updateBranch(idMember.get(0));
                        System.out.println("修改 << " + member.getName() + " >> 成功");
                    }
                    return;
                case 2:
                    break flag;
                case 3:
                    page = 1;
                    break;
                case 4:
                    page -= 1;
                    break;
                case 5:
                    page += 1;
                    break;
                case 6:
                    page = total;
                    break;
            }
        }
    }


    private boolean updateBranch(Member member) {
        System.out.println("1. 修改密码");
        System.out.println("2. 修改手机号");
        System.out.println("3. 更新图片");
        System.out.print("请选择要修改的内容(1-3)： ");
        int number = InputUtil.nextInt("^[1-3]$");
        switch (number) {
            case 1:
                System.out.print("请输入新密码: ");
                String password = InputUtil.next();
                if (member.getPassword().equals(password)) {
                    System.out.println("与原密码一致，无需修改！");
                    return false;
                }
                if (!Objects.nonNull(password)) {
                    System.out.println("不能设为空密码！");
                    return false;
                }
                member.setPassword(password);
                break;
            case 2:
                System.out.print("请输入新手机号: ");
                String phone = InputUtil.next("^1[3-9]\\d{9}$");
                if (member.getPassword().equals(phone)) {
                    System.out.println("与原号码一致，无需修改！");
                    return false;
                }
                member.setPhone(phone);
                break;
            case 3:
                System.out.print("请输入要上传图片的路径：");
                String path = InputUtil.next();
                String uploadPath = FileUploadingUtil.uploadImage(path);
                if (uploadPath == null) {
                    System.out.println("文件不存在！");
                    return false;
                }
                member.setUserImage(uploadPath);
        }
        memberService.updateMember(member);
        return true;
    }


    private void addMemberFunction() {
        System.out.print("请输入要添加的会员账户： ");
        String memberUser = InputUtil.next();
        System.out.print("请输入账户的密码： ");
        String memberPassword = InputUtil.next();

        Member member = new Member();
        member.setName(memberUser);
        member.setPassword(memberPassword);

        memberService.addAndDeleteMember(member);
        System.out.println("添加 << " + memberUser + " >>");
    }


    private void showMemberLimitFunction() {
        final int size = 3;
        final List<Member> allMember = memberService.findAllMember();

        int total = LimitUtil.getTotal(allMember, size);
        int page = 1;
        int inputNumber;

        flag:
        while (page <= total) {
            System.out.println("第 << " + page + " >> 页会员信息如下：");
            memberService.selectMemberByPage(page, size).stream().forEach(System.out::println);

            inputNumber = LimitUtil.selectLimitQuery(page, total);

            switch (inputNumber) {
                case 1:
                    break flag;
                case 2:
                    page = 1;
                    break;
                case 3:
                    page -= 1;
                    break;
                case 4:
                    page += 1;
                    break;
                case 5:
                    page = total;
                    break;
            }
        }


    }


}