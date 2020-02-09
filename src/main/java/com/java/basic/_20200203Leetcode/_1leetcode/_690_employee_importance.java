package com.java.basic._20200203Leetcode._1leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/2/9.
 */
public class _690_employee_importance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        // 重要度
        public int importance;
        // the id of direct subordinates
        // 子员工
        public List<Integer> subordinates;
    };

    Map<Integer,Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {

        emap=new HashMap<>();
        for (Employee employee : employees) {
            emap.put(employee.id,employee);
        }
        return dfs(queryid);
    }

    //深度优先
    private int dfs(int queryid) {
        Employee employee=emap.get(queryid);
        int ans=employee.importance;
        for(Integer subid:employee.subordinates){
            ans+=dfs(subid);
        }
//        return 0;
        return ans;
    }
}
