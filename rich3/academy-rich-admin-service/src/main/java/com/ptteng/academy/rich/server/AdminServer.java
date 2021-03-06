package com.ptteng.academy.rich.server;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tuscany.sca.node.SCANode;
import org.apache.tuscany.sca.node.SCANodeFactory;

/**
 * 服务启动类
 *
 * @author 
 */
public class AdminServer {
    private static Log log = LogFactory.getLog(AdminServer.class);
    private static SCANode node;

    /**
     * start account server.
     *
     * @throws java.io.IOException IOException
     */
    public void start() throws Exception {

       
            log.info("===> academy-rich-admin-service Start Begin");
      
    
        node = SCANodeFactory.newInstance().createSCANode("META-INF/academy-rich-admin-service/server.composite");
        node.start();
		
       
            log.info("===>academy-rich-admin-service");
            log.info("admin service success");
      
    }

    /**
     * exit system
     */
    public void exit() {
        System.exit(0);
    }

    public void run() throws InterruptedException {
        while (true) {
            Thread.sleep(Long.MAX_VALUE);
        }
    }

    /**
     * 服务启动程序.
     * @param args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        AdminServer server = new AdminServer();
        server.start();
        try {
            server.run();
            
        } catch (InterruptedException e) {
            log.error("academy-rich-admin-service server run error ", e);
        }
    }
}

