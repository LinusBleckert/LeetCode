package week5;

import com.sun.source.tree.Tree;
import java.util.*;

public class VertTravBinTree {


    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        recursionTraversal(map, root, 0);
        //List<>
        Set<Integer> keys = map.keySet();
        List<Integer> colIds = new ArrayList<>();

        keys.forEach(k -> colIds.add(k));
        //keys.stream().map(k -> colIds.add(k));
        Collections.sort(colIds);
        colIds.forEach(System.out::println);

        List<List<Integer>> result = new ArrayList<>();
        colIds.forEach(id -> result.add(map.get(id)));

        return result;
    }

    public static Map<Integer, List<Integer>> recursionTraversal(Map<Integer, List<Integer>> map, TreeNode root, int colI){

        // Adds value to map
        if(map.containsKey(colI))
            map.get(colI).add(root.val);
        else{
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(colI, list);
        }
        if(root.left != null)
            recursionTraversal(map, root.left, colI-1);
        if(root.right != null)
            recursionTraversal(map, root.right, colI+1);
        return map;
    }

    public static void printList(List<List<Integer>> list){
        //String str = "";
        System.out.print("[");
        list.forEach(l -> {
            System.out.print("[");
            l.forEach(l2 -> System.out.print(" " + l2 + " "));
            System.out.print("]");
        }  );

        System.out.print("]");

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        root.createExample1();
        List<List<Integer>> result = verticalTraversal(root);
        printList(result);

    }

}


