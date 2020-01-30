package com.java.basic._20200127_datastructure_algorithm._7GreedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Administrator on 2020/1/30.
 * 贪婪算法
 */
public class Greedy {
    public static void main(String[] args) {
        //创建广播电台
        HashMap<String ,HashSet<String>> brodcasts=new HashMap<String ,HashSet<String>>();
        //各个电台
        HashSet<String> hashSet1=new HashSet<String >();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2=new HashSet<String >();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3=new HashSet<String >();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4=new HashSet<String >();
        hashSet4.add("上海");
//        hashSet1.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5=new HashSet<String >();
        hashSet5.add("杭州");
        hashSet5.add("大连");
//        hashSet1.add("天津");
        //添加到集合中
        brodcasts.put("K1",hashSet1);
        brodcasts.put("K2",hashSet2);
        brodcasts.put("K3",hashSet3);
        brodcasts.put("K4",hashSet4);
        brodcasts.put("K5",hashSet5);
        //===================================================================

        //所有目标区域
        HashSet<String> allareas=new HashSet<String>();
        allareas.add("北京");
        allareas.add("上海");
        allareas.add("天津");
        allareas.add("广州");
        allareas.add("深圳");
        allareas.add("成都");
        allareas.add("杭州");
        allareas.add("大连");
//        allareas.add("北京");
        //===================================================================

        //创建Arraylist，存放选择的电台集合
        ArrayList<String> selects=new ArrayList<String>();
        //临时集合：存放遍历过程中，电台覆盖和目标剩余覆盖的交集
        HashSet<String> tempSet=new HashSet<>();

        //===================================================================
        //迭代
        //maxKey保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台的key
        //如果maxKey不为nul1，则会加入到selects
        String maxKey=null;

        //当没有覆盖完全的时候，坚持迭代
        while (allareas.size()!=0){
            //每次都置为空
            maxKey=null;

            //遍历broadcasts，取出对应key
            for (String key:brodcasts.keySet()){
                //每次清空
                tempSet.clear();

                //当前这个key能够覆盖的地区
                HashSet<String> areas= brodcasts.get(key);
                //付给临时变量
                tempSet.addAll(areas);
                //retainAll：求出两者交集，并且赋给调用对象即tempSet
                tempSet.retainAll(allareas);

//                HashSet<String> tempallSet=new HashSet<String>();
//                tempallSet.addAll(brodcasts.get(maxKey));
//                tempallSet.retainAll(allareas);
//                int temp= tempallSet.size();

                //========================================================================
                //问题和解决
                /**
                 * 【疑问：】总感觉有brodcasts.get(maxKey)问题，比较不应当比较这个全集的
                 * 验证：
                 * allareas不去掉天津，结果：选择结果是：[K1, K2, K3, K5]
                 * allareas去掉天津，结果：选择结果是：[K1, K2, K3, K5]
                 * 所以，这个算法实现是有问题的，问题就在tempSet.size()，不应当与brodcasts.get(maxKey).size()比较，
                 * 而应当和brodcasts.get(maxKey)所有的集合和allareas交集的比较
                 */
                //
                //如果当前这个集合包含的未覆盖地区的数量，比maxkey指向的集合地区还多,则就需要重置maxKey
                //tempSet.size()>brodcasts.get(maxKey).size(),体现贪婪算法，每次都选择最优解
//                if(tempSet.size()>0&&(maxKey==null|| tempSet.size()>brodcasts.get(maxKey).size())){
//                    maxKey=key;
//                }


                //解决：
                HashSet<String> tempallSet=new HashSet<String>();
                if(maxKey==null){
                    tempallSet.addAll(brodcasts.get(key));
                    tempallSet.retainAll(allareas);
                }else {
                    tempallSet.addAll(brodcasts.get(maxKey));
                    tempallSet.retainAll(allareas);
                }
                int maxSizetemp= tempallSet.size();

                if(tempSet.size()>0&&(maxKey==null|| tempSet.size()>maxSizetemp)){
                    maxKey=key;
                }

                /**
                 * 验证：【success！】
                 * allareas不去掉天津，结果：选择结果是：[K1, K2, K3, K5]
                 * allareas去掉天津，结果：选择结果是：[K2, K3, K5]
                 */
                //========================================================================

            }
            //
            if(maxKey!=null){
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区，从allAreas去掉
                allareas.removeAll(brodcasts.get(maxKey));
            }

        }
        System.out.println("选择结果是："+selects);

    }
}
