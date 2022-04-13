package top.baskbull;

import java.util.*;

/**
 * bfs + 优先队列
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //n座城市
        int n = in.nextInt();
        //m条道路
        int m = in.nextInt();
        int[] w = new int[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //i城的开放时间
            w[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            //进入i城的休整时间
            p[i] = in.nextInt();
        }
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            //起点
            int u = in.nextInt();
            //终点
            int v = in.nextInt();
            //花费c小时
            int c = in.nextInt();
            if (map.containsKey(u)) {
                map.get(u).add(new Node(v, c));
            } else {
                ArrayList<Node> list = new ArrayList<>();
                list.add(new Node(v, c));
                map.put(u, list);
            }
            //双向
            if (map.containsKey(v)) {
                map.get(v).add(new Node(u, c));
            } else {
                ArrayList<Node> list = new ArrayList<>();
                list.add(new Node(u, c));
                map.put(v, list);
            }
        }
        //当前在s
        int s = in.nextInt();
        //目标去t
        int t = in.nextInt();
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.c - o2.c;
            }
        });
        queue.add(new Node(s, 0));
        int[] vit = new int[n + 1];
        int res = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            //起点
            int x = poll.v;
            //如果到了终点
            if (x == t) {
                res = poll.c;
                System.out.println(res);
                return;
            }
            //到过了
            if (vit[x] == 1) {
                continue;
            }
            vit[x] = 1;
            if (map.containsKey(x)) {
                List<Node> list = map.get(x);
                for (Node node : list) {
                    if (vit[node.v] == 1) {
                        continue;
                    }
                    int temp = poll.c + node.c;
                    if (node.v != t) {
                        //开放点时间
                        if (temp % w[node.v] == 0) {
                            temp += p[node.v];
                        } else {
                            int b = temp % w[node.v];
                            temp += w[node.v] - b + p[node.v];
                        }
                    }
                    queue.add(new Node(node.v, temp));
                }
            }
        }
        System.out.println(-1);
    }
}

class Node {
    int v, c;

    Node(int v, int c) {
        this.v = v;
        this.c = c;
    }
}
