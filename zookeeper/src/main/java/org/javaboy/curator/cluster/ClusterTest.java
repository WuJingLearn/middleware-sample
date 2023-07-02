package org.javaboy.curator.cluster;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;

public class ClusterTest {

    public static void main(String[] args) throws Exception {


        CuratorFramework client = ZkSlaveClient.client();

//
//        String stat = client.create().forPath("/clusterTest", "hello".getBytes());
//        System.out.println(stat);
        byte[] bytes = client.getData().forPath("/clusterTest");
        System.out.println("get data " + new String(bytes));


    }
}
