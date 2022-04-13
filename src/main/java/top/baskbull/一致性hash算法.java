package top.baskbull;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author liuzhuo
 * @date 2022/4/9 3:42 下午
 */
public class 一致性hash算法 {

    private JdkHashCodeStrategy hashStrategy = new JdkHashCodeStrategy();

    private final static int VIRTUAL_NODE_SIZE = 10;
    private final static String VIRTUAL_NODE_SUFFIX = "&&";

    public Server select(List<Server> servers, MyInvocation myInvocation) {
        int invocationHashCode = hashStrategy.getHashCode(myInvocation.getHashKey());
        TreeMap<Integer, Server> ring = buildConsistentHashRing(servers);
        Server server = locate(ring, invocationHashCode);
        return server;
    }

    private Server locate(TreeMap<Integer, Server> ring, int invocationHashCode) {
        // 向右找到第一个 key
        Map.Entry<Integer, Server> locateEntry = ring.ceilingEntry(invocationHashCode);
        if (locateEntry == null) {
            // 想象成一个环，超过尾部则取第一个 key
            locateEntry = ring.firstEntry();
        }
        return locateEntry.getValue();
    }

    private TreeMap<Integer, Server> buildConsistentHashRing(List<Server> servers) {
        TreeMap<Integer, Server> virtualNodeRing = new TreeMap<>();
        for (Server server : servers) {
            for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
                // 新增虚拟节点的方式如果有影响，也可以抽象出一个由物理节点扩展虚拟节点的类
                virtualNodeRing.put(hashStrategy.getHashCode(server.getUrl() + VIRTUAL_NODE_SUFFIX + i), server);
            }
        }
        return virtualNodeRing;
    }

//    public void testDistribution() {
//        List<Server> servers = new ArrayList<>();
//        for (String ip : ips) {
//            servers.add(new Server(ip+":8080"));
//        }
//        LoadBalancer chloadBalance = new ConsistentHashLoadBalancer();
//        // 构造 10000 随机请求
//        List<Invocation> invocations = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            invocations.add(new Invocation(UUID.randomUUID().toString()));
//        }
//        // 统计分布
//        AtomicLongMap<Server> atomicLongMap = AtomicLongMap.create();
//        for (Server server : servers) {
//            atomicLongMap.put(server, 0);
//        }
//        for (Invocation invocation : invocations) {
//            Server selectedServer = chloadBalance.select(servers, invocation);
//            atomicLongMap.getAndIncrement(selectedServer);
//        }
//        System.out.println(StatisticsUtil.variance(atomicLongMap.asMap().values().toArray(new Long[]{})));
//        System.out.println(StatisticsUtil.standardDeviation(atomicLongMap.asMap().values().toArray(new Long[]{})));
//    }
}

class Server {
    public Server() {
    }

    public Server(String url) {
        this.url = url;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

class MyInvocation {
    public MyInvocation() {
    }

    public MyInvocation(String hashKey) {
        this.hashKey = hashKey;
    }

    private String hashKey;

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}

class JdkHashCodeStrategy {

    public int getHashCode(String origin) {
        return origin.hashCode();
    }
}
