package treeCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/21 13:46
 * @Description:
 */

public class ApplicationStart {
    //模拟菜单表中的所有数据
    static int times = 0;
    static List<Tree> list  =new ArrayList<>();
    static {
        Tree l0 = new Tree(1,"北京市",0,1);
          Tree l2 = new Tree(3,"朝阳区",1,2);
            Tree l3 = new Tree(5,"西二旗南街",3,3);
              Tree l01 = new Tree(12,"四号大院",5,4);
               Tree l02 = new Tree(13,"三号楼",12,5);
               Tree l03 = new Tree(14,"四号楼",12,5);

               Tree l4 = new Tree(6,"大望路",3,3);
               Tree l5 = new Tree(7,"南磨房路",3,3);
          Tree l6 = new Tree(4,"海淀区",1,2);
          Tree l61 = new Tree(8,"西北旺",4,3);
          Tree l62 = new Tree(9,"安河家园",4,3);

          Tree l1 = new Tree(2,"青岛市",0,1);
          Tree l11 = new Tree(15,"黄岛区",2,2);
          Tree l12 = new Tree(16,"崂山区",2,2);

        list.add(l0);
        list.add(l2);
        list.add(l3);
        list.add(l01);
        list.add(l02);
        list.add(l03);
        list.add(l4);
        list.add(l5);
        list.add(l6);
        list.add(l61);
        list.add(l62);
        list.add(l1);
        list.add(l11);
        list.add(l12);
    }

    //判断是否存在子集目录

    private static boolean ifExistChild (List<Tree> list,int pId){
       Boolean sysbol = false;
        for (Tree tree : list) {
            times++;
            if (tree.getParentId() == pId) {
                sysbol = true;
                break;
            }
        }
        return sysbol;
    }

    private static List<Tree> getChildList(List<Tree> list,int pId,List<Tree> reList) {
        for (Tree testEntity : list) {
            times++;
            if (testEntity.getParentId()==pId) {//查询下级菜单
                reList.add(testEntity);
                if (ifExistChild(list, testEntity.getId())) {
                    getChildList(list, testEntity.getId(), reList);
                }
            }
        }
        return reList;
    }

        public static void main(String[] args) {
        List<Tree> resultList = new ArrayList<>();
        System.out.println("输出前集合的大小为：" + list.size());
        long startTime = System.currentTimeMillis();
            for (Tree result: list) {
                times ++;
                if (result.getParentId() == 0){  //从父级开始添加
                    resultList.add(result);
                    if (ifExistChild(resultList,result.getParentId())){
                        List<Tree> childs = new ArrayList<>();
                        childs = getChildList(list,result.getParentId(),childs);
                        resultList.addAll(childs);
                    }
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("查询后的集合大小" + resultList.size());
            System.out.println("查询的次数：" + times);
            System.out.println("查询的所用时间：" + (endTime-startTime));
            for (Tree res:resultList) {
                String s = "";
                for (int i = 0; i < res.getLevel(); i++) {
                    s = s + "\t"; //级别是多少就空多少格，很牛皮
                }
                System.out.println(s + "I____" + res.getName());
            }


    }


}
